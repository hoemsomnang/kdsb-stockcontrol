package com.adminlte.repositories;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.adminlte.models.IP;

@Repository
public interface IPSeventRepository {

    @Select("SELECT A.*,B.deptname FROM tbipseven A INNER JOIN tbdepartment B ON A.deptid=B.deptid ORDER BY id")
	List<IP> getAll();
    @Select("SELECT *FROM tbipseven WHERE deptid=17 AND id BETWEEN 1 AND 10")
	List<IP> getSystem();
    @Select("SELECT *FROM tbipseven WHERE deptid=1")
	List<IP> getManagement();
    @Select("SELECT *FROM tbipseven WHERE deptid=3")
	List<IP> getIT();
    @Select("SELECT *FROM tbipseven WHERE deptid=4")
	List<IP> getCard();
    @Select("SELECT *FROM tbipseven WHERE deptid=12")
	List<IP> getInternalAudit();
    @Select("SELECT *FROM tbipseven WHERE deptid=13 AND id BETWEEN 69 AND 83")
	List<IP> getLegal();
    @Select("SELECT *FROM tbipseven WHERE deptid=14 AND id BETWEEN 84 AND 98")
	List<IP> getRecovery();
    @Select("SELECT *FROM tbipseven WHERE deptid=13 AND id BETWEEN 99 AND 200")
	List<IP> getReserved();
    @Select("SELECT *FROM tbipseven WHERE deptid=17 AND id BETWEEN 201 AND 210")
	List<IP> getPrinter();
    @Select("SELECT *FROM tbipseven WHERE deptid=17 AND id BETWEEN 211 AND 230")
	List<IP> getFingerPrint();
    @Select("SELECT *FROM tbipseven WHERE deptid=17 AND id BETWEEN 231 AND 250")
	List<IP> getPhone();
    @Select("SELECT *FROM tbipseven WHERE deptid=17 AND id BETWEEN 251 AND 254")
	List<IP> getSwitch();
    @Select("SELECT *FROM tbipseven WHERE id=#{id}")
	IP findById(@Param("id") int id);
	@Update("UPDATE tbipseven SET macaddress=#{ip.macaddress},"
			+ "username=#{ip.username},sn=#{ip.sn},location=#{ip.location},pcname=#{ip.pcname},"
			+ "antivirus=#{ip.antivirus},ramark=#{ip.ramark},extension=#{ip.extension} WHERE id=#{ip.id}")
	boolean update(@Param("ip") IP ip);
	/*--------- Reserved IP ---------*/
	@Update("UPDATE tbipseven SET macaddress='Reserved',"
			+ "username='Reserved',sn='',location='',pcname='',"
			+ "antivirus='',ramark='',extension='' WHERE id=#{id}")
	boolean reservedIP(@Param("id") int id);
}
