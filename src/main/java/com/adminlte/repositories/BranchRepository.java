package com.adminlte.repositories;

import java.util.List;
import java.util.Optional;


import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import com.adminlte.models.Branch;

@Repository
public interface BranchRepository {

	//Get List Of Branch
	@Select("SELECT *FROM tbbranch")
	public List<Branch> findAll();
	// Save data Branch to database
	@Insert("INSERT INTO tbbranch(brname) VALUES(#{br.brname})")
	public boolean save(@Param("br") Branch br);
	//Get Single Branch
	@Select("SELECT *FROM tbbranch WHERE brid=#{brid}")
	public Optional<Branch> findById(@Param("brid") int brid);
	//Update Branch 
	@Update("UPDATE tbbranch SET brname=#{br.brname} WHERE brid=#{br.brid}")
	public boolean update(@Param("br") Branch br);
	//Delete Branch
	@Delete("DELETE FROM tbbranch WHERE brid=#{brid}")
	public boolean delete(@Param("brid") int brid);
}
