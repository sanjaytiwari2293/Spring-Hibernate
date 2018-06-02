package com.annotations.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PA7DemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(PA7ConfigFile.class);
		
		Coach coach = context.getBean("bodyBuildingCoach", Coach.class);
		
		System.out.println(coach.getDailyWorkout());
		
		System.out.println(coach.getDailyFortune());

		context.close();
	}

}
