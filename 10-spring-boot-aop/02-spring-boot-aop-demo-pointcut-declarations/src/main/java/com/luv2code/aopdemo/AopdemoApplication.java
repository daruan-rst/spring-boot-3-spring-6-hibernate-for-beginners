package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDao,
											   MembershipDAO theMembershipDao) {

		return runner -> {

//			demoTheBeforeAdvice(theAccountDao, theMembershipDao);
			demoTheAfterAdvice(theAccountDao);
		};
	}

	private void demoTheAfterAdvice(AccountDAO theAccountDao) {

		// call method to find the accounts

		List<Account> theAccounts = theAccountDao.findAccounts();

		System.out.println("\n\nMain Program: demoTheAfterReturningAdvice");
		System.out.println("-----");

		System.out.println(theAccounts);

		System.out.println("\n");
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDao, MembershipDAO theMembershipDao) {

		Account myAccount = new Account();
		myAccount.setName("Madhu");
		myAccount.setLevel("Platinum");
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
