package com.sampleproject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleProjectApplication {

	public static void main(String[] args) {

		SpringApplication.run(SampleProjectApplication.class, args);
		Logger logger = LogManager.getLogger();

		logger.trace("TRACE");
		logger.debug("DEBUG");
		logger.info("INFO");
	}

}
