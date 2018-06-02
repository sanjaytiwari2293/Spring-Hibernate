package com.annotations.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		//get the bean from spring container
		SwimCoach coach = context.getBean("swimCoach", SwimCoach.class);
		
		//call a method on the bean
		System.out.println(coach.getDailyWorkout());
		
		//call get daily fortune method
		System.out.println(coach.getDailyFortune());
		
		//call new methods
		System.out.println("email: "+coach.getEmail());
		System.out.println("team: "+coach.getTeam());
		
		//close the context
		context.close();
	}

}
