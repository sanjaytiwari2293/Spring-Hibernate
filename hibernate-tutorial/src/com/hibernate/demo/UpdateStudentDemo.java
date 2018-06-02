package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

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
			
			int studentId = 1;
			System.out.println("\nGetting student with id: "+studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Updating Student... "+myStudent);
			
			myStudent.setFirstName("Scooby");
			//commit transaction
			session.getTransaction().commit();
			
			
			//new code
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Updating emails of all students.");
			session.createQuery("update Student s set s.email='foo@uncc.edu'")
				   .executeUpdate();
			
			
			//commit
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}
		
		
	}

}
