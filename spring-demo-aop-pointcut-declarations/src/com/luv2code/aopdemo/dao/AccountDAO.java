package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account account, boolean b) {
		
		System.out.println(getClass() + 
				": Adding an Account > "+account);
		
	}
	
	public boolean doWork() {
		
		System.out.println(getClass() + 
				": doWork > ");
		return true;
		
	}
	
	
	
}
