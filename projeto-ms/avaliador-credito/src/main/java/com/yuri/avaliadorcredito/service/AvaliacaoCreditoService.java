package com.yuri.avaliadorcredito.service;

import com.yuri.avaliadorcredito.client.CartoesFeignClient;
import com.yuri.avaliadorcredito.client.ClientesFeignClient;
import com.yuri.avaliadorcredito.dto.CartaoAprovado;
import com.yuri.avaliadorcredito.dto.DadosAvaliacaoRequest;
import com.yuri.avaliadorcredito.dto.DadosAvaliacaoResponse;
import com.yuri.avaliadorcredito.dto.EmissaoCartaoResponse;
import com.yuri.avaliadorcredito.dto.SituacaoClienteResponse;
import com.yuri.avaliadorcredito.dto.EmissaoCartaoRequest;
import com.yuri.avaliadorcredito.exception.DadosClienteNotFoundException;
import com.yuri.avaliadorcredito.exception.ErroComunicacaoFeignClientException;
import com.yuri.avaliadorcredito.exception.ErroSolicitacaoCartaoException;
import com.yuri.avaliadorcredito.mqueue.EmissaoCartaoProducer;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class AvaliacaoCreditoService {

	private final ClientesFeignClient clientesFeignClient;
	private final CartoesFeignClient cartoesFeignClient;
	private final EmissaoCartaoProducer emissaoCartaoProducer;

	public AvaliacaoCreditoService(ClientesFeignClient clientesFeignClient, CartoesFeignClient cartoesFeignClient, EmissaoCartaoProducer emissaoCartaoProducer) {
		this.clientesFeignClient = clientesFeignClient;
		this.cartoesFeignClient = cartoesFeignClient;
		this.emissaoCartaoProducer = emissaoCartaoProducer;
	}

	public SituacaoClienteResponse obterSituacaoCliente(String cpf) throws DadosClienteNotFoundException, ErroComunicacaoFeignClientException {
		try {
			var cliente = clientesFeignClient.buscarClientePorCpf(cpf).getBody();
			var cartoes = cartoesFeignClient.getCartoesByCliente(cpf).getBody();

			var situacaoCliente = new SituacaoClienteResponse();
			situacaoCliente.setCliente(cliente);
			situacaoCliente.setCartoes(cartoes);

			return situacaoCliente;
		} catch (FeignException ex) {
			var status = ex.status();
			if (HttpStatus.NOT_FOUND.value() == status) {
				throw new DadosClienteNotFoundException(cpf);
			}
			throw new ErroComunicacaoFeignClientException(ex.contentUTF8(), ex.status());
		}
	}

	public DadosAvaliacaoResponse realizarAvaliacaoCliente(DadosAvaliacaoRequest body) throws ErroComunicacaoFeignClientException, DadosClienteNotFoundException {
		try {
			var cliente = clientesFeignClient.buscarClientePorCpf(body.cpf()).getBody();
			var cartoes = cartoesFeignClient.getCartoesIntervaloRenda(0L, body.renda()).getBody();

			var cartoesAprovados = cartoes.stream().map(cartao -> {
				BigDecimal limiteBasico = cartao.limiteBasico();
				BigDecimal idade = BigDecimal.valueOf(cliente.idade());
				BigDecimal fator = idade.divide(BigDecimal.TEN);
				BigDecimal limiteAprovado = fator.multiply(limiteBasico);

				var cartaoAprovado = new CartaoAprovado();
				cartaoAprovado.setId(cartao.id());
				cartaoAprovado.setCartao(cartao.nome());
				cartaoAprovado.setBandeira(cartao.bandeira());
				cartaoAprovado.setLimiteAprovado(limiteAprovado);
				return cartaoAprovado;
			}).toList();
			return new DadosAvaliacaoResponse(cartoesAprovados);
		} catch (FeignException ex) {
			var status = ex.status();
			if (HttpStatus.NOT_FOUND.value() == status) {
				throw new DadosClienteNotFoundException(body.cpf());
			}
			throw new ErroComunicacaoFeignClientException(ex.contentUTF8(), ex.status());
		}
	}

	public EmissaoCartaoResponse solicitarEmissaoCartao(EmissaoCartaoRequest emissaoCartaoRequest) {
		try {
			emissaoCartaoProducer.solicitarCartao(emissaoCartaoRequest);
			var protocolo = UUID.randomUUID().toString();
			return new EmissaoCartaoResponse(protocolo);
		} catch (Exception e) {
			throw new ErroSolicitacaoCartaoException(e.getMessage());
		}
	}
}
