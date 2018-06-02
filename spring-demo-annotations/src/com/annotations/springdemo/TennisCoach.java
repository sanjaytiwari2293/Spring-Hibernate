package com.annotations.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fs;
	
	public TennisCoach() {
		System.out.println(">> inside tc constructor!");
	}
	
	//define init method
	@PostConstruct
	public void doMyStartupStuff(){
		System.out.println("inside startup stuff method");
	}
	
	//define destroy method
	@PreDestroy
	public void doMyCleanupStuff(){
		System.out.println("inside cleanup stuff method");
	}
	
	//setter method
	/*@Autowired
	public void doSomeCrazyStuff(FortuneService service) {
		System.out.println(">> inside doSomeCrazyStuff() method!");
		fs = service;
	}*/
	
	/*
	@Autowired
	public TennisCoach(FortuneService fortuneService) {
		fs = fortuneService;
	}
	*/
	@Override
	public String getDailyWorkout() {
		
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fs.getFortune();
	}

}
