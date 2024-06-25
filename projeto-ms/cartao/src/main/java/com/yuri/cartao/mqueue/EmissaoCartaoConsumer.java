package com.yuri.cartao.mqueue;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yuri.cartao.domain.ClienteCartao;
import com.yuri.cartao.dto.EmissaoCartaoRequest;
import com.yuri.cartao.repository.CartaoRepository;
import com.yuri.cartao.repository.ClienteCartaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EmissaoCartaoConsumer {

	private final Logger log = LoggerFactory.getLogger(EmissaoCartaoConsumer.class);
	private final CartaoRepository cartaoRepository;
	private final ClienteCartaoRepository clienteCartaoRepository;

	public EmissaoCartaoConsumer(CartaoRepository cartaoRepository, ClienteCartaoRepository clienteCartaoRepository) {
		this.cartaoRepository = cartaoRepository;
		this.clienteCartaoRepository = clienteCartaoRepository;
	}

	@RabbitListener(queues = "${mq.queues.emissao-cartao}")
	public void receberSolicitacaoEmissaoCartao(String payload) {
		try {
			log.info("Payload: {}", payload);
			var mapper = new ObjectMapper();
			var solicitacao = mapper.readValue(payload, EmissaoCartaoRequest.class);

			var cartao = cartaoRepository.findById(solicitacao.getCartaoId()).orElseThrow();
			var clienteCartao = new ClienteCartao();
			clienteCartao.setCartao(cartao);
			clienteCartao.setCpf(solicitacao.getCpf());
			clienteCartao.setLimite(solicitacao.getLimiteLiberado());
			clienteCartaoRepository.save(clienteCartao);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
