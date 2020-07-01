package com.adminlte.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminlte.models.Branch;
import com.adminlte.repositories.BranchRepository;
import com.adminlte.services.BranchService;
@Service
public class BranchServiceImp implements BranchService {

	@Autowired
	BranchRepository branchRepository;
	@Override
	public List<Branch> findAll() {
		// TODO Auto-generated method stub
		return branchRepository.findAll() ;
	}

	@Override
	public boolean save(Branch br) {
		// TODO Auto-generated method stub
		return branchRepository.save(br);
	}

	@Override
	public Optional<Branch> findById(int brid) {
		// TODO Auto-generated method stub
		return branchRepository.findById(brid);
	}

	@Override
	public boolean update(Branch br) {
		// TODO Auto-generated method stub
		return branchRepository.update(br);
	}

	@Override
	public boolean delete(int brid) {
		// TODO Auto-generated method stub
		return branchRepository.delete(brid);
	}

}
