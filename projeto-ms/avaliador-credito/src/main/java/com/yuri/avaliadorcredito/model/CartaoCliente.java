package com.yuri.avaliadorcredito.model;

import java.math.BigDecimal;

public class CartaoCliente {
	private String nome;
	private String bandeiraCartaoEnum;
	private BigDecimal limite;

	public CartaoCliente() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getBandeiraCartaoEnum() {
		return bandeiraCartaoEnum;
	}

	public void setBandeiraCartaoEnum(String bandeiraCartaoEnum) {
		this.bandeiraCartaoEnum = bandeiraCartaoEnum;
	}

	public BigDecimal getLimite() {
		return limite;
	}

	public void setLimite(BigDecimal limite) {
		this.limite = limite;
	}
}
