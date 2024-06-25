package com.yuri.avaliadorcredito.dto;

public class EmissaoCartaoResponse {
	private String protocolo;

	public EmissaoCartaoResponse() {
	}

	public EmissaoCartaoResponse(String protocolo) {
		this.protocolo = protocolo;
	}

	public String getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}
}
