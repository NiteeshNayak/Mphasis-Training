package com.test;

import java.security.Principal;

public class UserPrinciple implements Principal{
	
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public UserPrinciple(String name) {
		this.setName(name);
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	public String toString() {
		return name;
	}
}
