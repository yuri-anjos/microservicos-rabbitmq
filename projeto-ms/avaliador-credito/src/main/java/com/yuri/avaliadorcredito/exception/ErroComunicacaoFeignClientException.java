package com.yuri.avaliadorcredito.exception;

import org.springframework.http.HttpStatus;

public class ErroComunicacaoFeignClientException extends Exception {

	private final Integer status;

	public ErroComunicacaoFeignClientException(String message, int status) {
		super(message);
		this.status = status == 0 ? HttpStatus.NOT_FOUND.value() : status;
	}

	public Integer getStatus() {
		return status;
	}
}
