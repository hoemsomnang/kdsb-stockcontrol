package com.adminlte.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Employee {

	private int empid;
	private String empname;
	private String sex;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd ")
	private Date dob;
	private Date hiredate;
	private float salary;
	private String team;
	private int deptid;
	private String deptname;
	private String position;
	private int brid;
	private String brname;
	private String phone;
	private String extension;
	private String email;
	private String remark;
	private int stopwork;
	public Employee() {
		
	}
	public Employee(int empid, String empname, String sex, Date dob, Date hiredate, float salary,
			String team, int deptid, String deptname, String position, int brid, String brname, String phone,
			String extension, String email, String remark, int stopwork) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.sex = sex;
		this.dob = dob;
		this.hiredate = hiredate;
		this.salary = salary;
		this.team = team;
		this.deptid = deptid;
		this.deptname = deptname;
		this.position = position;
		this.brid = brid;
		this.brname = brname;
		this.phone = phone;
		this.extension = extension;
		this.email = email;
		this.remark = remark;
		this.stopwork = stopwork;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
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
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getStopwork() {
		return stopwork;
	}
	public void setStopwork(int stopwork) {
		this.stopwork = stopwork;
	}
	
}
