package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start the transaction
			session.beginTransaction();
			
			//query students
			List<Student> list  = session.createQuery("from Student s where s.email LIKE '%luv2code.com'").getResultList();
			
			//display the students
			System.out.println("\n\nquery students: email LIKE '%luv2code.com'");
			displayStudents(list);
			
			//query students: lastname='Tiwari' OR firstName = 'Jane2'
			list = session
					.createQuery("from Student s where s.lastName='Tiwari' "
							+ "OR s.firstName='Jane2'").getResultList();
			System.out.println("\n\nquery students: lastName='Tiwari' OR firstName = 'Jane2'");
			displayStudents(list);
			
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}
		
		
	}

	private static void displayStudents(List<Student> list) {
		for(Student s : list) {
			System.out.println(s);
		}
	}

}
