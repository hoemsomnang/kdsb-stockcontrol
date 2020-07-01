package com.adminlte.services;

import java.util.List;

import com.adminlte.models.IP;

public interface IPTwentysecondService {

	List<IP> getSystem();
	List<IP> getManagement();
	List<IP> getFinance();
	List<IP> getHR();
	List<IP> getBizone();
	List<IP> getBiztwo();
	List<IP> getIPquest();
	List<IP> getAllCO();
	List<IP> getPrinter();
	List<IP> getFingerprint();
	List<IP> getPhone();
	List<IP> getSwitch();
	IP findById(int id);
	boolean update(IP ip);
	boolean reserved(int id);
	List<IP> getAll();
}
