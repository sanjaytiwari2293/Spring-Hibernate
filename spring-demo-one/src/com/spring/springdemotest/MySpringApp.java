package com.spring.springdemotest;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MySpringApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach coach = context.getBean("dietCoach", Coach.class);
		
		System.out.println(coach.getDietChart()+", "+coach.getClass());
		
		context.close();

	}

}
