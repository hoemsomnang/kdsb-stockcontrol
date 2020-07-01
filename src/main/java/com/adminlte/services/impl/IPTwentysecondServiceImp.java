package com.adminlte.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminlte.models.IP;
import com.adminlte.repositories.IPTwentysecondRepository;
import com.adminlte.services.IPTwentysecondService;
@Service
public class IPTwentysecondServiceImp implements IPTwentysecondService {

	@Autowired
	private IPTwentysecondRepository ipTwentysecondRepository;
	
	@Override
	public List<IP> getSystem() {
		// TODO Auto-generated method stub
		return ipTwentysecondRepository.getSystem();
	}

	@Override
	public List<IP> getManagement() {
		// TODO Auto-generated method stub
		return ipTwentysecondRepository.getManagement();
	}

	@Override
	public List<IP> getFinance() {
		// TODO Auto-generated method stub
		return ipTwentysecondRepository.getFinance();
	}

	@Override
	public List<IP> getHR() {
		// TODO Auto-generated method stub
		return ipTwentysecondRepository.getHR();
	}

	@Override
	public List<IP> getBizone() {
		// TODO Auto-generated method stub
		return ipTwentysecondRepository.getBizone();
	}

	@Override
	public List<IP> getBiztwo() {
		// TODO Auto-generated method stub
		return ipTwentysecondRepository.getBiztwo();
	}

	@Override
	public List<IP> getIPquest() {
		// TODO Auto-generated method stub
		return ipTwentysecondRepository.getIPquest();
	}

	@Override
	public List<IP> getAllCO() {
		// TODO Auto-generated method stub
		return ipTwentysecondRepository.getAllCO();
	}

	@Override
	public List<IP> getPrinter() {
		// TODO Auto-generated method stub
		return ipTwentysecondRepository.getPrinter();
	}

	@Override
	public List<IP> getFingerprint() {
		// TODO Auto-generated method stub
		return ipTwentysecondRepository.getFingerprint();
	}

	@Override
	public List<IP> getPhone() {
		// TODO Auto-generated method stub
		return ipTwentysecondRepository.getPhone();
	}

	@Override
	public List<IP> getSwitch() {
		// TODO Auto-generated method stub
		return ipTwentysecondRepository.getSwitch();
	}

	@Override
	public IP findById(int id) {
		// TODO Auto-generated method stub
		return ipTwentysecondRepository.findById(id);
	}

	@Override
	public boolean update(IP ip) {
		// TODO Auto-generated method stub
		return ipTwentysecondRepository.update(ip);
	}

	@Override
	public boolean reserved(int id) {
		// TODO Auto-generated method stub
		return ipTwentysecondRepository.reservedIP(id);
	}

	@Override
	public List<IP> getAll() {
		// TODO Auto-generated method stub
		return ipTwentysecondRepository.getAll();
	}

}
