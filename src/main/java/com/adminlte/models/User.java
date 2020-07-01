package com.adminlte.models;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class User implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 735760108034307270L;
	private int id;
	private String username;
	private String password;
	private boolean status;
	private List<UserRole> roles;
	public User() {
		
	}
	public User(int id, String username, String password, boolean status, List<UserRole> roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.status = status;
		this.roles = roles;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		/*
		 * BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder(); String
		 * encodepassword=passwordEncoder.encode(password); this.password =
		 * encodepassword;
		 */
		this.password=password;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public List<UserRole> getRoles() {
		return roles;
	}
	public void setRoles(List<UserRole> roles) {
		this.roles = roles;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return roles;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return this.status;
	}
	
	
}
