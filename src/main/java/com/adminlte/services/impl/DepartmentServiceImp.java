package com.adminlte.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminlte.models.Department;
import com.adminlte.repositories.DepartmentRepository;
import com.adminlte.services.DepartmentService;

@Service
public class DepartmentServiceImp implements DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;
	
	@Override
	public List<Department> findAll() {
		List<Department> deptlist=departmentRepository.findAll();
		return deptlist;
	}

	@Override
	public boolean save(Department dept) {
		
		return departmentRepository.save(dept);
	}

	

	@Override
	public Optional<Department> findById(int deptid) {
		
		return departmentRepository.findById(deptid);
	}

	@Override
	public boolean update(Department dept) {
		
		return departmentRepository.update(dept);
	}

	@Override
	public boolean delete(int deptid) {
		// TODO Auto-generated method stub
		return departmentRepository.delete(deptid);
	}

}
