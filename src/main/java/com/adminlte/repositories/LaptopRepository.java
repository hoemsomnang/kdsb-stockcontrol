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
import com.adminlte.models.Laptop;

@Repository
public interface LaptopRepository {

	/*===================================================*/
	/*---Get All Laptop--*/
	@Select("SELECT A.*,B.empname,B.position,C.deptname,D.brname FROM tblaptop A INNER JOIN tbemployee B ON A.empid=B.empid INNER JOIN tbdepartment C ON B.deptid=C.deptid INNER JOIN tbbranch D ON A.brid=D.brid ORDER BY C.deptid")
	public List<Laptop> getAll();
	/*--- Get list of laptops instock at Head Quarter ---*/
	@Select("SELECT A.*,B.brname FROM tblaptop A INNER JOIN tbbranch B ON A.brid=B.brid WHERE issue=0 AND A.brid=1")
	public List<Laptop> getListInstockHQ();
	/*--- Get list of laptop instock at Saen Sokh---*/
	@Select("SELECT *FROM tblaptop WHERE issue=0 AND brid=2")
	public List<Laptop> getListInstockSaenSokh();
	/*---Count laptop instock at Head Quarter------*/
	@Select("SELECT COUNT(*) FROM tblaptop WHERE issue=0 AND brid=1")
	public int countInstockHQ();
	/*---- Count laptop Using at Head Quarter------*/
	@Select("SELECT COUNT(*) FROM tblaptop WHERE issue=1 AND brid=1")
	public int countUsingHQ();
	/*------Count laptop total at Head Quarter-----*/
	@Select("SELECT COUNT(*) FROM tblaptop WHERE brid=1")
	public int countAllHQ();
	/*---Count laptop instock at Saen Sokh Branch---*/
	@Select("SELECT COUNT(*) FROM tblaptop WHERE issue=0 AND brid=2")
	public int countInstockSaenSokh();
	/*---Count laptop Using at Saen Sokh Branch-----*/
	@Select("SELECT COUNT(*) FROM tblaptop WHERE issue=1 AND brid=2")
	public int countUsingSaenSokh();
	/*----Count laptop total at Saen Sokh Branch----*/
	@Select("SELECT COUNT(*) FROM tblaptop WHERE brid=2")
	public int countAllSaenSokh();
	/*-------------Get List Of Branch---------------*/
	@Select("SELECT *FROM tbbranch")
	public List<Branch> getListOfBranch();
	/*========================================================*/
	
	/*.............Instock Laptop Block.......................*/
	/*========================================================*/
	/*------------Insert Laptop Instock-----------------------*/
	@Insert("INSERT INTO tblaptop(empid,empname,model,cpu,ram,hhd,display,os,sn,asset,datein,brid,issue) VALUES(1,'IT Instock',#{laptop.model},#{laptop.cpu},#{laptop.ram},#{laptop.hhd},#{laptop.display},#{laptop.os},#{laptop.sn},#{laptop.asset},#{laptop.datein},#{laptop.brid},0)")
	public boolean saveInstock(@Param("laptop")Laptop laptop);
	/*-------------Get Single Laptop--------------------------*/
	@Select("SELECT A.*,B.brname FROM tblaptop A INNER JOIN tbbranch B ON A.brid=B.brid WHERE lapid=#{lapid} ")
	public Optional<Laptop> findById(int lapid);
	/*----------------Update Laptop Instock--------------------*/
	@Update("UPDATE tblaptop SET model=#{laptop.model},cpu=#{laptop.cpu},ram=#{laptop.ram},hhd=#{laptop.hhd},display=#{laptop.display},os=#{laptop.os},sn=#{laptop.sn},asset=#{laptop.asset},datein=#{laptop.datein},brid=#{laptop.brid} WHERE lapid=#{laptop.lapid}")
	public boolean updateInstock(@Param("laptop")Laptop laptop);
	/*-------------------Delete Laptop Instock-----------------*/
	@Delete("DELETE FROM tblaptop WHERE lapid=#{lapid}")
	public boolean deleteInstock(@Param("lapid") int lapid);
	/*----------------End Instock Laptop Block-----------------*/
	
