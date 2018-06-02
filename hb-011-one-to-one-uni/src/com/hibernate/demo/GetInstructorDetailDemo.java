package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Student;

public class GetInstructorDetailDemo {

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
			
			//start the transaction
			session.beginTransaction();
			
			
			//get instructor object
			int id =39797;
			Instructor instructor = session.get(Instructor.class, id);
			
			//print instructor and its corresponding detail object
			System.out.println("instructor: "+instructor);
			System.out.println("detail: "+instructor.getInstructorDetail());
			
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
			session.close();
			
			factory.close();
		}
		
		
	}

}
