package com.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CustomerDao {

	public static Session getDBSession() {

		Session session = null;
		try {
			Configuration cfg = new Configuration();

			cfg.configure("hibernate.cfg.xml");

			SessionFactory sf = cfg.buildSessionFactory();

			session = sf.openSession();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return session;
	}

	public void saveCustomer(Customer cst) {

		Session session = CustomerDao.getDBSession();

		Transaction t = session.beginTransaction();

		session.persist(cst);

		t.commit();
		
		session.close();

	}
	
	public List<Customer> getAllCustomers(){
		
		Session session = CustomerDao.getDBSession();
		
		return session.createQuery("from Customer").list();
	
	}
	
	public void updateCustomers(Customer cust) {
		Session session = CustomerDao.getDBSession();
		
		Transaction t = session.beginTransaction();
		
		Customer obj = session.get(Customer.class, cust.getC_id());
		
		obj.setC_name(cust.getC_name());
		obj.setC_city(cust.getC_city());
		
		session.persist(obj);
		
		t.commit();
		session.close();
	}
	
	public void deleteCustomer(int id) {
		Session session = CustomerDao.getDBSession();
		
		Transaction t = session.beginTransaction();
		
		Customer obj = session.get(Customer.class, id);
		
		session.remove(obj);
		
		t.commit();
		
		session.close();
	}
}
