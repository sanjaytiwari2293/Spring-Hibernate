package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Student;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .addAnnotatedClass(Course.class)
								 .buildSessionFactory();
		
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//create the objects
			Instructor instructor = 
					new Instructor("Tony", "Stark", "TS@gmail.edu");
			
			InstructorDetail instructorDetail = 
					new InstructorDetail("http://youtube.com/Tony",
							"Mechanic!!!");
			
			//associate the objects
			instructor.setInstructorDetail(instructorDetail);
			
			
			//start the transaction
			session.beginTransaction();
			
			//save the instructor
			session.save(instructor);
			
			System.out.println("Saving instructor: "+instructor);
			
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally {
			
			session.close();
			
			factory.close();
		}
		
		
	}

}
