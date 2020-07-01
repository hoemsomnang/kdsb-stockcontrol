package com.adminlte.models;

import org.springframework.security.core.GrantedAuthority;

public class UserRole implements GrantedAuthority{

	private int id;
	private String rolename;
	private boolean status;
	private int user_id;
	public UserRole() {
		
	}
	public UserRole(int id, String rolename, boolean status, int user_id) {
		super();
		this.id = id;
		this.rolename = rolename;
		this.status = status;
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "UserRole [id=" + id + ", rolename=" + rolename + ", status=" + status + ", user_id=" + user_id + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return rolename;
	}
	
	
	
	
}
