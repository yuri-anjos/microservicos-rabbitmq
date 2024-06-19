package com.yuri.cliente.service;

import com.yuri.cliente.domain.Cliente;
import com.yuri.cliente.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClienteService {

	private final ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	@Transactional
	public Cliente save(Cliente cliente){
		return clienteRepository.save(cliente);
	}

	public Optional<Cliente> findByCpf(String cpf){
		return clienteRepository.findByCpf(cpf);
	}
}
