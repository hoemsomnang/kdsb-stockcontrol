package com.adminlte.models;

public class Branch {
	private int brid;
	private String brname;
	
	public Branch() {
		
	}
	public Branch(int brid,String brname) {
		this.brid=brid;
		this.brname=brname;
	}
	public int getBrid() {
		return brid;
	}
	public void setBrid(int brid) {
		this.brid = brid;
	}
	public String getBrname() {
		return brname;
	}
	public void setBrname(String brname) {
		this.brname = brname;
	}

}
