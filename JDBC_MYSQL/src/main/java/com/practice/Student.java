package com.practice;

public class Student {
	private String usn;
	private String name;
	private String clg;
	public String getUsn() {
		return usn;
	}
	public void setUsn(String usn) {
		this.usn = usn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClg() {
		return clg;
	}
	public void setClg(String clg) {
		this.clg = clg;
	}
	@Override
	public String toString() {
		return "Student [usn=" + usn + ", name=" + name + ", clg=" + clg + "]";
	}
}
