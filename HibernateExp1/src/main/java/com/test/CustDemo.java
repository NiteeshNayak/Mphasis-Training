package com.test;

public class CustDemo {
	public static void main(String[] args) {

		CustomerDao cdao = new CustomerDao();
		
		Customer cst = new Customer();
		
		cst.setC_name("Ibrahim");
		cst.setC_city("Saudi");
		
		cdao.saveCustomer(cst);
		//System.out.println("Before Update:");
		cdao.getAllCustomers().forEach(System.out::println);
		
		//cdao.updateCustomers(cst);
		
//		System.out.println("After Update:");
//		cdao.getAllCustomers().forEach(System.out::println);
		
//		cdao.deleteCustomer(1);
//		
//		System.out.println("After Delete:");
//		cdao.getAllCustomers().forEach(System.out::println);
	}
}
