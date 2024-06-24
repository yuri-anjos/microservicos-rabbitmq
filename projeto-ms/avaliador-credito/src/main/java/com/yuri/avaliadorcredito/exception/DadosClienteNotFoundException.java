package com.yuri.avaliadorcredito.exception;

public class DadosClienteNotFoundException extends Exception {

	public DadosClienteNotFoundException(String message) {
		super("Dados do cliente não encontrados para o CPF informado!");
	}
}
