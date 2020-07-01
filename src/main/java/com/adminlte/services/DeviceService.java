package com.adminlte.services;

import java.util.List;

import com.adminlte.models.Category;
import com.adminlte.models.Devices;

public interface DeviceService {


	public List<Devices> getAll();
    public boolean save(Devices devices);
    public List<Category> findAllcategory();
    public Devices findById(int devid);
	public boolean update(Devices device);
	public boolean delete(int devid);
	public int countAll();
}
