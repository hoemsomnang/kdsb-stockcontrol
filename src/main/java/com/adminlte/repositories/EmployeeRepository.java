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
import com.adminlte.models.Department;
import com.adminlte.models.Employee;
@Repository
public interface EmployeeRepository {

	
	/*
	 * Get List Of Employee At Head Quarter
	 */
	@Select("SELECT A.empid,A.empname,B.deptname,A.sex,A.position,A.team,A.extension,A.email,A.phone,C.brname FROM tbemployee A "
			+ "INNER JOIN tbdepartment B ON A.deptid=B.deptid INNER JOIN tbbranch C ON C.brid=A.brid WHERE stopwork=0 AND C.brid=1 ORDER BY B.deptid")
	public List<Employee> findAll();
	/*
	 * Get List Of Employee At Saen Sokh
	 */
	@Select("SELECT A.empid,A.empname,B.deptname,A.sex,A.position,A.team,A.extension,A.email,A.phone,C.brname FROM tbemployee A "
			+ "INNER JOIN tbdepartment B ON A.deptid=B.deptid INNER JOIN tbbranch C ON C.brid=A.brid WHERE stopwork=0 AND C.brid=2 ORDER BY B.deptid")
	public List<Employee> findAllSaenSokh();
	/*
	 * Get List Of Employee who in Management Department
	 */
	@Select("SELECT  A.empid,A.empname,B.deptname,A.sex,A.position,A.team,A.extension,A.email,A.phone FROM tbemployee  A INNER JOIN tbdepartment B ON A.deptid=B.deptid WHERE stopwork=0  AND A.deptid=1")
	public List<Employee> findManagement();
	/*
	 * Get List Of Employee who in HR Department
	 */
	@Select("SELECT  A.empid,A.empname,B.deptname,A.sex,A.position,A.team,A.extension,A.email,A.phone FROM tbemployee  A INNER JOIN tbdepartment B ON A.deptid=B.deptid WHERE stopwork=0  AND A.deptid=2")
	public List<Employee> findHR();
	/*
	 * Get List Of Employee who in IT Department
	 */
	@Select("SELECT  A.empid,A.empname,B.deptname,A.sex,A.position,A.team,A.extension,A.email,A.phone FROM tbemployee  A INNER JOIN tbdepartment B ON A.deptid=B.deptid WHERE stopwork=0  AND A.deptid=3")
	public List<Employee> findIT();
	/*
	 * Get List Of Employee who in Card Department
	 */
	@Select("SELECT  A.empid,A.empname,B.deptname,A.sex,A.position,A.team,A.extension,A.email,A.phone FROM tbemployee  A INNER JOIN tbdepartment B ON A.deptid=B.deptid WHERE stopwork=0  AND A.deptid=4")
	public List<Employee> findCard();
	/*
	 * Get List Of Employee who in Finance and Accounting Department
	 */
	@Select("SELECT  A.empid,A.empname,B.deptname,A.sex,A.position,A.team,A.extension,A.email,A.phone FROM tbemployee  A INNER JOIN tbdepartment B ON A.deptid=B.deptid WHERE stopwork=0  AND A.deptid=5")
	public List<Employee> findFinance();
	/*
	 * Get List Of Employee who in Business Admin Department
	 */
	@Select("SELECT  A.empid,A.empname,B.deptname,A.sex,A.position,A.team,A.extension,A.email,A.phone FROM tbemployee  A INNER JOIN tbdepartment B ON A.deptid=B.deptid WHERE stopwork=0  AND A.deptid=6")
	public List<Employee> findBizAdmin();
	/*
	 * Get List Of Employee who in Business Sales 1 Department
	 */
	@Select("SELECT  A.empid,A.empname,B.deptname,A.sex,A.position,A.team,A.extension,A.email,A.phone FROM tbemployee  A INNER JOIN tbdepartment B ON A.deptid=B.deptid WHERE stopwork=0  AND A.deptid=7")
	public List<Employee> findBizOne();
	/*
	 * Get List Of Employee who in Business Sales 2 Department
	 */
	@Select("SELECT  A.empid,A.empname,B.deptname,A.sex,A.position,A.team,A.extension,A.email,A.phone FROM tbemployee  A INNER JOIN tbdepartment B ON A.deptid=B.deptid WHERE stopwork=0  AND A.deptid=8")
	public List<Employee> findBizTwo();
	/*
	 * Get List Of Employee who in Business Sales 3 Department
	 */
	@Select("SELECT  A.empid,A.empname,B.deptname,A.sex,A.position,A.team,A.extension,A.email,A.phone FROM tbemployee  A INNER JOIN tbdepartment B ON A.deptid=B.deptid WHERE stopwork=0  AND A.deptid=9")
	public List<Employee> findBizThree();
	/*
	 * Get List Of Employee who in Business Sales 4 Department
	 */
	@Select("SELECT  A.empid,A.empname,B.deptname,A.sex,A.position,A.team,A.extension,A.email,A.phone FROM tbemployee  A INNER JOIN tbdepartment B ON A.deptid=B.deptid WHERE stopwork=0  AND A.deptid=10")
	public List<Employee> findBizFour();
	/*
	 * Get List Of Employee who in Marketing And CSR Department
	 */
	@Select("SELECT  A.empid,A.empname,B.deptname,A.sex,A.position,A.team,A.extension,A.email,A.phone FROM tbemployee  A INNER JOIN tbdepartment B ON A.deptid=B.deptid WHERE stopwork=0  AND A.deptid=11")
	public List<Employee> findMarketing();
	/*
	 * Get List Of Employee who in Business Sales 2 Department
	 */
	@Select("SELECT  A.empid,A.empname,B.deptname,A.sex,A.position,A.team,A.extension,A.email,A.phone FROM tbemployee  A INNER JOIN tbdepartment B ON A.deptid=B.deptid WHERE stopwork=0  AND A.deptid=12")
	public List<Employee> findAudit();
	/*
	 * Get List Of Employee who in Legal And Compliance Department
	 */
	@Select("SELECT  A.empid,A.empname,B.deptname,A.sex,A.position,A.team,A.extension,A.email,A.phone FROM tbemployee  A INNER JOIN tbdepartment B ON A.deptid=B.deptid WHERE stopwork=0  AND A.deptid=13")
	public List<Employee> findLegal();
	/*
	 * Get List Of Employee who in Loan Recovery Department
	 */
	@Select("SELECT  A.empid,A.empname,B.deptname,A.sex,A.position,A.team,A.extension,A.email,A.phone FROM tbemployee  A INNER JOIN tbdepartment B ON A.deptid=B.deptid WHERE stopwork=0  AND A.deptid=14")
	public List<Employee> findRecovery();
	/*
	 * Get List Of Employee who in Assessment And Approval Department
	 */
	@Select("SELECT  A.empid,A.empname,B.deptname,A.sex,A.position,A.team,A.extension,A.email,A.phone FROM tbemployee  A INNER JOIN tbdepartment B ON A.deptid=B.deptid WHERE stopwork=0  AND A.deptid=15")
	public List<Employee> findAssessment();
	/*
	 * Get List Of Employee who in Risk Department
	 */
	@Select("SELECT  A.empid,A.empname,B.deptname,A.sex,A.position,A.team,A.extension,A.email,A.phone FROM tbemployee  A INNER JOIN tbdepartment B ON A.deptid=B.deptid WHERE stopwork=0  AND A.deptid=16")
	public List<Employee> findRisk();
	/*
	 * Get List Of Employee who in Saen Sokh Branch
	 */
	@Select("SELECT  A.empid,A.empname,B.deptname,A.sex,A.position,A.team,A.extension,A.email,A.phone FROM tbemployee  A INNER JOIN tbdepartment B ON A.deptid=B.deptid WHERE stopwork=0  AND A.deptid=20")
	public List<Employee> findSaenSokh();
	/*
	 * Get List Of Department
	 */
	@Select("SELECT *FROM tbdepartment")
	public List<Department> findDeptAll();
	/*
	 * Get List Of Branch
	 */
	@Select("SELECT *FROM tbbranch")
	public List<Branch> findBranchAll();
	/*
	 * Save employee
	 */
	@Insert("INSERT INTO tbemployee(empname,sex,dob,deptid,position,team,brid,phone,extension,email,stopwork) VALUES(#{emp.empname},#{emp.sex},#{emp.dob},#{emp.deptid},#{emp.position},#{emp.team},#{emp.brid},#{emp.phone},#{emp.extension},#{emp.email},0) ")
	public boolean save(@Param("emp") Employee emp);
	/*
	 * Get Single Employee
	 */
	@Select("SELECT *FROM tbemployee WHERE empid=#{empid}")
	public Optional<Employee> findById(@Param("empid") int empid);
	/*
	 * Update Employee
	 */
	@Update("UPDATE tbemployee SET empname=#{emp.empname},dob=#{emp.dob},deptid=#{emp.deptid},position=#{emp.position},team=#{emp.team},brid=#{emp.brid},phone=#{emp.phone},extension=#{emp.extension},email=#{emp.email} WHERE empid=#{emp.empid}")
	public boolean update(@Param("emp") Employee emp);
	/*
	 * Delete Employee
	 */
	@Delete("UPDATE   tbemployee SET stopwork=1 WHERE empid=#{empid}")
	public boolean delete(@Param("empid") int empid);
	
	
	/*
	 * Count Female at Head Quarter
	 */
	@Select("SELECT COUNT(*) FROM tbemployee A INNER JOIN tbbranch B ON A.brid=B.brid WHERE A.stopwork=0 AND sex='F'  AND B.brid=1")
	public int femaleHQ();
	/*
	 * Count Male at Head Quarter
	 */
	@Select("SELECT COUNT(*) FROM tbemployee A INNER JOIN tbbranch B ON A.brid=B.brid WHERE A.stopwork=0 AND sex='M'  AND B.brid=1")
	public int maleHQ();
	/*
	 * Count All  at Head Quarter
	 */
	@Select("SELECT COUNT(*) FROM tbemployee A INNER JOIN tbbranch B ON A.brid=B.brid WHERE A.stopwork=0   AND B.brid=1")
	public int allHQ();
	/*
	 * Count Female at Head Quarter
	 */
	@Select("SELECT COUNT(*) FROM tbemployee A INNER JOIN tbbranch B ON A.brid=B.brid WHERE A.stopwork=0 AND sex='F'  AND B.brid=2")
	public int femaleSaenSokh();
	/*
	 * Count Male at Head Quarter
	 */
	@Select("SELECT COUNT(*) FROM tbemployee A INNER JOIN tbbranch B ON A.brid=B.brid WHERE A.stopwork=0 AND sex='M'  AND B.brid=2")
	public int maleSaenSokh();
	/*
	 * Count All  at Head Quarter
	 */
	@Select("SELECT COUNT(*) FROM tbemployee A INNER JOIN tbbranch B ON A.brid=B.brid WHERE A.stopwork=0   AND B.brid=2")
	public int allSaenSokh();
}
