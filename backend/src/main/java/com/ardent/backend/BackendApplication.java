package com.ardent.backend;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class BackendApplication {

	@Value("${spring.data.mongodb.database}")
	private String dbName;

	@PostConstruct
	public void logDb() {
		log.info("MongoDB database in use: {}", dbName);
	}
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}
