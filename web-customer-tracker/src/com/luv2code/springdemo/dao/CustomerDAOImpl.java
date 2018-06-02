package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//inject session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		//get the current session
		Session session = sessionFactory.getCurrentSession();
		
		//create a query
		Query<Customer> query = session.createQuery("from Customer order by lastName",
										Customer.class);
		
		//execute the query and get result list
		List<Customer> customers = query.getResultList();
		
		//return list
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		//get session
		Session session = sessionFactory.getCurrentSession();
		
		//save the customer
		session.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int theId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Customer customer = session.get(Customer.class, theId);
		
		return customer;
	}

	@Override
	public void deleteCustomer(int theId) {

		//get the session
		Session session = sessionFactory.getCurrentSession();
		
		//delete the customer
		Query query = session.createQuery("delete from Customer where id=:customerId");
		
		query.setParameter("customerId", theId);
		
		query.executeUpdate();
	}

}
