package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	Logger logger = Logger.getLogger(getClass().getName());

	
	//Pointcut declarations for Controller
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}

	//Pointcut declarations for Service
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() {}

	//Pointcut declarations for DAO
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}


	//add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		
		//joinPoint gives us metadata
		String method = joinPoint.getSignature().toShortString();
		logger.info("====>> in @Before: calling Method: "+ method);
		
		
		//get and display method args
		Object[] args = joinPoint.getArgs();
		
		for(Object object: args) {
			logger.info("args: "+object);
		}
		
	}
	
	//add @AfterReturning advice
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="result"
			)
	public void afterReturning(JoinPoint joinPoint, Object result) {
		
		String method = joinPoint.getSignature().toShortString();
		logger.info("====>> in @AfterReturning: from Method: "+method);
		
		logger.info("====>> result: "+result);
		
	}
	
}
