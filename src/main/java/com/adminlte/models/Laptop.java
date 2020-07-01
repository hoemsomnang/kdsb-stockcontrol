package com.adminlte.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Laptop {

	private int lapid;
	private int empid;
	private String empname;
	private String position;
	private String model;
	private String pcname;
	private String cpu;
	private String ram;
	private String hhd;
	private String display;
	private String os;
	private String sn;
	private String asset;
	private String version;
	private String remark;
	private String status;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd ")
	private Date datein;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd ")
	private Date dateusing;
	private String location1;
	private String location2;
	private int issue;
	private int brid;
	private String brname;
	private int deptid;
	private String deptname;
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Laptop(int lapid, int empid, String empname, String model, String pcname, String cpu, String ram, String hhd,
			String display, String os, String sn, String asset, String version, String remark, String status,
			Date datein, Date dateusing, String location1, String location2, int issue, int brid, String brname,
			int deptid, String deptname,String position) {
		super();
		this.lapid = lapid;
		this.empid = empid;
		this.empname = empname;
		this.model = model;
		this.pcname = pcname;
		this.cpu = cpu;
		this.ram = ram;
		this.hhd = hhd;
		this.display = display;
		this.os = os;
		this.sn = sn;
		this.asset = asset;
		this.version = version;
		this.remark = remark;
		this.status = status;
		this.datein = datein;
		this.dateusing = dateusing;
		this.location1 = location1;
		this.location2 = location2;
		this.issue = issue;
		this.brid = brid;
		this.brname = brname;
		this.deptid = deptid;
		this.deptname = deptname;
		this.position= position;
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
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public Laptop() {
		
	}
	public int getLapid() {
		return lapid;
	}
	public void setLapid(int lapid) {
		this.lapid = lapid;
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
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getPcname() {
		return pcname;
	}
	public void setPcname(String pcname) {
		this.pcname = pcname;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getHhd() {
		return hhd;
	}
	public void setHhd(String hhd) {
		this.hhd = hhd;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getAsset() {
		return asset;
	}
	public void setAsset(String asset) {
		this.asset = asset;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public int getIssue() {
		return issue;
	}
	public void setIssue(int issue) {
		this.issue = issue;
	}
	
	
	
	
	
}
