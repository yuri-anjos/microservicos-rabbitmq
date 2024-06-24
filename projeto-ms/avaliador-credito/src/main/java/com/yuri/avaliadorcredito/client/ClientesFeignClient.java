package com.yuri.avaliadorcredito.client;

import com.yuri.avaliadorcredito.model.DadosCliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "cliente-service", path = "/clientes")
public interface ClientesFeignClient {

	@GetMapping
	ResponseEntity<DadosCliente> buscarClientePorCpf(@RequestParam String cpf);

}