	/*========================================================*/
	/*---------------Laptop Using Block-----------------------*/
	/* Get List Of Laptop Using at Head Quarter */
	@Select("SELECT A.*,B.brname FROM tblaptop A INNER JOIN tbbranch B ON A.brid=B.brid WHERE issue=1 AND A.brid=1")
	public List<Laptop> getListUsingHQ();
	/* Get List Of Laptop Using at SaenSokh */
	@Select("SELECT A.*,B.brname FROM tblaptop A INNER JOIN tbbranch B ON A.brid=B.brid WHERE issue=1 AND A.brid=2")
	public List<Laptop> getListusingSaenSokh();
	/* Get list of employee who's not yet using laptop */
	@Select("SELECT *FROM tbemployee WHERE  NOT EXISTS(SELECT empid FROM tblaptop WHERE tbemployee.empid=tblaptop.empid)")
	public List<Employee> getListEmployee();
	/* Get Single Employee for add in laptop using */
	@Select("SELECT A.empid,A.empname,A.position,B.deptid,B.deptname,A.brid,C.brname FROM tbemployee A INNER JOIN tbdepartment B ON A.deptid=B.deptid INNER JOIN tbbranch C ON A.brid=C.brid WHERE empid=#{empid}")
	public Optional<Employee> getSingleEmployee(@Param("empid") int empid);
	/*  Get list fo laptop not yet using           */
	@Select("SELECT *FROM tblaptop WHERE issue=0")
	public List<Laptop> getListlaptop();
    /* Get Single laptop */
	@Select("SELECT *FROM tblaptop WHERE lapid=#{lapid}")
	public Optional<Laptop> getSingleLaptop(int lapid);
	/*......................................................................*/
	/*................Get List Using for each departments...................*/
	/* Management */
	@Select("SELECT A.*,B.empname,B.position,C.deptname FROM tblaptop A INNER JOIN tbemployee B ON A.empid=B.empid INNER JOIN tbdepartment C ON C.deptid=B.deptid WHERE A.brid=1 AND issue=1 AND B.deptid=1")
	List<Laptop> getListManagement();
	/* HR and Admin */
	@Select("SELECT A.*,B.empname,B.position,C.deptname FROM tblaptop A INNER JOIN tbemployee B ON A.empid=B.empid INNER JOIN tbdepartment C ON C.deptid=B.deptid WHERE A.brid=1 AND issue=1 AND B.deptid=2")
	List<Laptop> getListHR();
	/* IT Support */
	@Select("SELECT A.*,B.empname,B.position,C.deptname FROM tblaptop A INNER JOIN tbemployee B ON A.empid=B.empid INNER JOIN tbdepartment C ON C.deptid=B.deptid WHERE A.brid=1 AND issue=1 AND B.deptid=3")
	List<Laptop> getListIT();
	/* Card */
	@Select("SELECT A.*,B.empname,B.position,C.deptname FROM tblaptop A INNER JOIN tbemployee B ON A.empid=B.empid INNER JOIN tbdepartment C ON C.deptid=B.deptid WHERE A.brid=1 AND issue=1 AND B.deptid=4")
	List<Laptop> getListCard();
	/* Finance and Accounting */
	@Select("SELECT A.*,B.empname,B.position,C.deptname FROM tblaptop A INNER JOIN tbemployee B ON A.empid=B.empid INNER JOIN tbdepartment C ON C.deptid=B.deptid WHERE A.brid=1 AND issue=1 AND B.deptid=5")
	List<Laptop> getListFinance();
	/* Business Admin */
	@Select("SELECT A.*,B.empname,B.position,C.deptname FROM tblaptop A INNER JOIN tbemployee B ON A.empid=B.empid INNER JOIN tbdepartment C ON C.deptid=B.deptid WHERE A.brid=1 AND issue=1 AND B.deptid=6")
	List<Laptop> getListBizAdmin();	
	/* Business Sales One */
	@Select("SELECT A.*,B.empname,B.position,C.deptname FROM tblaptop A INNER JOIN tbemployee B ON A.empid=B.empid INNER JOIN tbdepartment C ON C.deptid=B.deptid WHERE A.brid=1 AND issue=1 AND B.deptid=7")
	List<Laptop> getListBizOne();	
	/* Business Sales Two */
	@Select("SELECT A.*,B.empname,B.position,C.deptname FROM tblaptop A INNER JOIN tbemployee B ON A.empid=B.empid INNER JOIN tbdepartment C ON C.deptid=B.deptid WHERE A.brid=1 AND issue=1 AND B.deptid=8")
	List<Laptop> getListBizSalesTwo();	
	/* Business Sales Three */
	@Select("SELECT A.*,B.empname,B.position,C.deptname FROM tblaptop A INNER JOIN tbemployee B ON A.empid=B.empid INNER JOIN tbdepartment C ON C.deptid=B.deptid WHERE A.brid=1 AND issue=1 AND B.deptid=9")
	List<Laptop> getListBizSalesThree();	
	/* Business Sales Four */
	@Select("SELECT A.*,B.empname,B.position,C.deptname FROM tblaptop A INNER JOIN tbemployee B ON A.empid=B.empid INNER JOIN tbdepartment C ON C.deptid=B.deptid WHERE A.brid=1 AND issue=1 AND B.deptid=10")
	List<Laptop> getListBizSalesFour();
	/* Marketing and CSR */
	@Select("SELECT A.*,B.empname,B.position,C.deptname FROM tblaptop A INNER JOIN tbemployee B ON A.empid=B.empid INNER JOIN tbdepartment C ON C.deptid=B.deptid WHERE A.brid=1 AND issue=1 AND B.deptid=11")
	List<Laptop> getListMarketing();	
	/* Internal Audit */
	@Select("SELECT A.*,B.empname,B.position,C.deptname FROM tblaptop A INNER JOIN tbemployee B ON A.empid=B.empid INNER JOIN tbdepartment C ON C.deptid=B.deptid WHERE A.brid=1 AND issue=1 AND B.deptid=12")
	List<Laptop> getListInternalAudit();
	/* Legal and Compliance */
	@Select("SELECT A.*,B.empname,B.position,C.deptname FROM tblaptop A INNER JOIN tbemployee B ON A.empid=B.empid INNER JOIN tbdepartment C ON C.deptid=B.deptid WHERE A.brid=1 AND issue=1 AND B.deptid=13")
	List<Laptop> getListLegal();	
	/* Recovery and Collection */
	@Select("SELECT A.*,B.empname,B.position,C.deptname FROM tblaptop A INNER JOIN tbemployee B ON A.empid=B.empid INNER JOIN tbdepartment C ON C.deptid=B.deptid WHERE A.brid=1 AND issue=1 AND B.deptid=14")
	List<Laptop> getListRecovery	();	
	/* Assessment and Approval */
	@Select("SELECT A.*,B.empname,B.position,C.deptname FROM tblaptop A INNER JOIN tbemployee B ON A.empid=B.empid INNER JOIN tbdepartment C ON C.deptid=B.deptid WHERE A.brid=1 AND issue=1 AND B.deptid=15")
	List<Laptop> getListAssessment();
	/* Risk Management */
	@Select("SELECT A.*,B.empname,B.position,C.deptname FROM tblaptop A INNER JOIN tbemployee B ON A.empid=B.empid INNER JOIN tbdepartment C ON C.deptid=B.deptid WHERE A.brid=1 AND issue=1 AND B.deptid=16")
	List<Laptop> getListRisk();	
	/* For Computer CO */
	@Select("SELECT A.*,B.empname,B.position,C.deptname FROM tblaptop A INNER JOIN tbemployee B ON A.empid=B.empid INNER JOIN tbdepartment C ON C.deptid=B.deptid WHERE A.brid=1 AND issue=1 AND B.deptid=19")
	List<Laptop> getListAllCO();
	/* Saen Sokh Branch */
	@Select("SELECT A.*,B.empname,B.position,C.deptname FROM tblaptop A INNER JOIN tbemployee B ON A.empid=B.empid INNER JOIN tbdepartment C ON C.deptid=B.deptid WHERE A.brid=1 AND issue=1 AND B.deptid=20")
	List<Laptop> getListSaenSok();	
	/*................End Get List using for each department................*/
	/* Inser Laptop using */ 
	@Update("UPDATE tblaptop SET empid=#{laptop.empid},empname=#{laptop.empname},issue=1,dateusing=#{laptop.dateusing} WHERE lapid=#{laptop.lapid}")
	public boolean saveUsing(@Param("laptop") Laptop laptop);
	/* Update Laptop Using */
	@Update("UPDATE tblaptop SET model=#{laptop.model},cpu=#{laptop.cpu},ram=#{laptop.ram},hhd=#{laptop.hhd},display=#{laptop.display},sn=#{laptop.sn},asset=#{laptop.asset},dateusing=#{laptop.dateusing},remark=#{laptop.remark} Where lapid=#{laptop.lapid}")
	public boolean updateUsing(@Param("laptop") Laptop laptop);
	/* Return Laptop Using to stock(Instock) */
	@Update("UPDATE tblaptop SET issue=0 WHERE lapid=#{lapid}")
	public boolean returnTostock(@Param("lapid") int lapid);
	
	/*----------------End Using block------------------------*/
	/*========================================================*/
}
