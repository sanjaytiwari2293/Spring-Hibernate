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
		
		//call membershipDAO method
		membershipDAO.addMember();
		
		//call method
		accountDAO.doWork();
		
		//call method
		membershipDAO.doMembershipWork();
		
		
		//close the context
		context.close();
	}

}
