package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

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
