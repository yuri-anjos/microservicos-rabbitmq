package com.yuri.cartao.dto;

import com.yuri.cartao.domain.ClienteCartao;

import java.math.BigDecimal;

public class CartoesPorClienteResponse {
	private final String nome;
	private final String bandeiraCartaoEnum;
	private final BigDecimal limite;

	public CartoesPorClienteResponse(ClienteCartao clienteCartao) {
		var cartao = clienteCartao.getCartao();
		this.nome = cartao.getNome();
		this.bandeiraCartaoEnum = cartao.getBandeira().toString();
		this.limite = clienteCartao.getLimite();
	}
}
