package com.ay.apps.kafka;

import java.io.IOException;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class KafkaConsumer {

	@KafkaListener(topics = "${apps.topic-1}", groupId = "${apps.group.id}")
	public void consume(String message) throws IOException, InterruptedException {

		log.info(String.format("#### -> Consumed message -> %s ", message));

	}
	
}