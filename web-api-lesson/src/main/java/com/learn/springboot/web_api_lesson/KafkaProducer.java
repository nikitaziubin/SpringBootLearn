package com.learn.springboot.web_api_lesson;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class KafkaProducer {
	@Resource
	KafkaTemplate<String, String> kafkaTemplate;
	
	public void send(String message) {
		kafkaTemplate.send("firs-topic", "1", message);
		log.info("The message was sent by the producer: {}", message);
	}
	
}
