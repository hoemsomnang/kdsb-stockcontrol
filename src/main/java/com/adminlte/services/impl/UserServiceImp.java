package com.adminlte.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.adminlte.models.User;
import com.adminlte.models.UserRole;
import com.adminlte.repositories.UserRepository;
import com.adminlte.services.UserService;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> findAll() {
		List<User> userList=userRepository.findAll();
		
		// TODO Auto-generated method stub
		return userList;
	}

	@Override
	public List<UserRole> findRole() {
		List<UserRole> userRole=userRepository.findRole();
		return userRole;
	}

	

	@Override
	public boolean save(User user) {
		boolean status=userRepository.save(user);
		if(status) {
			
		}else {
			System.out.println("Error");
		}
		return status;
	}

	@Override
	public Optional<User> findById(int useid) {
		
		return userRepository.findById(useid);
	}

	@Override
	public boolean update(User user) {
		boolean status=userRepository.update(user);
		if(status) {
			System.out.println("save");
		}else {
			System.out.println("Error");
		}
		return status;
	}

	@Override
	public boolean delete(int useid) {
		return userRepository.delete(useid);
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}

	

	

	

	
}
