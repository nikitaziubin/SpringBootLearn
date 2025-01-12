package com.learn.springboot.web_api_lesson;

import java.util.Date;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class Info {
	private Date date;
	private String guid;
	private Integer id;
	
	
}
