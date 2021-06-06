package com.bharat.it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
/**
 * 
 * @author bharat.patel
 *
 */
@SpringBootApplication
@EnableCaching
public class SpringBootH2DbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootH2DbApplication.class, args);
	}

}
