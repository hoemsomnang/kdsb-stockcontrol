package com.adminlte.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminlte.models.Branch;
import com.adminlte.models.Department;
import com.adminlte.models.Employee;
import com.adminlte.repositories.EmployeeRepository;
import com.adminlte.services.EmployeeService;
@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	@Override
	public List<Employee> findAll() {
		// Get list of employee who is Head Quarter
		return employeeRepository.findAll();
	}

	@Override
	public List<Department> findDeptAll() {
		// Get list of Department
		return employeeRepository.findDeptAll();
	}

	@Override
	public List<Branch> findBranchAll() {
		// Get list of Branch
		return employeeRepository.findBranchAll();
	}

	@Override
	public boolean save(Employee emp) {
		
		return employeeRepository.save(emp);
	}

	@Override
	public Optional<Employee> findById(int empid) {
		return employeeRepository.findById(empid);
	}

	@Override
	public boolean update(Employee emp) {
		return employeeRepository.update(emp);
	}

	@Override
	public boolean delete(int empid) {
		return employeeRepository.delete(empid);
	}

	@Override
	public List<Employee> findManagement() {
		// Get list of top Management
		return employeeRepository.findManagement();
	}

	@Override
	public List<Employee> findHR() {
		// Get list of employee who is in HR and Admin Department
		return employeeRepository.findHR();
	}

	@Override
	public List<Employee> findIT() {
		// Get list of employee who is in IT Deparatment
		return employeeRepository.findIT();
	}

	@Override
	public List<Employee> findCard() {
		// Get list of employee who is in Card Department
		return employeeRepository.findCard();
	}

	@Override
	public List<Employee> findFinance() {
		// Get list of employee who is in Finance and Accounting Department
		return employeeRepository.findFinance();
	}

	@Override
	public List<Employee> findBizAdmin() {
		// Get list of employee who is in Business Admin Department (CSO Team)
		return employeeRepository.findBizAdmin();
	}

	@Override
	public List<Employee> findBizOne() {
		// Get list of employee who is in Business Sales 1 Team
		return employeeRepository.findBizOne();
	}

	@Override
	public List<Employee> findBizTwo() {
		// Get list of employee who is in Business Sales 2 Team
		return employeeRepository.findBizTwo();
	}

	@Override
	public List<Employee> findBizThree() {
		// Get list of employee who is in Business Sales 3 Team
		return employeeRepository.findBizThree();
	}

	@Override
	public List<Employee> findBizFour() {
		// Get list of employee who is in Business Sales 4 Team
		return employeeRepository.findBizFour();
	}

	@Override
	public List<Employee> findMarketing() {
		// Get list of employee who is in Marketing Department
		return employeeRepository.findMarketing();
	}

	@Override
	public List<Employee> findAudit() {
		// Get list of employee who is in Internal Audit Department
		return employeeRepository.findAudit();
	}

	@Override
	public List<Employee> findLegal() {
		// Get list of employee who is in Legal and Compliance Department
		return employeeRepository.findLegal();
	}

	@Override
	public List<Employee> findRecovery() {
		// Get list of employee who is in Loan Recovery Department
		return employeeRepository.findRecovery();
	}

	@Override
	public List<Employee> findAssessment() {
		// Get list of employee who is in Assessment  Department
		return employeeRepository.findAssessment();
	}

	@Override
	public List<Employee> findRisk() {
		// Get list of employee who is in Risk Department
		return employeeRepository.findRisk();
	}

	@Override
	public List<Employee> findSaenSokh() {
		// Get list of employees are in Saen Sokh Branch
		return employeeRepository.findSaenSokh();
	}

	@Override
	public List<Employee> finAllSaenSokh() {
		// Get list of employees are in Saen Sokh Branch
		return employeeRepository.findAllSaenSokh();
	}
   
	
	
	@Override
	public int femaleHQ() {
		// Counting all Female employee in Head Quarter
		return employeeRepository.femaleHQ();
	}

	@Override
	public int maleHQ() {
		// Counting all male employee in Head Quarter
		return employeeRepository.maleHQ();
	}

	@Override
	public int allHQ() {
		// Counting all  employee in Head Quarter
		return employeeRepository.allHQ();
	}

	@Override
	public int femaleSaenSokh() {
		// Counting all Female employee in Saen Sokh Branch
		return employeeRepository.femaleSaenSokh();
	}

	@Override
	public int maleSaenSokh() {
		// Counting all male employee in Saen Sokh Branch
		return employeeRepository.maleSaenSokh();
	}

	@Override
	public int allSaenSokh() {
		// Counting all employees in Saen Sokh Branch
		return employeeRepository.allSaenSokh();
	}

	

}
