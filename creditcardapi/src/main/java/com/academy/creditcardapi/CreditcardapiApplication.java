package com.academy.creditcardapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(CreditcardapiApplicationConfig.class)
public class CreditcardapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditcardapiApplication.class, args);
	}

}
