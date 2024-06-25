package com.yuri.avaliadorcredito.mqueue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yuri.avaliadorcredito.dto.EmissaoCartaoRequest;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class EmissaoCartaoProducer {

	private final RabbitTemplate rabbitTemplate;

	@Qualifier("queueEmissaoCartao")
	private final Queue queueEmissaoCartao;

	public EmissaoCartaoProducer(RabbitTemplate rabbitTemplate, Queue queueEmissaoCartao) {
		this.rabbitTemplate = rabbitTemplate;
		this.queueEmissaoCartao = queueEmissaoCartao;
	}

	public void solicitarCartao(EmissaoCartaoRequest emissaoCartaoRequest) throws JsonProcessingException {
		var json = convertIntoJson(emissaoCartaoRequest);
		rabbitTemplate.convertAndSend(queueEmissaoCartao.getName(), json);
	}

	private String convertIntoJson(EmissaoCartaoRequest data) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(data);
	}
}
