package com.spring.mvc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Value("#{countryOptions}")
	private Map<String, String> countryOptions;

	@RequestMapping("/showForm")
	public String showForm(Model model) {
		
		//create a new student object and add it as model attribute
		model.addAttribute("student", new Student());
		
		model.addAttribute("theCountryOptions", countryOptions);
		
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student student) {
		
		//log the student
		System.out.println("First name: "+ student.getFirstName());
		System.out.println("Last name: "+ student.getLastName());
		System.out.println("Country: "+ student.getCountry());
		
		return "student-confirmation";
	}
	
}
