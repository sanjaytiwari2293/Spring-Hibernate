package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;
import com.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

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
			
			//create course
			Course course = new Course("Mortal Kombat X - MasterClass");
			
			System.out.println("\nSaving the course! "+course);
			session.save(course);
			
			//create students
			Student student1 = new Student("John", "Doe", "jd@uncc.edu");
			Student student2 = new Student("Mary", "Doe", "md@uncc.edu");
			
			//add students to the course
			course.addStudent(student1);
			course.addStudent(student2);
			
			//save the students
			System.out.println("\nSaving the students!");
			session.save(student1);
			session.save(student2);
			
			System.out.println("saved the students!");
			
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
