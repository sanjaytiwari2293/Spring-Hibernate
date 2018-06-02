package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {
	
	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean
		AccountDAO accountDAO =  context.getBean("accountDAO", AccountDAO.class);
		
		//get membershipDAO bean
		MembershipDAO membershipDAO = 
				context.getBean("membershipDAO", MembershipDAO.class);
		
		//call the method
		Account account = new Account();
		account.setLevel("Top");
		account.setName("Checking");
		
		accountDAO.addAccount(account, true);
		accountDAO.doWork();
		
		//call membershipDAO method
		membershipDAO.addMember();
		membershipDAO.doMembershipWork();
		
		
		//call getter/setter on account dao
		accountDAO.setName("xyz");
		accountDAO.setServiceCode("abc");
		
		String name = accountDAO.getName();
		String code = accountDAO.getServiceCode();
		
		
		//close the context
		context.close();
	}

}
