package com.adminlte.services;

import java.util.List;
import java.util.Optional;

import com.adminlte.models.Branch;
import com.adminlte.models.Employee;
import com.adminlte.models.Desktop;

public interface DesktopService {
	/*==============================================*/
	/*---------------Get All Desktop-----------------*/
	public List<Desktop> getAll();
	/*...............Instock........................*/
	/* List Instock */
	public List<Desktop> getListInstockHQ();
	public List<Desktop> getListInstockSaenSokh();
	public List<Branch> getListOfBranch();
	
	/* Counting HQ */
	public int countInstockHQ();
	public int countUsingHQ();
	public int countAllHQ();
	
	/* Counting Saen Sokh */
	public int countInstockSaenSokh();
	public int countUsingSaenSokh();
	public int countAllSaenSokh();
	
	public boolean saveInstock(Desktop desktop);
	public Optional<Desktop> findById(int desid);
	public boolean updateInstock(Desktop desktop);
	public boolean deleteInstock(int desid);
	/*..................End Instock Block..................*/
	/* ====================================================*/
	
	/*..................Using Block.......................*/
	public List<Desktop> getListUsingHQ();
	public List<Desktop> getListUsingSaenSokh();
	public List<Desktop> getListManagement();
	public List<Desktop> getListHR();
	public List<Desktop> getListITSupport();
	public List<Desktop> getListCard();
	public List<Desktop> getListFinance();
	public List<Desktop> getListBizAdmin();
	public List<Desktop> getListBizOne();
	public List<Desktop> getListBizTwo();
	public List<Desktop> getListBizThree();
	public List<Desktop> getListBizFour();
	public List<Desktop> getListMarketing();
	public List<Desktop> getListInternalAudit();
	public List<Desktop> getListRecovery();
	public List<Desktop> getListLegal();
	public List<Desktop> getListAssessment();
	public List<Desktop> getListRisk();
	public List<Desktop> getListAllCO();
	public List<Desktop> getListusingSaenSokh();
	public List<Employee> getListEmployee();
	/* Get single Employee for Combo box in add Desktop Using */
	public Optional<Employee> getSingleEmployee(int empid);
	/*           Get list of Desktop not yet using            */
	public List<Desktop> getListDesktop();
	/*           Get single Desktop for add new using        */
	public Optional<Desktop> getSingleDesktop(int desid);
	/*..................End Using Block....................*/
	/*.................Save Desktop Using....................*/
	public boolean saveUsing(Desktop desktop);
	/*................Update Desktop Using....................*/
	public boolean updateUsing(Desktop desktop);
	/*................Reurn to Stock........................*/
	public boolean returnTostock(int desid);
	/*=====================================================*/
}
