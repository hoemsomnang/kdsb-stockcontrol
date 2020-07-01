package com.adminlte.services;

import java.util.List;

import com.adminlte.models.IP;

public interface IPSaenSokhService {

	List<IP> getAll();
	List<IP> getSystem();
	List<IP> getManagement();
	List<IP> getStaff();
	List<IP> getPrinter();
	List<IP> getFingerPrint();
	List<IP> getPhone();
	List<IP> getSwitch();
	IP findById(int id);
	boolean update(IP ip);
	boolean reservedIP(int id);
}
