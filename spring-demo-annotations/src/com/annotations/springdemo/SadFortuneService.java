package com.annotations.springdemo;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		
		return "Today is a sad day because it is legs day!";
	}

}
