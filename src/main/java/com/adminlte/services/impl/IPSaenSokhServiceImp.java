package com.adminlte.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminlte.models.IP;
import com.adminlte.repositories.IPSaenSokhRepository;
import com.adminlte.services.IPSaenSokhService;

@Service
public class IPSaenSokhServiceImp implements IPSaenSokhService{

	@Autowired
	private IPSaenSokhRepository ipSaenSokhRepository;
	
	@Override
	public List<IP> getAll() {
		// TODO Auto-generated method stub
		return ipSaenSokhRepository.getAll();
	}

	@Override
	public List<IP> getSystem() {
		// TODO Auto-generated method stub
		return ipSaenSokhRepository.getSystem();
	}

	@Override
	public List<IP> getManagement() {
		// TODO Auto-generated method stub
		return ipSaenSokhRepository.getManagement();
	}

	@Override
	public List<IP> getStaff() {
		// TODO Auto-generated method stub
		return ipSaenSokhRepository.getStaff();
	}

	@Override
	public List<IP> getPrinter() {
		// TODO Auto-generated method stub
		return ipSaenSokhRepository.getPrinter();
	}

	@Override
	public List<IP> getFingerPrint() {
		// TODO Auto-generated method stub
		return ipSaenSokhRepository.getFingerPrint();
	}

	@Override
	public List<IP> getPhone() {
		// TODO Auto-generated method stub
		return ipSaenSokhRepository.getPhone();
	}

	@Override
	public List<IP> getSwitch() {
		// TODO Auto-generated method stub
		return ipSaenSokhRepository.getSwitch();
	}

	@Override
	public IP findById(int id) {
		// TODO Auto-generated method stub
		return ipSaenSokhRepository.findById(id);
	}

	@Override
	public boolean update(IP ip) {
		// TODO Auto-generated method stub
		return ipSaenSokhRepository.update(ip);
	}

	@Override
	public boolean reservedIP(int id) {
		// TODO Auto-generated method stub
		return ipSaenSokhRepository.reservedIP(id);
	}

	
}
