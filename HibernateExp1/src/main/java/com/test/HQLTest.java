package com.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLTest {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction t = session.beginTransaction();
		
//		String hql = "from Customer";
//		
//		List<Customer> dt = session.createQuery(hql).list();
//
//		System.out.println("HQL Result: ");
//		
//		dt.forEach(System.out::println);
//		
//		System.out.println(dt);
		
		String hql = "delete from Customer where c_id = :id";
		
		
		Query q = session.createQuery(hql);
		
		q.setParameter("id",2);
		
		int row = q.executeUpdate();
		
		t.commit();
		
	}
}
