package com.example.restapi01_240304;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.SQLOutput;
import java.util.Arrays;

// @Controller - 주소 html
// @Service - 서비스
// @Repository - DB관리
// @GetMapping - 주소줄
// @ResponseBody - 문자열
// @RestController - string 문자열, @ResponceBody가 팔요없음

@SpringBootApplication
public class Restapi01240304Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Restapi01240304Application.class, args);

		// controller, service, repository, ato, entiry
		Arrays.stream(context.getBeanDefinitionNames())
				.filter(s -> s.contains("main")) // "main" 이 포함된것만 출력하는 필터
				.forEach(System.out::println);
	}

}
