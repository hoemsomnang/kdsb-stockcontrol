package com.adminlte.repositories;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.adminlte.models.Department;

@Repository
public interface DepartmentRepository {
 
	/*
	 * Get List Of Department
	 */
	@Select("SELECT * FROM tbdepartment")
	public List<Department> findAll();
	/*
	 * Save data Department to Database
	 */
	@Insert("INSERT INTO tbdepartment(deptname) VALUES(#{dept.deptname})")
	public boolean save(@Param("dept") Department dept);
	/*
	 * Get Single Department 
	 */
	@Select("SELECT *FROM tbdepartment WHERE deptid=#{deptid}")
	public Optional<Department> findById(@Param("deptid") int deptid);
	/*
	 * Update Department 
	 */
	@Update("UPDATE tbdepartment SET deptname=#{dept.deptname} WHERE deptid=#{dept.deptid}")
	public boolean update(@Param("dept") Department dept);
	/*
	 * Delete Department 
	 */
	@Delete("DELETE tbdepartment WHERE deptid=#{deptid}")
	public boolean delete(@Param("deptid") int deptid);
}
