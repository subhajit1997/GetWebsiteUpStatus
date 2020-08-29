package com.allsafe.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RealTimeWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealTimeWebAppApplication.class, args);
	}

}
