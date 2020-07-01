package com.adminlte.services;

import java.util.List;
import java.util.Optional;

import com.adminlte.models.User;
import com.adminlte.models.UserRole;

public interface UserService {

	
	User findByUsername(String username);
	
	public List<User> findAll();
	public List<UserRole> findRole();
	
	public boolean save(User user);
	
	public boolean update(User user);
	
	public boolean delete(int userid);
	
	public Optional<User> findById(int useid);
	
	
	
}
