package com.yuri.avaliadorcredito.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

	@Value("${mq.queues.emissaoCartao}")
	private String emissaoCartaoQueue;

	@Bean(name = "queueEmissaoCartao")
	public Queue queueEmissaoCartao() {
		return new Queue(emissaoCartaoQueue, Boolean.TRUE);
	}
}
