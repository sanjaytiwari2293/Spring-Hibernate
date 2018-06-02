package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;
	
	
	public List<Account> findAccounts(boolean tripWire)	{
		
		//simulate exception
		if(tripWire) {
			throw new RuntimeException("Exception from AccountDAO!");
		}
		
		List<Account> accountsList  = new ArrayList<>();
		
		//create account
		Account account1 = new Account("Sanjay", "level1");
		Account account2 = new Account("Chad", "level2");
		Account account3 = new Account("Mohan", "level3");
		
		//add accounts to list
		accountsList.add(account1);
		accountsList.add(account2);
		accountsList.add(account3);
		
		return accountsList;
		
	}
	
	public void addAccount(Account account, boolean b) {
		
		System.out.println(getClass() + 
				": Adding an Account > "+account);
		
	}
	
	public boolean doWork() {
		
		System.out.println(getClass() + 
				": doWork > ");
		return true;
		
	}

	public String getName() {
		System.out.println("in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println("in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println("in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println("in setServiceCode()");
		this.serviceCode = serviceCode;
	}

	@Override
	public String toString() {
		return "AccountDAO [name=" + name + ", serviceCode=" + serviceCode + "]";
	}
	
	
	
	
}
