package com.OpenClassProject.safetyNetAlert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication(scanBasePackages = {"services", "com.OpenClassProject.safetyNetAlert.repository", "com.OpenClassProject.safetyNetAlert"})
public class SafetyNetAlertApplication {

	public static void main(String[] args) {
		SpringApplication.run(SafetyNetAlertApplication.class, args);	
		}
	
}