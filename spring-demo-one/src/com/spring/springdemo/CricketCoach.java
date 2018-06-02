package com.spring.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	
	//add new fields for emailAddress and team
	private String emailAddress;
	private String team;
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("Inside Setter method! : setEmailAddress");
		this.emailAddress = emailAddress;
	}
	
	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("Inside Setter method! : setTeam");
		this.team = team;
	}

	//create a no-arg constructor
	public CricketCoach() {
		System.out.println("Inside CricketCoach Constructor!");
	}
	
	//setter method
	public void setFortuneService(FortuneService fs) {
		System.out.println("Inside Setter method! : setFortuneService");
		fortuneService = fs;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice fast bowling for 15 minutes";
	}

	@Override
	public String getDailyFotune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
