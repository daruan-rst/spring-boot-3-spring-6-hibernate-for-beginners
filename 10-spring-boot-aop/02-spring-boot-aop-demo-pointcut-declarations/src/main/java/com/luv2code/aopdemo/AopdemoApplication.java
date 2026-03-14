package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
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
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDao,
											   MembershipDAO theMembershipDao) {

		return runner -> {

			demoTheBeforeAdvice(theAccountDao, theMembershipDao);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDao, MembershipDAO theMembershipDao) {

		Account myAccount = new Account();
		// call the business method
		theAccountDao.addAccount(myAccount, true);

		theAccountDao.doWork();

		// call the accountdao getter/setter methods
		theAccountDao.setName("foobar");
		theAccountDao.setServiceCode("silver");

		String name = theAccountDao.getName();
		String code = theAccountDao.getServiceCode();


		// call the membership business method
		theMembershipDao.addMember();

		theMembershipDao.goToSleep();


	}


}
