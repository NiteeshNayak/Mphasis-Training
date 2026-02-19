package com.practice;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		StudentDao sdao = new StudentDao();
		
		Student s = new Student();
		
		s.setUsn("108");
		s.setName("Rakesh");
		s.setClg("MITE");
		
//		sdao.saveStudent(s);
//		System.out.println("Saved Successfully");
		
		System.out.println("Table Entries Before Any Operation");
		List<Student> studentList = sdao.getStudents();
		studentList.forEach(System.out::println);
		
		sdao.updateStudent(s);
		
		System.out.println("Table Entries After Update");
		List<Student> studentList1 = sdao.getStudents();
		studentList1.forEach(System.out::println);
		
		sdao.deleteStudent("109");
		System.out.println("Table Entries After Delete on Usn = 109");
		List<Student> studentList2 = sdao.getStudents();
		studentList2.forEach(System.out::println);
	}
}
