package com.yuri.cliente.dto;

import com.yuri.cliente.domain.Cliente;

public record SalvarClienteRequest(String cpf, String nome, Integer idade) {

	public Cliente toModel() {
		return new Cliente(cpf, nome, idade);
	}
}
