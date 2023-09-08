package com.spring.basics.springsteps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@SpringBootApplication
public class SpringStepsApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext =
				SpringApplication.run(SpringStepsApplication.class, args);

		BinarySearchImpl binarySearchImpl1 = applicationContext.getBean(BinarySearchImpl.class);
		BinarySearchImpl binarySearchImpl2 = applicationContext.getBean(BinarySearchImpl.class);
//		BinarySearchImpl binarySearchImpl = new BinarySearchImpl(new QuickSortAlgo());
		System.out.println(binarySearchImpl1);
		System.out.println(binarySearchImpl2);
		int res = binarySearchImpl1.binarySearch(new int[]{3,4,5},1);
		System.out.println(res);





	}
}
