package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;
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
											   MembershipDAO theMembershipDao,
											   TrafficFortuneService theTrafficFortuneService) {

		return runner -> {

//			demoTheBeforeAdvice(theAccountDao, theMembershipDao);
//			demoTheAfterReturnAdvice(theAccountDao);
//			demoTheAfterThrowingAdvice(theAccountDao);
//			demotheAfterAdvide(theAccountDao);
//			demoTheAroundAdvice(theTrafficFortuneService);
//			demoTheAroundAdviceHandleException(theTrafficFortuneService);
			demoTheAroundAdviceRethrowException(theTrafficFortuneService);
		};
	}

	private void demoTheAroundAdviceRethrowException(TrafficFortuneService theTrafficFortuneService) {

		System.out.println("\nMain Program: demoTheAroundAdviceRethrowException");

		System.out.println("Calling getFortune()");

		boolean tripWire = true;
		String data = theTrafficFortuneService.getFortune(tripWire);

		System.out.println("\nMy fortune is: " + data);

		System.out.println("Finished");

	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService theTrafficFortuneService) {

		System.out.println("\nMain Program: demoTheAroundAdviceHandleException");

		System.out.println("Calling getFortune()");

		boolean tripWire = true;
		String data = theTrafficFortuneService.getFortune(tripWire);

		System.out.println("\nMy fortune is: " + data);

		System.out.println("Finished");

	}

	private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {

		System.out.println("\nMain Program: demoTheAroundAdvice");

		System.out.println("Calling getFortune()");

		String data = theTrafficFortuneService.getFortune();

		System.out.println("\nMy fortune is: " + data);

		System.out.println("Finished");
	}

	private void demotheAfterAdvide(AccountDAO theAccountDao) {

		// call method to find the accounts

		List<Account> theAccounts = null;

		try {
			boolean tripWire = false;

			theAccounts = theAccountDao.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("\n\nMain Program: caught Exception: " + e);
		}

		System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
		System.out.println("-----");

		System.out.println(theAccounts);

		System.out.println("\n");
	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDao) {


		// call method to find the accounts

		List<Account> theAccounts = null;

		try {
			boolean tripWire = true;

			theAccounts = theAccountDao.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("\n\nMain Program: caught Exception: " + e);
		}

		System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
		System.out.println("-----");

		System.out.println(theAccounts);

		System.out.println("\n");
	}

	private void demoTheAfterReturnAdvice(AccountDAO theAccountDao) {

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
