package com.yuri.cartao.dto;

import com.yuri.cartao.domain.BandeiraCartaoEnum;
import com.yuri.cartao.domain.Cartao;

import java.math.BigDecimal;

public record SalvarCartaoRequest(String nome, BandeiraCartaoEnum bandeira, BigDecimal renda, BigDecimal limite) {

	public Cartao toModel() {
		return new Cartao(nome, bandeira, renda, limite);
	}
}
