package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;
	
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
