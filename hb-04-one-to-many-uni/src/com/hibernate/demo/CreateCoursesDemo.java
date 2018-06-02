package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Student;

public class CreateCoursesDemo {

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
			
			
			//start the transaction
			session.beginTransaction();
			
			//get the instructor
			int id = 1;
			Instructor instructor = session.get(Instructor.class, id);
			
			//create course
			Course course1 = new Course("Learn Water Rafting!");
			Course course2 = new Course("Learn Swimming Masterclass!");
			
			//System.out.println("Saving instructor: "+instructor);
			
			//add courses to instructor
			instructor.add(course1);
			instructor.add(course2);
			
			//save to DB
			session.save(course1);
			session.save(course2);
			
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
