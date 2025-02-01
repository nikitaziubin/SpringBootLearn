package com.learn.springboot.web_api_lesson;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class KafkaProducer {
	public static final String FIRS_TOPIC = "firs-topic";
	@Resource
	KafkaTemplate<String, String> kafkaTemplate;
	@Resource
	KafkaTemplate<String, Info> kafkaTemplate2;
	
	
	
	public void send(String message) {
		kafkaTemplate.send(FIRS_TOPIC, "1", message);
		log.info("The message was sent by the producer: {}", message);
	}
	
	public void send(Info messageInfo) {
		kafkaTemplate2.send(FIRS_TOPIC, "1", messageInfo);
		log.info("The message was sent by the producer: {}", messageInfo);
	}
	
	@Scheduled(fixedDelay = 10000)
	public void send() {
		send("Sheduled message");
	}
	
}
