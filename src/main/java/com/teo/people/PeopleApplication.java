package com.teo.people;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PeopleApplication {

	private static final Logger log = LoggerFactory.getLogger(PeopleApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PeopleApplication.class, args);
	}

}
