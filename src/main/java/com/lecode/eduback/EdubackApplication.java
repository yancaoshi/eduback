package com.lecode.eduback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lecode.eduback.mapper")
public class EdubackApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdubackApplication.class, args);
	}

}
