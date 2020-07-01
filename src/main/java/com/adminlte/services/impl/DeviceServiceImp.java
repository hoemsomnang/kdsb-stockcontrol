package com.adminlte.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminlte.models.Category;
import com.adminlte.models.Devices;
import com.adminlte.repositories.DeviceRepository;
import com.adminlte.services.DeviceService;

@Service
public class DeviceServiceImp implements DeviceService{

	@Autowired
	DeviceRepository deviceRepository;
	
	
	@Override
	public List<Devices> getAll() {
		// TODO Auto-generated method stub
		return deviceRepository.getAll();
	}


	@Override
	public boolean save(Devices devices) {
		// TODO Auto-generated method stub
		return deviceRepository.save(devices);
	}


	@Override
	public List<Category> findAllcategory() {
		// TODO Auto-generated method stub
		return deviceRepository.findAllcategroy();
	}


	@Override
	public Devices findById(int devid) {
		// TODO Auto-generated method stub
		return deviceRepository.findById(devid);
	}


	@Override
	public boolean update(Devices device) {
		// TODO Auto-generated method stub
		return deviceRepository.update(device);
	}


	@Override
	public boolean delete(int devid) {
		// TODO Auto-generated method stub
		return deviceRepository.delete(devid);
	}


	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return deviceRepository.countAll();
	}

	
	
	

	
}
