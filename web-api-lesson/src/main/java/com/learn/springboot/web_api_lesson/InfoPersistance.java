package com.learn.springboot.web_api_lesson;

import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@Component
public class InfoPersistance {
	private Info info = Info.builder()
			.guid(UUID.randomUUID().toString())
			.date(new Date())
			.id(1)
			.build();	
}
