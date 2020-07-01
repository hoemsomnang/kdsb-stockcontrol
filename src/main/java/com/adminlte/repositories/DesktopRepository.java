package com.adminlte.repositories;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.adminlte.models.Branch;
import com.adminlte.models.Employee;
import com.adminlte.models.Desktop;

@Repository
public interface DesktopRepository {

	/*===================================================*/
	/*---Get All Desktop--*/
	@Select("SELECT A.*,B.empname,B.position,C.deptname,D.brname FROM tbDesktop A INNER JOIN tbemployee B ON A.empid=B.empid INNER JOIN tbdepartment C ON B.deptid=C.deptid INNER JOIN tbbranch D ON A.brid=D.brid ORDER BY C.deptid")
	public List<Desktop> getAll();
	/*--- Get list of Desktops instock at Head Quarter ---*/
	@Select("SELECT A.*,B.brname FROM tbDesktop A INNER JOIN tbbranch B ON A.brid=B.brid WHERE issue=0 AND A.brid=1")
	public List<Desktop> getListInstockHQ();
	/*--- Get list of Desktop instock at Saen Sokh---*/
	@Select("SELECT *FROM tbDesktop WHERE issue=0 AND brid=2")
	public List<Desktop> getListInstockSaenSokh();
	/*---Count Desktop instock at Head Quarter------*/
	@Select("SELECT COUNT(*) FROM tbDesktop WHERE issue=0 AND brid=1")
	public int countInstockHQ();
	/*---- Count Desktop Using at Head Quarter------*/
	@Select("SELECT COUNT(*) FROM tbDesktop WHERE issue=1 AND brid=1")
	public int countUsingHQ();
	/*------Count Desktop total at Head Quarter-----*/
	@Select("SELECT COUNT(*) FROM tbDesktop WHERE brid=1")
	public int countAllHQ();
	/*---Count Desktop instock at Saen Sokh Branch---*/
	@Select("SELECT COUNT(*) FROM tbDesktop WHERE issue=0 AND brid=2")
	public int countInstockSaenSokh();
	/*---Count Desktop Using at Saen Sokh Branch-----*/
	@Select("SELECT COUNT(*) FROM tbDesktop WHERE issue=1 AND brid=2")
	public int countUsingSaenSokh();
	/*----Count Desktop total at Saen Sokh Branch----*/
	@Select("SELECT COUNT(*) FROM tbDesktop WHERE brid=2")
	public int countAllSaenSokh();
	/*-------------Get List Of Branch---------------*/
	@Select("SELECT *FROM tbbranch")
	public List<Branch> getListOfBranch();
	/*========================================================*/
	
	/*.............Instock Desktop Block.......................*/
	/*========================================================*/
	/*------------Insert Desktop Instock-----------------------*/
	@Insert("INSERT INTO tbDesktop(empid,empname,model,cpu,ram,hhd,display,os,sn,asset,datein,brid,issue) VALUES(1,'IT Instock',#{desktop.model},#{desktop.cpu},#{desktop.ram},#{desktop.hhd},#{desktop.display},#{desktop.os},#{desktop.sn},#{desktop.asset},#{desktop.datein},#{desktop.brid},0)")
	public boolean saveInstock(@Param("desktop")Desktop desktop);
	/*-------------Get Single Desktop--------------------------*/
	@Select("SELECT A.*,B.brname FROM tbDesktop A INNER JOIN tbbranch B ON A.brid=B.brid WHERE desid=#{desid} ")
	public Optional<Desktop> findById(int desid);
	/*----------------Update Desktop Instock--------------------*/
	@Update("UPDATE tbDesktop SET model=#{desktop.model},cpu=#{desktop.cpu},ram=#{desktop.ram},hhd=#{desktop.hhd},display=#{desktop.display},os=#{desktop.os},sn=#{desktop.sn},asset=#{desktop.asset},datein=#{desktop.datein},brid=#{desktop.brid} WHERE desid=#{desktop.desid}")
	public boolean updateInstock(@Param("desktop")Desktop desktop);
	/*-------------------Delete Desktop Instock-----------------*/
	@Delete("DELETE FROM tbDesktop WHERE desid=#{desid}")
	public boolean deleteInstock(@Param("desid") int desid);
	/*----------------End Instock Desktop Block-----------------*/
	
