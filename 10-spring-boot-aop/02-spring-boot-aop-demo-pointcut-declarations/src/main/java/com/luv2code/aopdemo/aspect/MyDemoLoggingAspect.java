package com.luv2code.aopdemo.aspect;

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


    }

}
