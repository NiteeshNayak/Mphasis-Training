package com.test;

import java.util.List;

public class TestDemo {
	public static void main(String[] args) {
		EmpDao edao = new EmpDao();
		
		Employee emp1 = new Employee();
		
		emp1.setId(3);
		emp1.setName("kkr");
		emp1.setCmp("pwc");
		emp1.setCity("pune");
		//edao.saveEmployee(emp1);
		
		//System.out.println("Saved 1 recored");
		
		List<Employee> empList = edao.getAllEmployees();
		
		empList.forEach(System.out::println);
		
		edao.updateEmployee(emp1);
		
		//edao.deleteEmployee(4);
		
		System.out.println("After update and delete");
		List<Employee> empList2 = edao.getAllEmployees();
		
		empList2.forEach(System.out::println);
	}
}
