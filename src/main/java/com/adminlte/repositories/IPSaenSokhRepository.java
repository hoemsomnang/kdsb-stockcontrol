package com.adminlte.repositories;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.adminlte.models.IP;

@Repository
public interface IPSaenSokhRepository {

	@Select("SELECT A.*,B.deptname FROM tbipseansok A INNER JOIN tbdepartment B ON A.deptid=B.deptid ORDER BY id")
	List<IP> getAll();
	@Select("SELECT *FROM tbipseansok WHERE deptid=17 AND id BETWEEN 1 AND 10")
	List<IP> getSystem();
	@Select("SELECT *FROM tbipseansok WHERE deptid=1")
	List<IP> getManagement();
	@Select("SELECT *FROM tbipseansok WHERE deptid=20")
	List<IP> getStaff();
	@Select("SELECT *FROM tbipseansok WHERE deptid=17 AND id BETWEEN 201 AND 210")
	List<IP> getPrinter();
	@Select("SELECT *FROM tbipseansok WHERE deptid=17 AND id BETWEEN 211 AND 220")
	List<IP> getFingerPrint();
	@Select("SELECT *FROM tbipseansok WHERE deptid=17 AND id BETWEEN 221 AND 250")
	List<IP> getPhone();
	@Select("SELECT *FROM tbipseansok WHERE deptid=17 AND id BETWEEN 250 AND 254")
	List<IP> getSwitch();
	@Select("SELECT *FROM tbipseansok WHERE id=#{id}")
	IP findById(@Param("id") int id);
	@Update("UPDATE tbipseansok SET macaddress=#{ip.macaddress},"
			+ "username=#{ip.username},sn=#{ip.sn},location=#{ip.location},pcname=#{ip.pcname},"
			+ "antivirus=#{ip.antivirus},ramark=#{ip.ramark},extension=#{ip.extension} WHERE id=#{ip.id}")
	boolean update(@Param("ip") IP ip);
	/*--------- Reserved IP ---------*/
	@Update("UPDATE tbipseansok SET macaddress='Reserved',"
			+ "username='Reserved',sn='',location='',pcname='',"
			+ "antivirus='',ramark='',extension='' WHERE id=#{id}")
	boolean reservedIP(@Param("id") int id);
}
