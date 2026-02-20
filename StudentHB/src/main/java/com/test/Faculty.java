package com.test;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@DiscriminatorValue("faculty")
//@Table(name = "faculty")
//@PrimaryKeyJoinColumn()
public class Faculty extends College{
	private String f_tpe;
	
	private String f_skill;

	public Faculty() {
		
	}

	public Faculty(String f_tpe, String f_skill) {
		
		this.f_tpe = f_tpe;
		this.f_skill = f_skill;
	}

	public String getF_tpe() {
		return f_tpe;
	}

	public void setF_tpe(String f_tpe) {
		this.f_tpe = f_tpe;
	}

	public String getF_skill() {
		return f_skill;
	}

	public void setF_skill(String f_skill) {
		this.f_skill = f_skill;
	}

	@Override
	public String toString() {
		return "Faculty [f_tpe=" + f_tpe + ", f_skill=" + f_skill + "]";
	}
	
}
