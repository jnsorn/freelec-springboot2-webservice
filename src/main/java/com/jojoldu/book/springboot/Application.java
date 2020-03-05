package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		/* NOTE : 아래 코드로 인해 내장 WAS가 실행됨*/
		SpringApplication.run(Application.class, args);
	}
}