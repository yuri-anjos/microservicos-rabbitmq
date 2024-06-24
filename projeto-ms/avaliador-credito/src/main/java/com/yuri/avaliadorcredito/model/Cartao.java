package com.yuri.avaliadorcredito.model;

import java.math.BigDecimal;

public record Cartao(Long id,
					 String nome,
					 String bandeira,
					 BigDecimal renda,
					 BigDecimal limiteBasico) {

}
