package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
	public static void main(String[] args) {
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
//		
//		System.out.println(ctx.getBean("cst1",Customer.class));
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AnnoConfig.class);
		
		Address adr = ctx.getBean(Address.class);
		
		adr.setCity("S katte");
		adr.setCountry("IND");
		adr.setState("karnataka");
		
		Customer cst = ctx.getBean(Customer.class);
		
		cst.setId(101);
		cst.setName("Mhd Ansh Ikbal");
		cst.setAdr(adr);
		
		System.out.println(cst);
	}
}
