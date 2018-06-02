package com.spring.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator 
	implements ConstraintValidator<CourseCode, String>{

	private String[] coursePrefix;
	
	@Override
    public void initialize(CourseCode theCourseCode) {
        coursePrefix = theCourseCode.value();
    }
	
	@Override
	public boolean isValid(String theCode, 
			ConstraintValidatorContext constraintValidatorContext) {
		
		boolean result=false; 
		
		if(theCode!=null) {
			
			for(String temp: coursePrefix) {
				
				result = theCode.startsWith(temp);
				
				if(result) {
					break;
				}
				
			}
			
		}
		else {
			result=true;
		}
		
		return result;
	}

}
