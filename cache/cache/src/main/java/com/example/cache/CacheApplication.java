package com.example.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.util.LinkedHashMap;

@SpringBootApplication
@EnableCaching
public class CacheApplication {

	@Autowired
	private static Controller controller;
	public static void main(String[] args) {
//		LinkedHashMap

//		controller.runner();
		SpringApplication.run(CacheApplication.class, args);
		controller.service.getAddress(new Customer("U-block"));
//		controller.service.setAddress(new Customer("T-block"));
//		controller.service.setAddress(new Customer("S-block"));
//
//		controller.service.updateAddress(new Customer("S-block"));
//
//
//		controller.service.getAddress(new Customer("U-block"));
//		controller.service.update(new Customer("U-block"));
	}

}
