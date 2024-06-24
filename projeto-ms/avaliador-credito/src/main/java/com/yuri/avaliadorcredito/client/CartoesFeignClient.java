package com.yuri.avaliadorcredito.client;

import com.yuri.avaliadorcredito.model.CartaoCliente;
import com.yuri.avaliadorcredito.model.Cartao;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "cartao-service", path = "/cartoes")
public interface CartoesFeignClient {

	@GetMapping(params = "cpf")
	ResponseEntity<List<CartaoCliente>> getCartoesByCliente(@RequestParam String cpf);

	@GetMapping(params = {"minRenda", "maxRenda"})
	ResponseEntity<List<Cartao>> getCartoesIntervaloRenda(@RequestParam Long minRenda, @RequestParam Long maxRenda);

}
