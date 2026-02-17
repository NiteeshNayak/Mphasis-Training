package com.test;

@FunctionalInterface
interface FunInf{
	void draw();
	
	default void dog() {
		
	}
	
	static void cat() {
		
	}
}

class Circle implements FunInf{
	@Override
	public void draw() {
		System.out.println("Circle");
	}
	
}

class Square implements FunInf{
	
	@Override
	public void draw() {
		System.out.println("Square");
	}
	
	//factory
	public Square getObj() {	//return type is same as class Name
		System.out.println("Object returned");
		return new Square();
	}
}

public class Exp2 {

	public static void main(String[] args) {
		FunInf obj1 = new Circle();
		
		obj1.draw();
		
		
		Square obj2 = new Square();
		
		obj2.draw();
		
		Square obj3 = obj2.getObj();
		
		FunInf obj4 = () -> System.out.println("Circle");
		
		obj4.draw();
	}

}
