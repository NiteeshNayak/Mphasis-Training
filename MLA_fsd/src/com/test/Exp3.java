package com.test;

@FunctionalInterface
interface FunInf3{
	void greetUser(String name, String msg);
}
public class Exp3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FunInf3 obj1 = (name, msg) -> System.out.println("name:"+name+" msg:"+msg);
		
		obj1.greetUser("anush", "hii");
	}
}
