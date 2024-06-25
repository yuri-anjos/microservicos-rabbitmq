package com.yuri.cartao.dto;

import java.math.BigDecimal;

public class EmissaoCartaoRequest {
	private Long cartaoId;
	private String cpf;
	private String endereco;
	private BigDecimal limiteLiberado;

	public EmissaoCartaoRequest() {
	}

	public Long getCartaoId() {
		return cartaoId;
	}

	public void setCartaoId(Long cartaoId) {
		this.cartaoId = cartaoId;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public BigDecimal getLimiteLiberado() {
		return limiteLiberado;
	}

	public void setLimiteLiberado(BigDecimal limiteLiberado) {
		this.limiteLiberado = limiteLiberado;
	}
}
