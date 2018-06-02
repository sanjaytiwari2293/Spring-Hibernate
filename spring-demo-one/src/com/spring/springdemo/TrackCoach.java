package com.spring.springdemo;

public class TrackCoach implements Coach {
	
	private FortuneService fs;
	
	public TrackCoach(FortuneService theFs) {
		fs = theFs;
	}

	@Override
	public String getDailyWorkout() {
		
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFotune() {
		
		return "Just Do It: "+fs.getFortune();
	}
	
	//add an init method
	public void doMyStartupStuff() {
		System.out.println("Inside init method!");
	}
	
	//add a destroy method
	public void doMyCleanupStuff() {
		System.out.println("Inside destroy method!");
	}

}
