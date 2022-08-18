package com.thegraid.gamma;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GammaDsApplication {
	private static final Logger log = LoggerFactory.getLogger(GammaDsApplication.class);

	public static void main(String[] args) {
		log.info("Running Spring Boot:");
		SpringApplication.run(GammaDsApplication.class, args);
	}

}
