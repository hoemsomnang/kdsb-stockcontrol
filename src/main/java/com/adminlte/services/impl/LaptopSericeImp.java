package com.adminlte.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminlte.models.Branch;
import com.adminlte.models.Employee;
import com.adminlte.models.Laptop;
import com.adminlte.repositories.LaptopRepository;
import com.adminlte.services.LaptopService;
@Service
public class LaptopSericeImp implements LaptopService {

	@Autowired
	private LaptopRepository laptopRepository;
	
	
	/*
	 * Instock Block
	 */
	@Override
	public List<Laptop> getListInstockHQ() {
		// Get list of laptops at Head Quarter
		return laptopRepository.getListInstockHQ();
	}

	@Override
	public List<Laptop> getListInstockSaenSokh() {
		// Get list of laptops at Saen Sokh branch
		return laptopRepository.getListInstockSaenSokh();
	}

	@Override
	public int countInstockHQ() {
		// TODO Auto-generated method stub
		return laptopRepository.countInstockHQ();
	}

	@Override
	public int countUsingHQ() {
		// TODO Auto-generated method stub
		return laptopRepository.countUsingHQ();
	}

	@Override
	public int countAllHQ() {
		// TODO Auto-generated method stub
		return laptopRepository.countAllHQ();
	}

	@Override
	public int countInstockSaenSokh() {
		// TODO Auto-generated method stub
		return laptopRepository.countInstockSaenSokh();
	}

	@Override
	public int countUsingSaenSokh() {
		// TODO Auto-generated method stub
		return laptopRepository.countUsingSaenSokh();
	}

	@Override
	public int countAllSaenSokh() {
		// TODO Auto-generated method stub
		return laptopRepository.countAllSaenSokh();
	}

	/*
	 * Laptop Instock Block
	 */
	@Override
	public boolean saveInstock(Laptop laptop) {
		// Save laptop to instock
		return laptopRepository.saveInstock(laptop);
	}
	/*
	 * End Laptop Instock Block
	 */

	@Override
	public List<Branch> getListOfBranch() {
		// Get List Of Branch 
		return laptopRepository.getListOfBranch();
	}

	@Override
	public Optional<Laptop> findById(int lapid) {
		// Get Single Laptop by using lapid
		return laptopRepository.findById(lapid);
	}

	@Override
	public boolean updateInstock(Laptop laptop) {
		// Update Laptop Instock
		return laptopRepository.updateInstock(laptop);
	}

	@Override
	public boolean deleteInstock(int lapid) {
		// TODO Auto-generated method stub
		return laptopRepository.deleteInstock(lapid);
	}
    /*
     * End Instock Block
     */
	/*
	 * ===========================================
	 */
	
	/*
	 * Using Block
	 */
	@Override
	public List<Laptop> getListUsingHQ() {
		return laptopRepository.getListUsingHQ();
	}

	@Override
	public List<Laptop> getListUsingSaenSokh() {
		// TODO Auto-generated method stub
		return laptopRepository.getListusingSaenSokh();
	}

	@Override
	public List<Laptop> getListManagement() {
		/* Get List Laptop using for Management Team */
		return laptopRepository.getListManagement();
	}

	@Override
	public List<Laptop> getListHR() {
		/* Get list laptop using for HR and Admin Team */
		return laptopRepository.getListHR();
	}

	@Override
	public List<Laptop> getListITSupport() {
		/* Get List laptop using for IT Support Team */
		return laptopRepository.getListIT();
	}

	@Override
	public List<Laptop> getListCard() {
		/* Get list laptop using for Card Team */
		return laptopRepository.getListCard();
	}

	@Override
	public List<Laptop> getListFinance() {
		// Get list laptop using for Finance
		return laptopRepository.getListFinance();
	}

	@Override
	public List<Laptop> getListBizAdmin() {
		// Get list laptop using for business admin
		return laptopRepository.getListBizAdmin();
	}

	@Override
	public List<Laptop> getListBizOne() {
		// Get list laptop for business sales one
		return laptopRepository.getListBizOne();
	}

	@Override
	public List<Laptop> getListBizTwo() {
		// Get list laptop using for business sales two
		return laptopRepository.getListBizSalesTwo();
	}

	@Override
	public List<Laptop> getListBizThree() {
		// Get list laptop for business sale three
		return laptopRepository.getListBizSalesThree();
	}

	@Override
	public List<Laptop> getListBizFour() {
		// Get List laptop for business sales four
		return laptopRepository.getListBizSalesFour();
	}

	@Override
	public List<Laptop> getListMarketing() {
		// Get list laptop using for Marketing
		return laptopRepository.getListMarketing();
	}

	@Override
	public List<Laptop> getListInternalAudit() {
		// Get List laptop using for Internal Audit
		return laptopRepository.getListInternalAudit();
	}

	@Override
	public List<Laptop> getListRecovery() {
		// Get list laptop fpr Loan Recovery and Collection
		return laptopRepository.getListRecovery();
	}

	@Override
	public List<Laptop> getListLegal() {
		// Get list laptop for Legal and Compliance
		return laptopRepository.getListLegal();
	}

	@Override
	public List<Laptop> getListAssessment() {
		// Get list laptop for Assessment
		return laptopRepository.getListAssessment();
	}

	@Override
	public List<Laptop> getListRisk() {
		// Get list of laptop using for risk
		return laptopRepository.getListRisk();
	}

	@Override
	public List<Laptop> getListAllCO() {
		// Get list laptop using for ALL CO
		return laptopRepository.getListAllCO();
	}

	@Override
	public List<Laptop> getListusingSaenSokh() {
		// Get list laptop using at Saen Sokh branch
		return laptopRepository.getListusingSaenSokh();
	}

	@Override
	public List<Employee> getListEmployee() {
		// TODO Auto-generated method stub
		return laptopRepository.getListEmployee();
	}

	@Override
	public Optional<Employee> getSingleEmployee(int empid) {
		// Get single employee for add new laptop using
		return laptopRepository.getSingleEmployee(empid);
	}

	@Override
	public List<Laptop> getListLaptop() {
		// Get list laptop not yet using
		return laptopRepository.getListlaptop();
	}

	@Override
	public Optional<Laptop> getSingleLaptop(int lapid) {
		// Get single laptop 
		return laptopRepository.getSingleLaptop(lapid);
	}

	@Override
	public boolean saveUsing(Laptop laptop) {
		// Save laptop with employee for using
		return laptopRepository.saveUsing(laptop);
	}

	@Override
	public boolean updateUsing(Laptop laptop) {
		// TODO Auto-generated method stub
		return laptopRepository.updateUsing(laptop);
	}

	@Override
	public boolean returnTostock(int lapid) {
		// When employee want to change laptop or employee resign we need to return to stock
		return laptopRepository.returnTostock(lapid);
	}

	@Override
	public List<Laptop> getAll() {
		// TODO Auto-generated method stub
		return laptopRepository.getAll();
	}

	

	
	

}
