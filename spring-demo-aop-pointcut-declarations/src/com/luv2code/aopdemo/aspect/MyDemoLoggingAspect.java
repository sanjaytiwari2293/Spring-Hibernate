package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	@Pointcut("execution(public * com.luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	//@Before advice for logging
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n>>> "
				+ "Executing @Before advice on * com.luv2code.aopdemo.dao.*.*(..)");
	}
	
	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		System.out.println("\n>>> Performing API Analytics");
	}
	
}
