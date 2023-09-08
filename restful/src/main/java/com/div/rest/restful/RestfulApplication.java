package com.div.rest.restful;

import com.div.rest.restful.custombean.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestfulApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RestfulApplication.class, args);
	}

	@Autowired
	@Qualifier("coder")
	Manager manager;


	@Override
	public void run(String... args) throws Exception {
//		logger.info(business1.calculateSomething());
//		logger.info(business2.calculateSomething());
		System.out.println("\n\n\nHo rha h"+manager.getResponsibility());

	}

}
