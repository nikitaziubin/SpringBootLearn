package com.learn.springboot.web_api_lesson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
//@EnableAsync
public class WebApiLessonApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApiLessonApplication.class, args);
	}

}
