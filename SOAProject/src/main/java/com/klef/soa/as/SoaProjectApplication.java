package com.klef.soa.as;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoaProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoaProjectApplication.class, args);
		System.out.println("Project is running");
	}

}
