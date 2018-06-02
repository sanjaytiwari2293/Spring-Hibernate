package com.annotations.springdemo;

public class BodyBuildingCoach implements Coach {

	private FortuneService fs;
	
	public BodyBuildingCoach(FortuneService service) {
		fs = service;
	}
	
	@Override
	public String getDailyWorkout() {
		
		return "Do 100 pullups and 100 squats!";
	}

	@Override
	public String getDailyFortune() {
		
		return fs.getFortune();
	}

}
