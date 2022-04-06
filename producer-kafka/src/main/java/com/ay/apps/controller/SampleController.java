package com.ay.apps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/v1/sample")
@Log4j2
public class SampleController {


	@Value("${apps.topic-1}")
	private String topic;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@GetMapping("/produce-message")
	public String kf(String message) {
		
		kafkaTemplate.send(topic, message);

		log.info("Message sent "+message );
		
		return "OK";
	}
	
}
