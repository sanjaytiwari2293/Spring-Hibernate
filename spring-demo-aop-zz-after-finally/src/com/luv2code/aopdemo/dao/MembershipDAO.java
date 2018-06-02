package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public void addMember() {
		
		System.out.println(getClass()+": In the MembershipDAO class");
		
	}
	
	public boolean doMembershipWork() {
		
		System.out.println(getClass() + 
				": doMembershipWork > ");
		return true;
		
	}

}
