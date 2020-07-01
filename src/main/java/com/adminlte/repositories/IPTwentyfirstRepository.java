package com.adminlte.repositories;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.adminlte.models.IP;

@Repository
public interface IPTwentyfirstRepository {

	@Select("SELECT A.*,B.deptname FROM tbiptwentyone A INNER JOIN tbdepartment B ON A.deptid=B.deptid ORDER BY id")
	List<IP> getAll();
	@Select("SELECT *FROM tbiptwentyone WHERE deptid=17 AND id BETWEEN 1 AND 10")
	List<IP> getSystem();
	@Select("SELECT *FROM tbiptwentyone WHERE deptid=1")
	List<IP> getManagement();
	@Select("SELECT *FROM tbiptwentyone WHERE deptid=6")
	List<IP> getBizAdmin();
	@Select("SELECT *FROM tbiptwentyone WHERE deptid=9")
	List<IP> getBizThree();
	@Select("SELECT *FROM tbiptwentyone WHERE deptid=10")
	List<IP> getBizFour();
	@Select("SELECT *FROM tbiptwentyone WHERE deptid=14")
	List<IP> getCollection();
	@Select("SELECT *FROM tbiptwentyone WHERE deptid=16")
	List<IP> getRisk();
	@Select("SELECT *FROM tbiptwentyone WHERE deptid=11")
	List<IP> getMarketing();
	@Select("SELECT *FROM tbiptwentyone WHERE deptid=15")
	List<IP> getAssessment();
	@Select("SELECT *FROM tbiptwentyone WHERE deptid=17 AND id BETWEEN 201 AND 210")
	List<IP> getPrinter();
	@Select("SELECT *FROM tbiptwentyone WHERE deptid=17 AND id BETWEEN 211 AND 230")
	List<IP> getFingerPrint();
	@Select("SELECT *FROM tbiptwentyone WHERE deptid=17 AND id BETWEEN 231 AND 250")
	List<IP> getPhone();
	@Select("SELECT *FROM tbiptwentyone WHERE deptid=17 AND id BETWEEN 251 AND 254")
	List<IP> getSwitch();
	@Select("SELECT *FROM tbiptwentyone WHERE id=#{id}")
	IP findById(@Param("id") int id);
	@Update("UPDATE tbiptwentyone SET macaddress=#{ip.macaddress},"
			+ "username=#{ip.username},sn=#{ip.sn},location=#{ip.location},pcname=#{ip.pcname},"
			+ "antivirus=#{ip.antivirus},ramark=#{ip.ramark},extension=#{ip.extension} WHERE id=#{ip.id}")
	boolean update(@Param("ip") IP ip);
	/*--------- Reserved IP ---------*/
	@Update("UPDATE tbiptwentyone SET macaddress='Reserved',"
			+ "username='Reserved',sn='',location='',pcname='',"
			+ "antivirus='',ramark='',extension='' WHERE id=#{id}")
	boolean reservedIP(@Param("id") int id);
}
 