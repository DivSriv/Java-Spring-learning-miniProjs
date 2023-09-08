package com.spring.aop.aop;

import com.spring.aop.aop.business.Business1;
import com.spring.aop.aop.business.Business2;
import com.spring.aop.aop.custombean.Manager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Business1 business1;
	@Autowired
	private Business2 business2;

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}

	@Autowired
	@Qualifier("coder")
	Manager manager;

	@Override
	public void run(String... args) throws Exception {
//		logger.info(business1.calculateSomething());
//		logger.info(business2.calculateSomething());
		System.out.println(manager.getResponsibility());


	}
}
