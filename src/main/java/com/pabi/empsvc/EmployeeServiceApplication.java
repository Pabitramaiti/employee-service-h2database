package com.pabi.empsvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeServiceApplication {

	public static void main(String[] args) throws Exception {
		System.out.println("Employee-Service:::: Inside main method....");

		SpringApplication.run(EmployeeServiceApplication.class, args);
		System.out.println("Application is started....");
		/*
		 * Map<String, String> envs= System.getenv(); if(envs!=null) { for(String key:
		 * envs.keySet()) { System.out.println("Key: " + key + " Value: " +
		 * System.getenv(key)); } }
		 */
	}

}