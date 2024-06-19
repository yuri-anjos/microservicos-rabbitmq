package com.yuri.cliente.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HealthController {

	private final Logger log = LoggerFactory.getLogger(HealthController.class);

	@GetMapping
	public String status() {
		log.info("Health Check!");
		return "ok";
	}
}
