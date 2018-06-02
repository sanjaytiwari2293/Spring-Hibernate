package com.spring.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	//need a controller method to show the initial html form
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	//need a controller method to process the html form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	//adding new controller method
	//add data to the model
	@RequestMapping("/processFormV2")
	public String letsShoutDudue(HttpServletRequest request, Model model) {
		
		//getting the request parameter from the HTML form
		String name = request.getParameter("studentName");
		
		// to upperCase
		name = name.toUpperCase();
		
		//creating message
		String msg = "Yo! "+ name;
		
		//adding attribute to the model
		model.addAttribute("message", msg);
		
		return "helloworld";
	}
	
	@RequestMapping("/processFormV3")
	public String processFormV3(
			@RequestParam("studentName") String name, Model model) {
		
		// to upperCase
		name = name.toUpperCase();
		
		//creating message
		String msg = "Version 3 demo! "+ name;
		
		//adding attribute to the model
		model.addAttribute("message", msg);
		
		return "helloworld";
	}

}
