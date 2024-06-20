package com.yuri.cartao.service;

import com.yuri.cartao.domain.Cartao;
import com.yuri.cartao.repository.CartaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CartaoService {

	private final CartaoRepository cartaoRepository;

	public CartaoService(CartaoRepository cartaoRepository) {
		this.cartaoRepository = cartaoRepository;
	}

	@Transactional
	public Cartao save(Cartao cartao) {
		return cartaoRepository.save(cartao);
	}

	public List<Cartao> getCartoesIntervaloRenda(Long minRenda, Long maxRenda) {
		return cartaoRepository.findByRendaBetween(
				BigDecimal.valueOf(minRenda),
				BigDecimal.valueOf(maxRenda)
		);
	}
}
