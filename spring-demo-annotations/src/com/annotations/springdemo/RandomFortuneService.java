package com.annotations.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	//create an array of strings
	private String[] array = 
		{"Random 1", "Random 2", "Random 3", "Random 4"};
	
	//create random number generator
	private Random random = new Random();
	
	
	@Override
	public String getFortune() {
		// pick random string
		int index = random.nextInt(array.length);
		return array[index];
	}

}
