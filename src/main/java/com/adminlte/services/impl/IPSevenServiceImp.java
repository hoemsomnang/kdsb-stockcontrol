package com.adminlte.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminlte.models.IP;
import com.adminlte.repositories.IPSeventRepository;
import com.adminlte.services.IPSevenService;

@Service
public class IPSevenServiceImp implements IPSevenService{

	@Autowired
	private IPSeventRepository ipSevenRepository;
	
	@Override
	public List<IP> getAll() {
		// TODO Auto-generated method stub
		return ipSevenRepository.getAll();
	}

	@Override
	public List<IP> getSystem() {
		// TODO Auto-generated method stub
		return ipSevenRepository.getSystem();
	}

	@Override
	public List<IP> getManagement() {
		// TODO Auto-generated method stub
		return ipSevenRepository.getManagement();
	}

	@Override
	public List<IP> getIT() {
		// TODO Auto-generated method stub
		return ipSevenRepository.getIT();
	}

	@Override
	public List<IP> getCard() {
		// TODO Auto-generated method stub
		return ipSevenRepository.getCard();
	}

	@Override
	public List<IP> getInternalAudit() {
		// TODO Auto-generated method stub
		return ipSevenRepository.getInternalAudit();
	}

	@Override
	public List<IP> getLegal() {
		// TODO Auto-generated method stub
		return ipSevenRepository.getLegal();
	}

	@Override
	public List<IP> getRecovery() {
		// TODO Auto-generated method stub
		return ipSevenRepository.getRecovery();
	}

	@Override
	public List<IP> getReserved() {
		// TODO Auto-generated method stub
		return ipSevenRepository.getReserved();
	}

	@Override
	public List<IP> getPrinter() {
		// TODO Auto-generated method stub
		return ipSevenRepository.getPrinter();
	}

	@Override
	public List<IP> getFingerPrint() {
		// TODO Auto-generated method stub
		return ipSevenRepository.getFingerPrint();
	}

	@Override
	public List<IP> getPhone() {
		// TODO Auto-generated method stub
		return ipSevenRepository.getPhone();
	}

	@Override
	public List<IP> getSwitch() {
		// TODO Auto-generated method stub
		return ipSevenRepository.getSwitch();
	}

	@Override
	public IP findById(int id) {
		// TODO Auto-generated method stub
		return ipSevenRepository.findById(id);
	}

	@Override
	public boolean update(IP ip) {
		// TODO Auto-generated method stub
		return ipSevenRepository.update(ip);
	}

	@Override
	public boolean reservedIP(int id) {
		// TODO Auto-generated method stub
		return ipSevenRepository.reservedIP(id);
	}

}
