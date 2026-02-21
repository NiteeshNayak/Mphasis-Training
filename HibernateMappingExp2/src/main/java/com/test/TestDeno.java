package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestDeno {
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction t = session.beginTransaction();
		
		
		Address address = new Address();
		
		address.setCity("Karkala");
		address.setState("Karnataka");
		
		Employee emp = new Employee();
		
		emp.setE_name("Siraj");
		emp.setE_cmp("Mphasis");
		
		address.setEmployee(emp);
		emp.setAddress(address);
		
		session.persist(emp);
		
		t.commit();
		
		session.close();
	}
}
