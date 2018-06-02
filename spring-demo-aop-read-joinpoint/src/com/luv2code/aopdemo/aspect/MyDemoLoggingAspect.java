package com.luv2code.aopdemo.aspect;

import java.util.Iterator;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	//@Before advice for logging
	@Before("com.luv2code.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println("\n>>> Executing @Before advice on method");
		
		MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
		
		System.out.println("Method Signature: "+methodSignature);
		
		Object[] args = joinPoint.getArgs();
		
		for (Object tempArg : args) {
			System.out.println(tempArg);
			
			if(tempArg instanceof Account) {
				
				Account theAccount = (Account) tempArg;
				System.out.println("Account:");
				System.out.println("Name > "+theAccount.getName());
				System.out.println("Level > "+theAccount.getLevel());
				
			}
			
		}
	}
}
