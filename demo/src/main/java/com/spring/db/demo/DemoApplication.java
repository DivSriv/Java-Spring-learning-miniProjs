package com.spring.db.demo;

import com.spring.db.demo.entity.Person;
import com.spring.db.demo.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;


//@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PersonJdbcDao dao;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All Users {} - ", dao.findAll());
		logger.info("User id 10001 -> {} ", dao.findById(10001));
		logger.info("Deleting User id 10002 and no. of rows deleted -> {} ", dao.deleteById(10002));
		logger.info("Inserting User id 10004 -> {} ", dao.insert(new Person(10004, "Tara", "Munich", new Date())));
		logger.info("Inserting User id 10003 -> {} ", dao.update(new Person(10003, "Pieter", "Munich", new Date())));
	}
}
