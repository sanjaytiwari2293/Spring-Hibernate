package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

	@Pointcut("execution(public * com.luv2code.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	//create pointcut for getter and setter method
	@Pointcut("execution(public * com.luv2code.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	@Pointcut("execution(public * com.luv2code.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	//create pointcut: include package & exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}
	
}
