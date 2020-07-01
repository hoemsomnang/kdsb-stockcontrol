package com.adminlte.services;

import java.util.List;
import java.util.Optional;

import com.adminlte.models.Department;


public interface DepartmentService {

	public List<Department> findAll();
	public boolean save(Department dept);
	public Optional<Department> findById(int deptid);
	public boolean update(Department dept);
	public boolean delete(int deptid);
}
