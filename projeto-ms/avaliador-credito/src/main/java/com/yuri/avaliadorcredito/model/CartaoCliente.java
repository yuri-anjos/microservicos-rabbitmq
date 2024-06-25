package com.yuri.avaliadorcredito.model;

import java.math.BigDecimal;

public class CartaoCliente {
	private String nome;
	private String bandeira;
	private BigDecimal limite;

	public CartaoCliente() {
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
