package com.facenet.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.facenet.tutorial.security.ApplicationUserRole.ADMIN;

@SpringBootApplication
public class SpringbootSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSecurityApplication.class, args);
		System.out.println(ADMIN.name());
		System.out.println("--------");
		System.out.println(ADMIN.getPermissions());
	}

}
