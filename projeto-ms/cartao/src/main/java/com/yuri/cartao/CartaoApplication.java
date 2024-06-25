package com.yuri.cartao;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@EnableRabbit
@SpringBootApplication
public class CartaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartaoApplication.class, args);
	}

}
