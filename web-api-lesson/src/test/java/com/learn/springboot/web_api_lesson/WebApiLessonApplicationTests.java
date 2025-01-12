package com.learn.springboot.web_api_lesson;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import jakarta.annotation.Resource;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class WebApiLessonApplicationTests {
	
	@Resource
	TestRestTemplate testRestTemplate;  
	
	@Test
	void received_date_get_restserveice() {
		Date date = testRestTemplate.getForObject("/date", Date.class);
		assertNotNull(date);
	}
	
	@Test
	void received_date_multiple_get_restserveice() {
		for (int i = 0; i < 150; i++) {
			Date date = testRestTemplate.getForObject("/date", Date.class);
			assertNotNull(date);
		}
	}
	
	@Test
	void received_guid() {
		String guid = testRestTemplate.getForObject("/guid", String.class);
		assertFalse(guid.contains("error"));
		assertNotNull(guid);
		assertEquals(5, guid.split("-").length);
		assertEquals(9, (guid + guid).split("-").length);
		UUID.fromString(guid);
	}
	
	@Test
	void received_info() {
		Info info = testRestTemplate.getForObject("/info", Info.class);
		assertNotNull(info.getDate());
		assertNotNull(info.getGuid());
		assertNotNull(info.getId());
	}
	@Test
	void send_info() {
		Info info = Info.builder()
						   .date(new Date())
						   .guid(UUID.randomUUID().toString())
						   .id(1)
						   .build(); 	
		assertEquals(info, testRestTemplate.postForObject("/info", info, Info.class));
		assertEquals(info, testRestTemplate.getForObject("/info", Info.class), "Received Info does not match.");
		
		
		
		
	}
}
