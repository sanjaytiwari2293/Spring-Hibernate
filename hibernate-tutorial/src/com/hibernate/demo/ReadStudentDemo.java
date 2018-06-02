package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//use the session object to save Java object
			
			//create a new student object
			System.out.println("creating a new student object");
			Student student = new Student("Panda1", "Tiwari", "pt@gmail.com");
			
			//start the transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("student > "+student);
			session.save(student);
			
			//
			System.out.println("Saved student. Generated id before commit: "+student.getId());
			
			//commit transaction
			session.getTransaction().commit();
			
			//Now retrieve the student
			//getting the student's ID - primary key
			
			System.out.println("Saved student. Generated id after commit: "+student.getId());
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Getting student with id: "+student.getId());
			Student myStudent = session.get(Student.class, student.getId());
			System.out.println("Retrieved student: "+myStudent);
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}
		
		
	}

}
