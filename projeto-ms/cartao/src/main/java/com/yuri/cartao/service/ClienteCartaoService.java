package com.yuri.cartao.service;

import com.yuri.cartao.domain.ClienteCartao;
import com.yuri.cartao.repository.ClienteCartaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteCartaoService {

	private final ClienteCartaoRepository clienteCartaoRepository;

	public ClienteCartaoService(ClienteCartaoRepository clienteCartaoRepository) {
		this.clienteCartaoRepository = clienteCartaoRepository;
	}

	public List<ClienteCartao> buscarCartoesPorCpf(String cpf){
		return clienteCartaoRepository.findByCpf(cpf);
	}
}
