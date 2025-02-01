package com.learn.springboot.web_api_lesson;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class Reciever {
	
	@KafkaListener(topics = KafkaProducer.FIRS_TOPIC)
	public void listen(Object message) {
		log.info("The message from from consumer`s consumer {} is {}", KafkaProducer.FIRS_TOPIC, message);
	}
	
}
