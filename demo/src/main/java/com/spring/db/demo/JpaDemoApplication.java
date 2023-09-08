package com.spring.db.demo;

import com.spring.db.demo.entity.Person;
import com.spring.db.demo.jdbc.PersonJdbcDao;
import com.spring.db.demo.jpa.PersonJpaRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;


//@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PersonJpaRepo personJpaRepo;
	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("User id 10001 -> {} ", personJpaRepo.findById(10001));
		logger.info("Inserting User id 10004 -> {} ", personJpaRepo.insert(new Person( "Tara", "Munich", new Date())));
		logger.info("Updating User id 10003 -> {} ", personJpaRepo.update(new Person(10003, "Pieter", "Munich", new Date())));
		personJpaRepo.deleteById(10002);
//		logger.info("All Users {} - ", dao.findAll());
//		logger.info("Deleting User id 10002 and no. of rows deleted -> {} ", dao.deleteById(10002));
	}
}
