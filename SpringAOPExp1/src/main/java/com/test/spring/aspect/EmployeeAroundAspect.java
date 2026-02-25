package com.test.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class EmployeeAroundAspect {

	@Around("excution(* com.test.Employee.getName())")
	public Object employeeAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		System.out.println("Before invoking getName() method");
		
		Object value = null;
		
		try {
			value = proceedingJoinPoint.proceed();
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		System.out.println("After invoking getName method and value");
		
		return value;
	}
}
