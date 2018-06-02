package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

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
			
			//option 2: Hibernate query with HQL
			
			//get the instructor
			int id = 1;
			
			Query<Instructor> query = 
					session.createQuery("select i from Instructor i "
							+ "JOIN FETCH i.courses "
							+ "where i.id=:theId",Instructor.class);
			
			//set parameter "theId" on query
			query.setParameter("theId", id);
			
			//execute query and get instructor
			Instructor instructor = query.getSingleResult();
			
			System.out.println("<> Instructor: "+instructor);
			
			//commit transaction
			session.getTransaction().commit();
			
			//close the session
			session.close();
			
			
			//get courses again
			System.out.println("<> Courses Again: "+instructor.getCourses());
						
			System.out.println("Done!");
			
		}
		finally {
			
			session.close();
			
			factory.close();
		}
		
		
	}

}
