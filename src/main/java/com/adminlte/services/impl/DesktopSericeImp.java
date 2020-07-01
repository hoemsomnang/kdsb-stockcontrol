package com.adminlte.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminlte.models.Branch;
import com.adminlte.models.Employee;
import com.adminlte.models.Desktop;
import com.adminlte.repositories.DesktopRepository;
import com.adminlte.services.DesktopService;
@Service
public class DesktopSericeImp implements DesktopService {

	@Autowired
	private DesktopRepository desktopRepository;
	
	
	/*
	 * Instock Block
	 */
	@Override
	public List<Desktop> getListInstockHQ() {
		// Get list of Desktop at Head Quarter
		return desktopRepository.getListInstockHQ();
	}

	@Override
	public List<Desktop> getListInstockSaenSokh() {
		// Get list of Desktop at Saen Sokh branch
		return desktopRepository.getListInstockSaenSokh();
	}

	@Override
	public int countInstockHQ() {
		// TODO Auto-generated method stub
		return desktopRepository.countInstockHQ();
	}

	@Override
	public int countUsingHQ() {
		// TODO Auto-generated method stub
		return desktopRepository.countUsingHQ();
	}

	@Override
	public int countAllHQ() {
		// TODO Auto-generated method stub
		return desktopRepository.countAllHQ();
	}

	@Override
	public int countInstockSaenSokh() {
		// TODO Auto-generated method stub
		return desktopRepository.countInstockSaenSokh();
	}

	@Override
	public int countUsingSaenSokh() {
		// TODO Auto-generated method stub
		return desktopRepository.countUsingSaenSokh();
	}

	@Override
	public int countAllSaenSokh() {
		// TODO Auto-generated method stub
		return desktopRepository.countAllSaenSokh();
	}

	/*
	 * Desktop Instock Block
	 */
	@Override
	public boolean saveInstock(Desktop desktop) {
		// Save Desktop to instock
		return desktopRepository.saveInstock(desktop);
	}
	/*
	 * End Desktop Instock Block
	 */

	@Override
	public List<Branch> getListOfBranch() {
		// Get List Of Branch 
		return desktopRepository.getListOfBranch();
	}

	@Override
	public Optional<Desktop> findById(int desid) {
		// Get Single Desktop by using desid
		return desktopRepository.findById(desid);
	}

	@Override
	public boolean updateInstock(Desktop desktop) {
		// Update Desktop Instock
		return desktopRepository.updateInstock(desktop);
	}

	@Override
	public boolean deleteInstock(int desid) {
		// TODO Auto-generated method stub
		return desktopRepository.deleteInstock(desid);
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
	public List<Desktop> getListUsingHQ() {
		return desktopRepository.getListUsingHQ();
	}

	@Override
	public List<Desktop> getListUsingSaenSokh() {
		// TODO Auto-generated method stub
		return desktopRepository.getListusingSaenSokh();
	}

	@Override
	public List<Desktop> getListManagement() {
		/* Get List Desktop using for Management Team */
		return desktopRepository.getListManagement();
	}

	@Override
	public List<Desktop> getListHR() {
		/* Get list Desktop using for HR and Admin Team */
		return desktopRepository.getListHR();
	}

	@Override
	public List<Desktop> getListITSupport() {
		/* Get List Desktop using for IT Support Team */
		return desktopRepository.getListIT();
	}

	@Override
	public List<Desktop> getListCard() {
		/* Get list Deskop using for Card Team */
		return desktopRepository.getListCard();
	}

	@Override
	public List<Desktop> getListFinance() {
		// Get list Desktop using for Finance
		return desktopRepository.getListFinance();
	}

	@Override
	public List<Desktop> getListBizAdmin() {
		// Get list Desktop using for business admin
		return desktopRepository.getListBizAdmin();
	}

	@Override
	public List<Desktop> getListBizOne() {
		// Get list Desktop for business sales one
		return desktopRepository.getListBizOne();
	}

	@Override
	public List<Desktop> getListBizTwo() {
		// Get list Desktop using for business sales two
		return desktopRepository.getListBizSalesTwo();
	}

	@Override
	public List<Desktop> getListBizThree() {
		// Get list Desktop for business sale three
		return desktopRepository.getListBizSalesThree();
	}

	@Override
	public List<Desktop> getListBizFour() {
		// Get List Desktop for business sales four
		return desktopRepository.getListBizSalesFour();
	}

	@Override
	public List<Desktop> getListMarketing() {
		// Get list Desktop using for Marketing
		return desktopRepository.getListMarketing();
	}

	@Override
	public List<Desktop> getListInternalAudit() {
		// Get List Desktop using for Internal Audit
		return desktopRepository.getListInternalAudit();
	}

	@Override
	public List<Desktop> getListRecovery() {
		// Get list Desktop fpr Loan Recovery and Collection
		return desktopRepository.getListRecovery();
	}

	@Override
	public List<Desktop> getListLegal() {
		// Get list Desktop for Legal and Compliance
		return desktopRepository.getListLegal();
	}

	@Override
	public List<Desktop> getListAssessment() {
		// Get list Desktop for Assessment
		return desktopRepository.getListAssessment();
	}

	@Override
	public List<Desktop> getListRisk() {
		// Get list of Desktop using for risk
		return desktopRepository.getListRisk();
	}

	@Override
	public List<Desktop> getListAllCO() {
		// Get list Desktop using for ALL CO
		return desktopRepository.getListAllCO();
	}

	@Override
	public List<Desktop> getListusingSaenSokh() {
		// Get list Desktop using at Saen Sokh branch
		return desktopRepository.getListusingSaenSokh();
	}

	@Override
	public List<Employee> getListEmployee() {
		// TODO Auto-generated method stub
		return desktopRepository.getListEmployee();
	}

	@Override
	public Optional<Employee> getSingleEmployee(int empid) {
		// Get single employee for add new Desktop using
		return desktopRepository.getSingleEmployee(empid);
	}

	

	@Override
	public boolean saveUsing(Desktop desktop) {
		// Save Desktop with employee for using
		return desktopRepository.saveUsing(desktop);
	}

	@Override
	public boolean updateUsing(Desktop desktop) {
		// TODO Auto-generated method stub
		return desktopRepository.updateUsing(desktop);
	}

	@Override
	public boolean returnTostock(int desid) {
		// When employee want to change Desktop or employee resign we need to return to stock
		return desktopRepository.returnTostock(desid);
	}

	@Override
	public List<Desktop> getAll() {
		// TODO Auto-generated method stub
		return desktopRepository.getAll();
	}

	@Override
	public List<Desktop> getListDesktop() {
		// TODO Auto-generated method stub
		return desktopRepository.getListDesktop();
	}

	@Override
	public Optional<Desktop> getSingleDesktop(int desid) {
		// TODO Auto-generated method stub
		return desktopRepository.getSingleDesktop(desid);
	}

	

	

}
