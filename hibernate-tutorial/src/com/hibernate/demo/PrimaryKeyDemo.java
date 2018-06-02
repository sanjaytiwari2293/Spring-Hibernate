package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		//create session object
		Session session = factory.getCurrentSession();
		
		try {
			
			//create 3 student objects
			System.out.println("Creating student object");
			Student student1 = new Student("TonyH", "Stark", "ts@gmail.com");
			Student student2 = new Student("Jane2", "Doe", "jd@gmail.com");
			Student student3 = new Student("Robert3", "Pattinson", "rp@gmail.com");
			
			//begin transaction
			session.beginTransaction();
			
			//save student object
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			//commit 
			session.getTransaction().commit();
			
			System.out.println("Done!!");
			
		}
		finally {
			
			factory.close();
			
		}
		

	}

}
