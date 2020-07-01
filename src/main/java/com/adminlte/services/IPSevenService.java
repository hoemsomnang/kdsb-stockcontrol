package com.adminlte.services;

import java.util.List;



import com.adminlte.models.IP;

public interface IPSevenService {


	List<IP> getAll();
	List<IP> getSystem();
	List<IP> getManagement();
	List<IP> getIT();
	List<IP> getCard();
	List<IP> getInternalAudit();
	List<IP> getLegal();
	List<IP> getRecovery();
	List<IP> getReserved();
	List<IP> getPrinter();
	List<IP> getFingerPrint();
	List<IP> getPhone();
	List<IP> getSwitch();
	IP findById( int id);
	boolean update( IP ip);
	boolean reservedIP( int id);
}
