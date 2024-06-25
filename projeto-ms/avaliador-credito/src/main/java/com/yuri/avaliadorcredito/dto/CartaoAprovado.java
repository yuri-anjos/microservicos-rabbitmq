package com.yuri.avaliadorcredito.dto;

import java.math.BigDecimal;

public class CartaoAprovado {
	private Long id;
	private String cartao;
	private String bandeira;
	private BigDecimal limiteAprovado;

	public CartaoAprovado() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCartao() {
		return cartao;
	}

	public void setCartao(String cartao) {
		this.cartao = cartao;
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public BigDecimal getLimiteAprovado() {
		return limiteAprovado;
	}

	public void setLimiteAprovado(BigDecimal limiteAprovado) {
		this.limiteAprovado = limiteAprovado;
	}
}
