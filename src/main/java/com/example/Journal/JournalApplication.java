package com.example.Journal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JournalApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext a = SpringApplication.run(JournalApplication.class, args);
		// ConfigurableEnvironment environment = a.getEnvironment();
		// // System.out.println();
		// // System.out.println(environment.getActiveProfiles()[0]);
	}

}
