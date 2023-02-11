package com.simplilearn.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Classes {

	@Id
	private int id;
	private int section;
	private String teacher;
	private String subject;
	private String time;
	private String name;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@ManyToOne
	private Teacher tteach;
	
	public Teacher getTteach() {
		return tteach;
	}
	public void setTteach(Teacher tteach) {
		this.tteach = tteach;
	}
	public List<Subject> getSub() {
		return sub;
	}
	public void setSub(List<Subject> sub) {
		this.sub = sub;
	}
	@OneToMany(mappedBy = "lcla")
	
	private List<Subject> sub = new ArrayList<Subject>();
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSection() {
		return section;
	}
	public void setSection(int section) {
		this.section = section;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
	
	
}
