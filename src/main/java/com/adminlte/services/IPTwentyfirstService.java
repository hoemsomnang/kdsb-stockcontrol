package com.adminlte.services;

import java.util.List;

import com.adminlte.models.IP;

public interface IPTwentyfirstService {

	List<IP> getAll();
	List<IP> getSystem();
	List<IP> getManagement();
	List<IP> getBizAdmin();
	List<IP> getBizThree();
	List<IP> getBizFour();
	List<IP> getCollection();
	List<IP> getRisk();
	List<IP> getMarketing();
	List<IP> getAssessment();
	List<IP> getPrinter();
	List<IP> getFingerPrint();
	List<IP> getPhone();
	List<IP> getSwitch();
	IP findById(int id);
	boolean update(IP ip);
	boolean reserved(int id);
	
}
