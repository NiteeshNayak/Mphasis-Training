package com.test;

//Interface is public property
interface Inf1{
	float pi = 3.14f;	//variable are public static final property
	
	void disp();	//public abstract
	void cat();
	
	default void human() { // It can be overrided
		animal();
		System.out.println("Default information");
	}
	
	static String greetUser(String msg) {
		//animal();      Non static method cant be accessed here because this is static method
		return msg;
	}
	
	private void animal() {
		System.out.println("Private method");
	}
}

interface Inf2{
	void book();
}

abstract class Abs1{ // can have constructor but no object can be created
	
	public Abs1() {
		System.out.println("Constructor");
	}
	
	public abstract void fox();
	
	public void color() {
		System.out.println("Implemented method");
	}
}

class Impl1 extends Abs1 implements Inf1, Inf2{
	public  void fox() {
		System.out.println("Abs implemented");
	}
	
	@Override
	public void disp() {
		System.out.println("Implemented Inf1 method");
	}
	
	@Override
	public void cat() {
		System.out.println("Implemented Inf1 method");
	}
	
	@Override
	public void book() {
		System.out.println("Implemented Inf2 method");
	}
}

public class Example1 {
	public static void main(String[] args) {
		Impl1 obj = new Impl1();
		
		obj.book();
		obj.cat();
		obj.disp();
		obj.human();
		obj.fox();
		obj.color();
		
		System.out.println(Inf1.greetUser("Hiii"));
	}
}


/*	Ways to create object
 1. using NEW operartor
 2. using factory method
 3. using clone() method 
 4. using Class.forName() dynamic object creation	
 */
 