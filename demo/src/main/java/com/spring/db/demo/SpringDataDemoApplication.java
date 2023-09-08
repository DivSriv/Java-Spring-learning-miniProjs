package com.spring.db.demo;

import com.spring.db.demo.entity.Person;
import com.spring.db.demo.jpa.PersonJpaRepo;
import com.spring.db.demo.springdata.PersonSpringDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;


@SpringBootApplication
public class SpringDataDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PersonSpringDataRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(SpringDataDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("User id 10001 -> {} ", repository.findById(10001));
		logger.info("Inserting User id 10004 -> {} ", repository.save(new Person( "Tara", "Munich", new Date())));
		logger.info("Updating User id 10003 -> {} ", repository.save(new Person(10003, "Pieter", "Munich", new Date())));
		repository.deleteById(10002);
		logger.info("All Users {} - ", repository.findAll());
//		logger.info("Deleting User id 10002 and no. of rows deleted -> {} ", dao.deleteById(10002));
	}
}
