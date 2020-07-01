package com.adminlte.repositories;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.adminlte.models.Category;
import com.adminlte.models.Devices;


@Repository
public interface DeviceRepository {
    /*---- Get all devices ----*/
	@Select("SELECT A.*,B.brname FROM tbdevice A INNER JOIN tbbranch B ON A.brid=B.brid ORDER BY A.brid")
	public List<Devices> getAll();
	/*---- Insert device ----*/
	@Insert("INSERT INTO tbdevice(empid,cateid,name,model,version,asset,"
			+ "remark,qty,datein,dateusing,status,location2,brid,issue) "
			+ "VALUES(1,#{devices.cateid},#{devices.name},#{devices.model},"
			+ "#{devices.version},#{devices.asset},#{devices.remark},#{devices.qty},"
			+ "#{devices.datein},#{devices.dateusing},#{devices.status},#{devices.location2},"
			+ "#{devices.brid},0) ")
	public boolean save(@Param("devices") Devices devices);
	/*---- Get list category ----*/
	@Select("SELECT *FROM tbcategory")
	public List<Category> findAllcategroy();
	/*---- Get Single Device ----*/
	@Select("SELECT A.*,B.brname FROM tbdevice A INNER JOIN tbbranch B ON A.brid=B.brid WHERE devid=#{devid}")
    public Devices findById(@Param("devid") int devid);
	/*---- Update Device ----*/
	@Update("UPDATE tbdevice SET cateid=#{device.cateid},name=#{device.name},model=#{device.model},"
			+ "version=#{device.version},asset=#{device.asset},remark=#{device.remark},qty=#{device.qty},"
			+ "datein=#{device.datein},dateusing=#{device.dateusing},status=#{device.status},"
			+ "location2=#{device.location2},brid=#{device.brid} WHERE devid=#{device.devid}")
	public boolean update(@Param("device") Devices device);
	/*---- Delete Device ----*/
	@Delete("DELETE FROM tbdevice WHERE devid=#{devid}")
	public boolean delete(@Param("devid") int devid);
	/*-- Count All ---*/
	@Select("SELECT COUNT(*) FROM tbdevice")
	public int countAll();
	
}
