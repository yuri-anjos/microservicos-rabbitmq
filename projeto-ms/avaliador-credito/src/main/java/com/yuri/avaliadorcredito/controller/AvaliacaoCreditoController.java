package com.yuri.avaliadorcredito.controller;

import com.yuri.avaliadorcredito.dto.DadosAvaliacaoRequest;
import com.yuri.avaliadorcredito.dto.DadosAvaliacaoResponse;
import com.yuri.avaliadorcredito.dto.SituacaoClienteResponse;
import com.yuri.avaliadorcredito.exception.DadosClienteNotFoundException;
import com.yuri.avaliadorcredito.exception.ErroComunicacaoFeignClientException;
import com.yuri.avaliadorcredito.service.AvaliacaoCreditoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/avaliacoes-credito")
public class AvaliacaoCreditoController {

	private final Logger log = LoggerFactory.getLogger(AvaliacaoCreditoController.class);

	private final AvaliacaoCreditoService avaliacaoCreditoService;

	public AvaliacaoCreditoController(AvaliacaoCreditoService avaliacaoCreditoService) {
		this.avaliacaoCreditoService = avaliacaoCreditoService;
	}

	@GetMapping("/health")
	public String status() {
		log.info("Health Check!");
		return "ok";
	}

	@GetMapping("/situacao-cliente")
	public ResponseEntity<SituacaoClienteResponse> getSituacaoCliente(@RequestParam String cpf) {
		try {
			var situacaoCliente = avaliacaoCreditoService.obterSituacaoCliente(cpf);
			return ResponseEntity.ok(situacaoCliente);
		} catch (DadosClienteNotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (ErroComunicacaoFeignClientException e) {
			return ResponseEntity.status(HttpStatus.resolve(e.getStatus())).build();
		}
	}

	@GetMapping
	public ResponseEntity<DadosAvaliacaoResponse> realizarAvaliacao(@RequestBody DadosAvaliacaoRequest body) {
		try {
			var dadosAvaliacaoResponse = avaliacaoCreditoService.realizarAvaliacaoCliente(body);
			return ResponseEntity.ok(dadosAvaliacaoResponse);
		} catch (DadosClienteNotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (ErroComunicacaoFeignClientException e) {
			return ResponseEntity.status(HttpStatus.resolve(e.getStatus())).build();
		}
	}
}
