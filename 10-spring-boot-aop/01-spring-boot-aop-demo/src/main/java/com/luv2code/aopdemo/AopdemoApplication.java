package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccouintDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccouintDAO theAccountDao) {

		return runner -> {

			demoTheBeforeAdvice(theAccountDao);
		};
	}

	private void demoTheBeforeAdvice(AccouintDAO theAccountDao) {

		// call the business method
		theAccountDao.addAccount();

		System.out.println("\n Let's call it again \n");

		theAccountDao.addAccount();
	}


}
