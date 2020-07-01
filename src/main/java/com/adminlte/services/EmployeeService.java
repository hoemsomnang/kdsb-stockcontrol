package com.adminlte.services;

import java.util.List;
import java.util.Optional;

import com.adminlte.models.Branch;
import com.adminlte.models.Department;
import com.adminlte.models.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	public List<Employee> finAllSaenSokh();
	public List<Department> findDeptAll();
	public List<Branch> findBranchAll();
	public boolean save(Employee emp);
	public Optional<Employee> findById(int empid);
	public boolean update(Employee emp);
	public boolean delete(int empid);
	//
	
	public List<Employee> findManagement();
	public List<Employee> findHR();
	public List<Employee> findIT();
	public List<Employee> findCard();
	public List<Employee> findFinance();
	public List<Employee> findBizAdmin();
	public List<Employee> findBizOne();
	public List<Employee> findBizTwo();
	public List<Employee> findBizThree();
	public List<Employee> findBizFour();
	public List<Employee> findMarketing();
	public List<Employee> findAudit();
	public List<Employee> findLegal();
	public List<Employee> findRecovery();
	public List<Employee> findAssessment();
	public List<Employee> findRisk();
	public List<Employee> findSaenSokh();
	/*
	 * Head Quarter
	 */
	public int femaleHQ();
	public int maleHQ();
	public int allHQ();
	/*
	 * Saen Sokh
	 */
	public int femaleSaenSokh();
	public int maleSaenSokh();
	public int allSaenSokh();
	
}
