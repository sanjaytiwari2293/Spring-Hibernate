package com.annotations.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		
		//load spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve bean from spring container
		Coach coach = context.getBean("tennisCoach", Coach.class);

		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		//print results
		boolean result = (coach == alphaCoach);
		
		System.out.println("Pointing to same object? -> "+result);
		
		System.out.println("coach "+coach);
		
		System.out.println("alphaCoach "+alphaCoach);
		
		//close the context
		context.close();
		
	}

}
