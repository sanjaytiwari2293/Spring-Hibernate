package com.spring.springdemo;

public class BaseballCoach implements Coach {

	//define a private field
	private FortuneService fortuneService;
	
	//define a constructor for dependency injection
	public BaseballCoach(FortuneService theFortuneService){
		fortuneService = theFortuneService;
	}
	
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Spend 30 minutes on batting practice";
		
	}

	@Override
	public String getDailyFotune() {
		
		//use my fortuneService to get a fortune
		
		return fortuneService.getFortune();
	}
	

}
