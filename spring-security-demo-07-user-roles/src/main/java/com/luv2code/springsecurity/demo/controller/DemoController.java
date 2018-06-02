package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	
	@GetMapping("/")
	public String showHome() {
		System.out.println("test!");
		return "home"; //home.jsp
	}
	
	//add mapping for /leaders
	@GetMapping("/leaders")
	public String showLeaders() {
		
		return "leaders";
		
	}
	
	//add mapping for /systems
		@GetMapping("/systems")
		public String showSystems() {
			
			return "systems";
			
		}
}
