package com.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData {
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory(); // validate user details
		
		Session session = sf.openSession();
		
		Transaction t = session.beginTransaction();
		
		Book obj = new Book();
		
		obj.setB_name("C");
		obj.setB_author("hp");
		obj.setB_price(20);
		
//		session.persist(obj);		//inserting
//		t.commit();
		
//		Book data = session.get(Book.class, 1);  //Reading one row with id = 1
//		System.out.println(data);
//		
//		data.setB_name("HTML");	 //updating
//		data.setB_author("James");
//		data.setB_price(11);
		//session.persist(data);
		//t.commit();
		
		//session.remove(data);  //deleting
//		t.commit();
		
//		List<Book> books = session.createNativeQuery("Select * from book", Book.class).list();
//		books.forEach(System.out::println); // getting all records from table
		
		List<Book> q = session.createQuery("from Book").list();
		q.forEach(System.out::println);	// getting all records from table
		
		System.out.println("Done");
	}
}
