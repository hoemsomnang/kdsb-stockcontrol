package com.adminlte.services;

import java.util.List;
import java.util.Optional;

import com.adminlte.models.Branch;

public interface BranchService {

	//Method Get All Data From Branch Table
	public List<Branch> findAll();
	//Method Save Data into Database
	public boolean save(Branch br);
	//Method Get Single Branch
	public Optional<Branch> findById(int brid);
	//Method Update Branch
	public boolean update(Branch br);
	//Method Delete Branch
	public boolean delete(int brid);
	
}
