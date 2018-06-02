package com.spring.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {

		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		Coach coach = context.getBean("myCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		boolean result = (coach == alphaCoach);
		
		System.out.println("Pointing to the same object: "+result);
		
		System.out.println("memory location of coach: "+ coach);
		
		System.out.println("memory location of AlphaCoach: "+ alphaCoach);
		
		context.close();


	}

}
