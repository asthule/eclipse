package com.simplilearn.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Teacher {

	@Id
	@GeneratedValue
	private int age;
	private String name;
	private int id;
	
	@OneToMany(mappedBy = "teach")
	
	private List<Classes> cla = new ArrayList<Classes>();
	
	
	public List<Classes> getCla() {
		return cla;
	}
	public void setCla(List<Classes> cla) {
		this.cla = cla;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
