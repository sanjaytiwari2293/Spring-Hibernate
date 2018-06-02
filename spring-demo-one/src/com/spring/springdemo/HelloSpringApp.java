package com.spring.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
		//load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve bean from spring container
		Coach coach = context.getBean("myCoach", Coach.class);
		
		//call method on the bean
		System.out.println(coach.getDailyWorkout());
		
		//call fortune service method
		System.out.println(coach.getDailyFotune());
		
		//close the context
		context.close();

	}

}
