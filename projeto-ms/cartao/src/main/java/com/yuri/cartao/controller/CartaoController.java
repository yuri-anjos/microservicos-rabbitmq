package com.yuri.cartao.controller;

import com.yuri.cartao.domain.Cartao;
import com.yuri.cartao.dto.CartoesPorClienteResponse;
import com.yuri.cartao.dto.SalvarCartaoRequest;
import com.yuri.cartao.service.CartaoService;
import com.yuri.cartao.service.ClienteCartaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {

	private final Logger log = LoggerFactory.getLogger(CartaoController.class);

	private final CartaoService cartaoService;
	private final ClienteCartaoService clienteCartaoService;

	public CartaoController(CartaoService cartaoService, ClienteCartaoService clienteCartaoService) {
		this.cartaoService = cartaoService;
		this.clienteCartaoService = clienteCartaoService;
	}

	@GetMapping("/health")
	public String status() {
		log.info("Health Check!");
		return "ok";
	}

	@PostMapping
	public ResponseEntity<Void> salvarCartao(@RequestBody SalvarCartaoRequest body) {
		var cartao = body.toModel();
		cartaoService.save(cartao);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping(params = {"minRenda", "maxRenda"})
	public ResponseEntity<List<Cartao>> getCartoesIntervaloRenda(@RequestParam Long minRenda, @RequestParam Long maxRenda) {
		var list = cartaoService.getCartoesIntervaloRenda(minRenda, maxRenda);
		return ResponseEntity.ok(list);
	}

	@GetMapping(params = "cpf")
	public ResponseEntity<List<CartoesPorClienteResponse>> getCartoesByCliente(@RequestParam String cpf) {
		var list = clienteCartaoService.buscarCartoesPorCpf(cpf);
		return ResponseEntity.ok(list.stream().map(CartoesPorClienteResponse::new).toList());
	}
}
