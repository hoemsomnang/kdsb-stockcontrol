package com.adminlte.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Devices {

	private int devid;
	private int empid;
	private String empname;
	private int cateid;
	private String catename;
	private String name;
	private String model;
	private String version;
	private String asset;
	private String remark;
	private int qty;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd ")
	private Date datein;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd ")
	private Date dateusing;
	private String status;
	private String location1;
	private String location2;
	private String brid;
	private String brname;
	public Devices() {
		
	}
	public Devices(int devid, int empid, String empname, int cateid, String catename, String model, String version,
			String asset, String remark, int qty, Date datein, Date dateusing, String status, String location1,
			String location2, String brid, String brname,String name) {
		super();
		this.devid = devid;
		this.empid = empid;
		this.empname = empname;
		this.cateid = cateid;
		this.catename = catename;
		this.model = model;
		this.version = version;
		this.asset = asset;
		this.remark = remark;
		this.qty = qty;
		this.datein = datein;
		this.dateusing = dateusing;
		this.status = status;
		this.location1 = location1;
		this.location2 = location2;
		this.brid = brid;
		this.brname = brname;
		this.brname=name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDevid() {
		return devid;
	}
	public void setDevid(int devid) {
		this.devid = devid;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
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
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getAsset() {
		return asset;
	}
	public void setAsset(String asset) {
		this.asset = asset;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public Date getDatein() {
		return datein;
	}
	public void setDatein(Date datein) {
		this.datein = datein;
	}
	public Date getDateusing() {
		return dateusing;
	}
	public void setDateusing(Date dateusing) {
		this.dateusing = dateusing;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLocation1() {
		return location1;
	}
	public void setLocation1(String location1) {
		this.location1 = location1;
	}
	public String getLocation2() {
		return location2;
	}
	public void setLocation2(String location2) {
		this.location2 = location2;
	}
	public String getBrid() {
		return brid;
	}
	public void setBrid(String brid) {
		this.brid = brid;
	}
	public String getBrname() {
		return brname;
	}
	public void setBrname(String brname) {
		this.brname = brname;
	}
	
	
	
}
