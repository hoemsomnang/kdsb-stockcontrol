package com.adminlte.repositories;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.adminlte.models.IP;

@Repository
public interface IPTwentysecondRepository {

	@Select("SELECT *FROM tbiptwentytwo WHERE deptid=17 AND id BETWEEN 1 and 10")
	List<IP> getSystem();
	@Select("SELECT *FROM tbiptwentytwo WHERE deptid=1")
	List<IP> getManagement();
	@Select("SELECT *FROM tbiptwentytwo WHERE deptid=5")
	List<IP> getFinance();
	@Select("SELECT *FROM tbiptwentytwo WHERE deptid=2")
	List<IP> getHR();
	@Select("SELECT *FROM tbiptwentytwo WHERE deptid=7")
	List<IP> getBizone();
	@Select("SELECT *FROM tbiptwentytwo WHERE deptid=8")
	List<IP> getBiztwo();
	@Select("SELECT *FROM tbiptwentytwo WHERE deptid=18")
	List<IP> getIPquest();
	@Select("SELECT *FROM tbiptwentytwo WHERE deptid=19")
	List<IP> getAllCO();
	@Select("SELECT *FROM tbiptwentytwo WHERE deptid=17 AND id BETWEEN 201 and 210")
	List<IP> getPrinter();
	@Select("SELECT *FROM tbiptwentytwo WHERE deptid=17 AND id BETWEEN 211 and 230")
	List<IP> getFingerprint();
	@Select("SELECT *FROM tbiptwentytwo WHERE deptid=17 AND id BETWEEN 231 and 250")
	List<IP> getPhone();
	@Select("SELECT *FROM tbiptwentytwo WHERE deptid=17 AND id BETWEEN 251 and 254")
	List<IP> getSwitch();
	@Select("SELECT *FROM tbiptwentytwo WHERE id=#{id}")
	IP findById(@Param("id") int id);
	@Update("UPDATE tbiptwentytwo SET macaddress=#{ip.macaddress},"
			+ "username=#{ip.username},sn=#{ip.sn},location=#{ip.location},pcname=#{ip.pcname},"
			+ "antivirus=#{ip.antivirus},ramark=#{ip.ramark},extension=#{ip.extension} WHERE id=#{ip.id}")
	boolean update(@Param("ip") IP ip);
	/*--------- Reserved IP ---------*/
	@Update("UPDATE tbiptwentytwo SET macaddress='Reserved',"
			+ "username='Reserved',sn='',location='',pcname='',"
			+ "antivirus='',ramark='',extension='' WHERE id=#{id}")
	boolean reservedIP(@Param("id") int id);
	@Select("SELECT A.*,B.deptname FROM tbiptwentytwo A INNER JOIN tbdepartment B ON A.deptid=B.deptid ORDER BY id")
	List<IP> getAll();
}
