package com.adminlte.services;

import java.util.List;
import java.util.Optional;

import com.adminlte.models.Branch;
import com.adminlte.models.Employee;
import com.adminlte.models.Laptop;

public interface LaptopService {
	/*==============================================*/
	/*---------------Get All Laptop-----------------*/
	public List<Laptop> getAll();
	/*...............Instock........................*/
	/* List Instock */
	public List<Laptop> getListInstockHQ();
	public List<Laptop> getListInstockSaenSokh();
	public List<Branch> getListOfBranch();
	
	/* Counting HQ */
	public int countInstockHQ();
	public int countUsingHQ();
	public int countAllHQ();
	
	/* Counting Saen Sokh */
	public int countInstockSaenSokh();
	public int countUsingSaenSokh();
	public int countAllSaenSokh();
	
	public boolean saveInstock(Laptop laptop);
	public Optional<Laptop> findById(int lapid);
	public boolean updateInstock(Laptop laptop);
	public boolean deleteInstock(int lapid);
	/*..................End Instock Block..................*/
	/* ====================================================*/
	
	/*..................Using Block.......................*/
	public List<Laptop> getListUsingHQ();
	public List<Laptop> getListUsingSaenSokh();
	public List<Laptop> getListManagement();
	public List<Laptop> getListHR();
	public List<Laptop> getListITSupport();
	public List<Laptop> getListCard();
	public List<Laptop> getListFinance();
	public List<Laptop> getListBizAdmin();
	public List<Laptop> getListBizOne();
	public List<Laptop> getListBizTwo();
	public List<Laptop> getListBizThree();
	public List<Laptop> getListBizFour();
	public List<Laptop> getListMarketing();
	public List<Laptop> getListInternalAudit();
	public List<Laptop> getListRecovery();
	public List<Laptop> getListLegal();
	public List<Laptop> getListAssessment();
	public List<Laptop> getListRisk();
	public List<Laptop> getListAllCO();
	public List<Laptop> getListusingSaenSokh();
	public List<Employee> getListEmployee();
	/* Get single Employee for Combo box in add laptop Using */
	public Optional<Employee> getSingleEmployee(int empid);
	/*           Get list of laptop not yet using            */
	public List<Laptop> getListLaptop();
	/*           Get single laptop for add new using        */
	public Optional<Laptop> getSingleLaptop(int lapid);
	/*..................End Using Block....................*/
	/*.................Save Laptop Using....................*/
	public boolean saveUsing(Laptop laptop);
	/*................Update laptop Using....................*/
	public boolean updateUsing(Laptop laptop);
	/*................Reurn to Stock........................*/
	public boolean returnTostock(int lapid);
	/*=====================================================*/
}
