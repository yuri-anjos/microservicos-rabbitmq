package com.yuri.avaliadorcredito.dto;

import com.yuri.avaliadorcredito.model.CartaoCliente;
import com.yuri.avaliadorcredito.model.DadosCliente;

import java.util.List;

public class SituacaoClienteResponse {
	private DadosCliente cliente;
	private List<CartaoCliente> cartoes;

	public SituacaoClienteResponse() {
	}

	public DadosCliente getCliente() {
		return cliente;
	}

	public void setCliente(DadosCliente cliente) {
		this.cliente = cliente;
	}

	public List<CartaoCliente> getCartoes() {
		return cartoes;
	}

	public void setCartoes(List<CartaoCliente> cartoes) {
		this.cartoes = cartoes;
	}
}
