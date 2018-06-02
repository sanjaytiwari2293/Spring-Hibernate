package com.annotations.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PA7ConfigFile {

	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	@Bean
	public Coach bodyBuildingCoach() {
		return new BodyBuildingCoach(sadFortuneService());
	}
	
}
