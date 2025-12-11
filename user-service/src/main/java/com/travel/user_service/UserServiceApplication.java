package com.travel.user_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.travel.user_service.service.UserService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
	@Autowired
	private UserService userService;

	@PostConstruct
	public void init() {
		userService.createSampleUsers();
	}

}

// @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class});
