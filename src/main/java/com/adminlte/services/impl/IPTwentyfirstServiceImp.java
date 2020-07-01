package com.adminlte.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminlte.models.IP;
import com.adminlte.repositories.IPTwentyfirstRepository;
import com.adminlte.services.IPTwentyfirstService;

@Service
public class IPTwentyfirstServiceImp implements IPTwentyfirstService{

	@Autowired
	private IPTwentyfirstRepository ipTwentyfirstRepository;
	
	@Override
	public List<IP> getAll() {
		// TODO Auto-generated method stub
		return ipTwentyfirstRepository.getAll();
	}

	@Override
	public List<IP> getSystem() {
		// TODO Auto-generated method stub
		return ipTwentyfirstRepository.getSystem();
	}

	@Override
	public List<IP> getManagement() {
		// TODO Auto-generated method stub
		return ipTwentyfirstRepository.getManagement();
	}

	@Override
	public List<IP> getBizAdmin() {
		// TODO Auto-generated method stub
		return ipTwentyfirstRepository.getBizAdmin();
	}

	@Override
	public List<IP> getBizThree() {
		// TODO Auto-generated method stub
		return ipTwentyfirstRepository.getBizThree();
	}

	@Override
	public List<IP> getBizFour() {
		// TODO Auto-generated method stub
		return ipTwentyfirstRepository.getBizFour();
	}

	@Override
	public List<IP> getCollection() {
		// TODO Auto-generated method stub
		return ipTwentyfirstRepository.getCollection();
	}

	@Override
	public List<IP> getRisk() {
		// TODO Auto-generated method stub
		return ipTwentyfirstRepository.getRisk();
	}

	@Override
	public List<IP> getMarketing() {
		// TODO Auto-generated method stub
		return ipTwentyfirstRepository.getMarketing();
	}

	@Override
	public List<IP> getAssessment() {
		// TODO Auto-generated method stub
		return ipTwentyfirstRepository.getAssessment();
	}

	@Override
	public List<IP> getPrinter() {
		// TODO Auto-generated method stub
		return ipTwentyfirstRepository.getPrinter();
	}

	@Override
	public List<IP> getFingerPrint() {
		// TODO Auto-generated method stub
		return ipTwentyfirstRepository.getFingerPrint();
	}

	@Override
	public List<IP> getPhone() {
		// TODO Auto-generated method stub
		return ipTwentyfirstRepository.getPhone();
	}

	@Override
	public List<IP> getSwitch() {
		// TODO Auto-generated method stub
		return ipTwentyfirstRepository.getSwitch();
	}

	@Override
	public IP findById(int id) {
		// TODO Auto-generated method stub
		return ipTwentyfirstRepository.findById(id);
	}

	@Override
	public boolean update(IP ip) {
		// TODO Auto-generated method stub
		return ipTwentyfirstRepository.update(ip);
	}

	@Override
	public boolean reserved(int id) {
		// TODO Auto-generated method stub
		return ipTwentyfirstRepository.reservedIP(id);
	}

	

}
