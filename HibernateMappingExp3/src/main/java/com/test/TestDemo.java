package com.test;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestDemo {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction t = session.beginTransaction();
		
		Order o1 = new Order();
		
		o1.setO_name("Orange");
		o1.setO_price("200");
		
		Order o2 = new Order();
		
		o2.setO_name("avacado");
		o2.setO_price("670");
		
		Customer cst = new Customer();
		
		cst.setOrder(Arrays.asList(o1,o2));
		cst.setC_name("Asif");
		
		session.persist(cst);
		
		t.commit();
		
		session.close();
	}
}
