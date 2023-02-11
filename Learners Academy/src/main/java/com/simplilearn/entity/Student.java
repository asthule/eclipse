package com.simplilearn.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Student {

	@Id
	private int id;
	private int age;
	private String fname;
	private String lname;
	private String aclass;
	
	
	@OneToOne
	private Classes cl;
	
	public Classes getCl() {
		return cl;
	}
	public void setCl(Classes cl) {
		this.cl = cl;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getAclass() {
		return aclass;
	}
	public void setAclass(String aclass) {
		this.aclass = aclass;
	}
	
	
	
	
}
