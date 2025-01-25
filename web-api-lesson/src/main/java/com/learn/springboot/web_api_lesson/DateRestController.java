package com.learn.springboot.web_api_lesson;

import java.util.Date;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class DateRestController {
	@Resource
	InfoPersistance infoPersistance;

	@Resource
	KafkaProducer kafkaProducer;
	
	@GetMapping("/date")
	public Date getDate() {
		Date result = new Date();
		log.info("get date: {} {}", result, new Date());		
		return result;
	}

	@GetMapping("/guid")
	public String getGuid() {
		String result = UUID.randomUUID().toString();
		log.info("get Guid: {} {}", result);
		return result;
	}

	@GetMapping("/info")
	public Info getInfo() {
		Info result = infoPersistance.getInfo();
		log.info("Created info object: {}", result);
		return result;
	}

	@PostMapping("/info")
	public Info postInfo(@RequestBody Info info) {
		infoPersistance.setInfo(info);
		Info result = infoPersistance.getInfo();
		log.info("Created info object: {}", result);
		return result;
	}
	
	@PostMapping("/firs-topic")
	public void postInfo(@RequestBody String message) {
		kafkaProducer.send(message);
	}
	
}
