package com.yuri.cartao.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Cartao implements Serializable {

	@Serial
	private static final long serialVersionUID = 4462918370945893844L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@Enumerated(EnumType.STRING)
	private BandeiraCartaoEnum bandeira;
	private BigDecimal renda;
	private BigDecimal limiteBasico;

	public Cartao() {
	}

	public Cartao(String nome, BandeiraCartaoEnum bandeira, BigDecimal renda, BigDecimal limiteBasico) {
		this.nome = nome;
		this.bandeira = bandeira;
		this.renda = renda;
		this.limiteBasico = limiteBasico;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BandeiraCartaoEnum getBandeira() {
		return bandeira;
	}

	public void setBandeira(BandeiraCartaoEnum bandeira) {
		this.bandeira = bandeira;
	}

	public BigDecimal getRenda() {
		return renda;
	}

	public void setRenda(BigDecimal renda) {
		this.renda = renda;
	}

	public BigDecimal getLimiteBasico() {
		return limiteBasico;
	}

	public void setLimiteBasico(BigDecimal limiteBasico) {
		this.limiteBasico = limiteBasico;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Cartao cartao = (Cartao) o;
		return Objects.equals(id, cartao.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Cartao{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", bandeira=" + bandeira +
				", renda=" + renda +
				", limiteBasico=" + limiteBasico +
				'}';
	}
}
