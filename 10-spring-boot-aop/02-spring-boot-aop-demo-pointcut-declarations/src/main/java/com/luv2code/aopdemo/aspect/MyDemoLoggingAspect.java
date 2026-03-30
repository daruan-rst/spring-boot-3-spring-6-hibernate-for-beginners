package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvide(JoinPoint theJoinPoint){

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @After (finally) on method: " + method);

    }

    @AfterThrowing(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(
            JoinPoint theJoinPoint, Throwable theExc) {

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterThrowing on method: " + method);

        // log the exception
        System.out.println("\n=====>>> The exception is: " + theExc);
    }

    @AfterReturning(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result){

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n======>>> Executing @AfterReturning on method: " +  method);

        // print out the results of the method call
        System.out.println("\n======>>> Result is: " +  result);
        
        convertAccountNamesToUpperCase(result);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        result.forEach( r -> r.setName(r.getName().toUpperCase()));
    }

    @Before("com.luv2code.aopdemo.aspect.LuvAOPExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccount(JoinPoint theJoinPoint){

        System.out.println("\n=====>>> Executing @Before advice on method: ");

        // display the method signature
        MethodSignature theMethodSignature = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method signature: " + theMethodSignature);

        // display the method arguments

        // get args
        Object[] args = theJoinPoint.getArgs();


        // loop thry args
        for (Object arg : args){
            System.out.println(arg);

            if (arg instanceof Account){

                // downcast and print Account specific stuff
                Account account = (Account) arg;
                System.out.println("Account name: " + account.getName());
                System.out.println("Account level: " + account.getLevel());
            }
        }


    }

}
