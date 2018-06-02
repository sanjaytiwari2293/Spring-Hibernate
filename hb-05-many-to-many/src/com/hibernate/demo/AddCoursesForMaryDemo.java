package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;
import com.hibernate.demo.entity.Student;

public class AddCoursesForMaryDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .addAnnotatedClass(Course.class)
								 .addAnnotatedClass(Review.class)
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			
			//start the transaction
			session.beginTransaction();
			
			//get student named mary
			int id = 2;
			Student student = session.get(Student.class, id);
			System.out.println("Got Student: "+student);
			System.out.println("Previous Courses: "+student.getCourses());
			
			//create more courses
			Course course1 = new Course("Java Course-Beginner to Advance");
			Course course2 = new Course("MySql Tutorial for Beginners");
			
			//add student mary to the courses
			course1.addStudent(student);
			course2.addStudent(student);
			
			//save the courses
			System.out.println("saving the courses");
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
