package com.div.S3File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class S3FileApplication {

	public static void main(String[] args) throws InterruptedException, IOException {
		SpringApplication.run(S3FileApplication.class, args);
		AmazonS3Util util = new AmazonS3Util();
//		util.deletePrefixObject("bucket-name", "Criteria");
		util.putObject();
	}

}
