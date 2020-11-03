package com.ktnet.recruit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;

@SpringBootApplication(exclude = {MultipartAutoConfiguration.class})
public class RecruitApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecruitApplication.class, args);
	}

}