	/*========================================================*/
	/*---------------Desktop Using Block-----------------------*/
	/* Get List Of Desktop Using at Head Quarter */
	@Select("SELECT A.*,B.brname FROM tbDesktop A INNER JOIN tbbranch B ON A.brid=B.brid WHERE issue=1 AND A.brid=1")
	public List<Desktop> getListUsingHQ();
	/* Get List Of Desktop Using at SaenSokh */
	@Select("SELECT A.*,B.brname FROM tbDesktop A INNER JOIN tbbranch B ON A.brid=B.brid WHERE issue=1 AND A.brid=2")
	public List<Desktop> getListusingSaenSokh();
	/* Get list of employee who's not yet using Desktop */
	@Select("SELECT *FROM tbemployee WHERE  NOT EXISTS(SELECT empid FROM tbDesktop WHERE tbemployee.empid=tbDesktop.empid)")
	public List<Employee> getListEmployee();
	/* Get Single Employee for add in Desktop using */
	@Select("SELECT A.empid,A.empname,A.position,B.deptid,B.deptname,A.brid,C.brname FROM tbemployee A INNER JOIN tbdepartment B ON A.deptid=B.deptid INNER JOIN tbbranch C ON A.brid=C.brid WHERE empid=#{empid}")
	public Optional<Employee> getSingleEmployee(@Param("empid") int empid);
	/*  Get list fo Desktop not yet using           */
	@Select("SELECT *FROM tbDesktop WHERE issue=0")
	public List<Desktop> getListDesktop();
    /* Get Single Desktop */
	@Select("SELECT *FROM tbDesktop WHERE desid=#{desid}")
	public Optional<Desktop> getSingleDesktop(int desid);
	/*......................................................................*/
	/*................Get List Using for each departments...................*/
	/* Management */
	@Select("SELECT A.*,B.empname,B.position,C.deptname FROM tbDesktop A INNER JOIN tbemployee B ON A.empid=B.empid INNER JOIN tbdepartment C ON C.deptid=B.deptid WHERE A.brid=1 AND issue=1 AND B.deptid=1")
	List<Desktop> getListManagement();
	/* HR and Admin */
	@Select("SELECT A.*,B.empname,B.position,C.deptname FROM tbDesktop A INNER JOIN tbemployee B ON A.empid=B.empid INNER JOIN tbdepartment C ON C.deptid=B.deptid WHERE A.brid=1 AND issue=1 AND B.deptid=2")
	List<Desktop> getListHR();
	/* IT Support */
	@Select("SELECT A.*,B.empname,B.position,C.deptname FROM tbDesktop A INNER JOIN tbemployee B ON A.empid=B.empid INNER JOIN tbdepartment C ON C.deptid=B.deptid WHERE A.brid=1 AND issue=1 AND B.deptid=3")
	List<Desktop> getListIT();
	/* Card */
	@Select("SELECT A.*,B.empname,B.position,C.deptname FROM tbDesktop A INNER JOIN tbemployee B ON A.empid=B.empid INNER JOIN tbdepartment C ON C.deptid=B.deptid WHERE A.brid=1 AND issue=1 AND B.deptid=4")
	List<Desktop> getListCard();
	/* Finance and Accounting */
	@Select("SELECT A.*,B.empname,B.position,C.deptname FROM tbDesktop A INNER JOIN tbemployee B ON A.empid=B.empid INNER JOIN tbdepartment C ON C.deptid=B.deptid WHERE A.brid=1 AND issue=1 AND B.deptid=5")
	List<Desktop> getListFinance();
	/* Business Admin */
	@Select("SELECT A.*,B.empname,B.position,C.deptname FROM tbDesktop A INNER JOIN tbemployee B ON A.empid=B.empid INNER JOIN tbdepartment C ON C.deptid=B.deptid WHERE A.brid=1 AND issue=1 AND B.deptid=6")
	List<Desktop> getListBizAdmin();	
	/* Business Sales One */
	@Select("SELECT A.*,B.empname,B.position,C.deptname FROM tbDesktop A INNER JOIN tbemployee B ON A.empid=B.empid INNER JOIN tbdepartment C ON C.deptid=B.deptid WHERE A.brid=1 AND issue=1 AND B.deptid=7")
	List<Desktop> getListBizOne();	
	/* Business Sales Two */
	@Select("SELECT A.*,B.empname,B.position,C.deptname FROM tbDesktop A INNER JOIN tbemployee B ON A.empid=B.empid INNER JOIN tbdepartment C ON C.deptid=B.deptid WHERE A.brid=1 AND issue=1 AND B.deptid=8")
	List<Desktop> getListBizSalesTwo();	
	/* Business Sales Three */
	@Select("SELECT A.*,B.empname,B.position,C.deptname FROM tbDesktop A INNER JOIN tbemployee B ON A.empid=B.empid INNER JOIN tbdepartment C ON C.deptid=B.deptid WHERE A.brid=1 AND issue=1 AND B.deptid=9")
	List<Desktop> getListBizSalesThree();	
	/* Business Sales Four */
	@Select("SELECT A.*,B.empname,B.position,C.deptname FROM tbDesktop A INNER JOIN tbemployee B ON A.empid=B.empid INNER JOIN tbdepartment C ON C.deptid=B.deptid WHERE A.brid=1 AND issue=1 AND B.deptid=10")
	List<Desktop> getListBizSalesFour();
	/* Marketing and CSR */
	@Select("SELECT A.*,B.empname,B.position,C.deptname FROM tbDesktop A INNER JOIN tbemployee B ON A.empid=B.empid INNER JOIN tbdepartment C ON C.deptid=B.deptid WHERE A.brid=1 AND issue=1 AND B.deptid=11")
	List<Desktop> getListMarketing();	
	/* Internal Audit */
	@Select("SELECT A.*,B.empname,B.position,C.deptname FROM tbDesktop A INNER JOIN tbemployee B ON A.empid=B.empid INNER JOIN tbdepartment C ON C.deptid=B.deptid WHERE A.brid=1 AND issue=1 AND B.deptid=12")
	List<Desktop> getListInternalAudit();
	/* Legal and Compliance */
	@Select("SELECT A.*,B.empname,B.position,C.deptname FROM tbDesktop A INNER JOIN tbemployee B ON A.empid=B.empid INNER JOIN tbdepartment C ON C.deptid=B.deptid WHERE A.brid=1 AND issue=1 AND B.deptid=13")
	List<Desktop> getListLegal();	
	/* Recovery and Collection */
	@Select("SELECT A.*,B.empname,B.position,C.deptname FROM tbDesktop A INNER JOIN tbemployee B ON A.empid=B.empid INNER JOIN tbdepartment C ON C.deptid=B.deptid WHERE A.brid=1 AND issue=1 AND B.deptid=14")
	List<Desktop> getListRecovery	();	
	/* Assessment and Approval */
	@Select("SELECT A.*,B.empname,B.position,C.deptname FROM tbDesktop A INNER JOIN tbemployee B ON A.empid=B.empid INNER JOIN tbdepartment C ON C.deptid=B.deptid WHERE A.brid=1 AND issue=1 AND B.deptid=15")
	List<Desktop> getListAssessment();
	/* Risk Management */
	@Select("SELECT A.*,B.empname,B.position,C.deptname FROM tbDesktop A INNER JOIN tbemployee B ON A.empid=B.empid INNER JOIN tbdepartment C ON C.deptid=B.deptid WHERE A.brid=1 AND issue=1 AND B.deptid=16")
	List<Desktop> getListRisk();	
	/* For Computer CO */
	@Select("SELECT A.*,B.empname,B.position,C.deptname FROM tbDesktop A INNER JOIN tbemployee B ON A.empid=B.empid INNER JOIN tbdepartment C ON C.deptid=B.deptid WHERE A.brid=1 AND issue=1 AND B.deptid=19")
	List<Desktop> getListAllCO();
	/* Saen Sokh Branch */
	@Select("SELECT A.*,B.empname,B.position,C.deptname FROM tbDesktop A INNER JOIN tbemployee B ON A.empid=B.empid INNER JOIN tbdepartment C ON C.deptid=B.deptid WHERE A.brid=1 AND issue=1 AND B.deptid=20")
	List<Desktop> getListSaenSok();	
	/*................End Get List using for each department................*/
	/* Inser Desktop using */ 
	@Update("UPDATE tbDesktop SET empid=#{desktop.empid},empname=#{desktop.empname},issue=1,dateusing=#{desktop.dateusing} WHERE desid=#{desktop.desid}")
	public boolean saveUsing(@Param("desktop") Desktop desktop);
	/* Update Desktop Using */
	@Update("UPDATE tbDesktop SET model=#{desktop.model},cpu=#{desktop.cpu},ram=#{desktop.ram},hhd=#{desktop.hhd},display=#{desktop.display},sn=#{desktop.sn},asset=#{desktop.asset},dateusing=#{desktop.dateusing},remark=#{desktop.remark} Where desid=#{desktop.desid}")
	public boolean updateUsing(@Param("desktop") Desktop desktop);
	/* Return Desktop Using to stock(Instock) */
	@Update("UPDATE tbDesktop SET issue=0 WHERE desid=#{desid}")
	public boolean returnTostock(@Param("desid") int desid);
	
	/*----------------End Using block------------------------*/
	/*========================================================*/
}
