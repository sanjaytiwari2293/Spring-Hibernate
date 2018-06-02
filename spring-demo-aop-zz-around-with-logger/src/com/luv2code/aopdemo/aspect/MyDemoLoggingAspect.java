package com.luv2code.aopdemo.aspect;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	private Logger logger = Logger.getLogger(MyDemoLoggingAspect.class.getName());
	
	//adding around advice
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(
			ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		logger.info("1. Inside @Around");
		
		String method = proceedingJoinPoint.getSignature().toShortString();
		logger.info("\n>> Executing @Around advice on method: "+method);
		
		long begin = System.currentTimeMillis();
		
		Object object = proceedingJoinPoint.proceed();
		
		logger.info("Object got: "+object.toString());
		
		long end = System.currentTimeMillis();
		
		long diff = end - begin;
		
		logger.info("\nDuration: "+ diff / 1000.0 +" seconds");
		
		return object;
	}
	

	//adding after advice (will run for success or failure (like finally))
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint joinPoint) {
		
		String method = joinPoint.getSignature().toShortString();
		
		logger.info("\nIn afterFinallyFindAccountAdvice method @After");
		logger.info("\n>> Executing @After (finally) advice on method: "+ method);
		
	}
	
	
	//after throwing aspect
	@AfterThrowing(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccountAdvice(
							JoinPoint joinPoint, Throwable theExc) {
		
		String method = joinPoint.getSignature().toShortString();
		
		logger.info("\nIn afterThrowingFindAccountAdvice method @AfterThrowing");
		logger.info("\nmethod: "+method);
		logger.info("\n>> The exception is: "+theExc);
		
		
	}
	
	
	
	
	//add after returning advice
	@AfterReturning(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountAdvice(
							JoinPoint joinPoint, List<Account> result) {
		
		String method = joinPoint.getSignature().toShortString();
		logger.info("\n>> Executing @AfterReturning on method: "+method);
		
		logger.info("\n>> result is: "+result);
		
		if(!result.isEmpty()) {
			logger.info("modifying the list...");
			
			for (int i = 0; i < result.size(); i++) {
				
				Account newAccount = result.get(i);
				newAccount.setName(newAccount.getName().toUpperCase());
				
			}
			
			logger.info("Done Modifiying!");
			
			logger.info("modified result > "+result);
			
		}
		
	}
	
	
	//@Before advice for logging
	@Before("com.luv2code.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		logger.info("\n>>> Executing @Before advice on method");
		
		MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
		
		logger.info("Method Signature: "+methodSignature);
		
		Object[] args = joinPoint.getArgs();
		
		for (Object tempArg : args) {
			logger.info(tempArg.toString());
			
			if(tempArg instanceof Account) {
				
				Account theAccount = (Account) tempArg;
				logger.info("Account:");
				logger.info("Name > "+theAccount.getName());
				logger.info("Level > "+theAccount.getLevel());
				
			}
			
		}
	}
}
