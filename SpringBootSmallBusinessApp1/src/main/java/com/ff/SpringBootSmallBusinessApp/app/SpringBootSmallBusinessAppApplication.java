package com.ff.SpringBootSmallBusinessApp.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ff.SpringBootSmallBusinessApp.app.model.Emi;

@SpringBootApplication
public class SpringBootSmallBusinessAppApplication {

	public static void main(String[] args) {
		
		System.out.println("All Details Web Service");
		SpringApplication.run(SpringBootSmallBusinessAppApplication.class, args);
		
	}

}
