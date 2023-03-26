package com.simplilearn.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="userstable")
public class UserDetails {

	
	
	@Id
	@GeneratedValue
	private int pid;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String username;
	private String password;
	
	
	@Override
	public String toString() {
		
		return "UsersDetailsModel [pid=" + pid + ", username=" + username + ", password=" + password + "]";

	
	}
}	

	