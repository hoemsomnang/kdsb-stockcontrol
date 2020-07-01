package com.adminlte.models;

public class Category {

	private int cateid;
	private String catename;
	public int getCateid() {
		return cateid;
	}
	public void setCateid(int cateid) {
		this.cateid = cateid;
	}
	public String getCatename() {
		return catename;
	}
	public void setCatename(String catename) {
		this.catename = catename;
	}
	public Category(int cateid, String catename) {
		super();
		this.cateid = cateid;
		this.catename = catename;
	}
	public Category() {
		
	}
	
	
}
