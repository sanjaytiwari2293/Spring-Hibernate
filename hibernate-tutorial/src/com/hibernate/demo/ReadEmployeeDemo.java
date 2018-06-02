package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Employee;

public class ReadEmployeeDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Employee.class)
								 .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		List<Employee> list = session.createQuery("from Employee").getResultList();
		
		for (Employee employee : list) {
			
			System.out.println(employee);
		}
		
		session.getTransaction().commit();

	}

}
