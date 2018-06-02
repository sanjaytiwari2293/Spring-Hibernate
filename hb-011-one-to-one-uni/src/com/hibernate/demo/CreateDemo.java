package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .buildSessionFactory();
		
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			Instructor instructor = 
					new Instructor("Sannew", "Test", "stest@gmail.com");
			
			InstructorDetail instructorDetail = 
					new InstructorDetail("http://youtube.com/stestnew", "Gamingtest!");
			
			instructorDetail.setInstructor(instructor);
			
			
			//start the transaction
			session.beginTransaction();
			
			
			session.save(instructorDetail);
			
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}
		
		
	}

}
