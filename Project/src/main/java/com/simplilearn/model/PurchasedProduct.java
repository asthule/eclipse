package com.simplilearn.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="purchasedproducts")
public class PurchasedProduct {

	
	@Id
	@GeneratedValue
	private int rid;
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getDateofpurchase() {
		return dateofpurchase;
	}
	public void setDateofpurchase(String dateofpurchase) {
		this.dateofpurchase = dateofpurchase;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	private String dateofpurchase;
	private String pname;
	private String email;
	private String address;
	private int pid;
	
	
	@Override
	public String toString() {
		return "PurchasedProductsModel [rid=" + rid + ", dateofpurchase=" + dateofpurchase + ", pname=" + pname
				+ ", email=" + email + ", mobileno=" + ", pid=" + pid + "]";
	}
	
}
