package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Employee;

public class CreateEmployeeDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
							     .configure("hibernate.cfg.xml")
							     .addAnnotatedClass(Employee.class)
							     .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating Employee and Saving...");
			
			session.beginTransaction();
			
			Employee employee = new Employee("Tony3", "Star3", "Stark Industries3");
			Employee employee1 = new Employee("Tony4", "Stark4", "Stark Industries4");
			Employee employee2 = new Employee("Tony5", "Stark5", "Stark Industries5");
			
			session.save(employee);
			session.save(employee1);
			session.save(employee2);
			
			session.getTransaction().commit();
			
			System.out.println("created id: " + employee.getId());
			
			System.out.println("getting emp with id: "+employee.getId());
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Employee myEmployee = session.get(Employee.class, employee.getId());
			
			System.out.println("Get Complete: "+myEmployee);
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}

	}

}
