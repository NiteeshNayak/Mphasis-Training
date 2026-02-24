package com.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookDemo {
	public static void main(String[] args) {
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
//		
//		Book bk = (Book)ctx.getBean("bk");
//		
//		System.out.println(bk);
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AnnoConfig.class);
		BookDetails b1 = ctx.getBean(BookDetails.class);
		
		Book b2 = ctx.getBean(Book.class);
		
		b1.setPages(200);
		b1.setPublisher("K P Arjun");
		b1.setPyear(2026);
		
		b2.setId(25);
		b2.setName("Pyaar ka Boonde");
		b2.setPrice(2300);
		b2.setAuthor("Anush");
		b2.setListbd(List.of(b1));
		
		System.out.println(b2);
	}
}
