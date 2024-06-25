package com.yuri.cartao.dto;

import com.yuri.cartao.domain.ClienteCartao;

import java.math.BigDecimal;

public class CartoesPorClienteResponse {
	private String nome;
	private String bandeira;
	private BigDecimal limite;

	public CartoesPorClienteResponse() {}


	public CartoesPorClienteResponse(ClienteCartao clienteCartao) {
		var cartao = clienteCartao.getCartao();
		this.nome = cartao.getNome();
		this.bandeira = cartao.getBandeira().toString();
		this.limite = clienteCartao.getLimite();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public BigDecimal getLimite() {
		return limite;
	}

	public void setLimite(BigDecimal limite) {
		this.limite = limite;
	}
}
