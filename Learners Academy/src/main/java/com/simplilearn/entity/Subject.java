package com.simplilearn.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Subject {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String shortcut;
	
	@ManyToOne
	 private Classes clas;
	
	public Classes getClas() {
		return clas;
	}
	public void setClas(Classes clas) {
		this.clas = clas;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortcut() {
		return shortcut;
	}
	public void setShortcut(String shortcut) {
		this.shortcut = shortcut;
	}
	
	
	
	
}
