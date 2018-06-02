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
	
	//create pointcut for getter and setter method
	@Pointcut("execution(public * com.luv2code.aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	@Pointcut("execution(public * com.luv2code.aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	//create pointcut: include package & exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
	
	
	//@Before advice for logging
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n>>> "
				+ "Executing @Before advice on * com.luv2code.aopdemo.dao.*.*(..)");
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("\n>>> Performing API Analytics");
	}
	
}
