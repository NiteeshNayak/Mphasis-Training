package com.test.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class EmployeeAspectPointCut {
	
	@Before("getNamePointCut()")
	public void loggingAdvice(){
		System.out.println("Execution logging advice on getName()");
	}
	
	@Before("getNamePointcut()")
	public void secondAdvice() {
		System.out.println("Executing secondAdvice getName() method");
	}
	
	@Pointcut("execution(public String getName())")
	public void getNamePointcut() {
		
	}
	
	@Before("allMethodsPointcut()")
	public void allServiceMethodsAdvice() {
		System.out.println("Before execution service method");
	}
	
	@Pointcut("within(com.test.service.*)")
	public void allMethodsPointcut() {
		
	}
}
