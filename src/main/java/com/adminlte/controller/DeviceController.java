package com.adminlte.controller;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adminlte.Excels.DeviceExcelExport;
import com.adminlte.models.Branch;
import com.adminlte.models.Category;
import com.adminlte.models.Devices;
import com.adminlte.services.BranchService;
import com.adminlte.services.DeviceService;

@Controller
@RequestMapping("/admin/device")
public class DeviceController {

	@Autowired
	DeviceService deviceService;
	@Autowired
	BranchService branchService;
	
	
	@RequestMapping("")
	public String getAll(Model model) {
		List<Devices> Listdevices=deviceService.getAll();
		List<Branch> branch=branchService.findAll();
		List<Category> categorys=deviceService.findAllcategory();
		int total=deviceService.countAll();
		//System.out.print(devices);
		model.addAttribute("Listdevices",Listdevices);
		model.addAttribute("branch",branch);
		model.addAttribute("categorys",categorys);
		model.addAttribute("total",total);
		return "/admin/views/device";
	}
	@PostMapping("/save")
	public String saveDevice(Devices devices,HttpServletRequest request) {
		String indate=request.getParameter("datein");
		Date datein=Date.valueOf(indate);
		String usingDate=request.getParameter("dateusing");
		Date dateusing=Date.valueOf(usingDate);
		devices.setDatein(datein);
		devices.setDateusing(dateusing);
		deviceService.save(devices)	;	
		return "redirect:/admin/device";
	}
	/*---- Find Single Device by ID ----*/
	@GetMapping("/findById/{devid}")
	@ResponseBody
	public Devices findById(@PathVariable("devid") int devid) {
		return deviceService.findById(devid);
	}
	/*---- Update Device ----*/
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateDevice(Devices device,HttpServletRequest request) {
		String indate=request.getParameter("datein");
		String usingdate=request.getParameter("dateusing");
		Date datein=Date.valueOf(indate);
		Date dateusing=Date.valueOf(usingdate);
		device.setDatein(datein);
		device.setDateusing(dateusing);
		//System.out.print(device.getVersion());
		deviceService.update(device);
		return "redirect:/admin/device";
	}
	@RequestMapping("/delete/{devid}")
	public String deleteDevice(@PathVariable("devid") int devid) {
	    deviceService.delete(devid);
		return "redirect:/admin/device";
	}
	/*------ Generate Excel ------*/
	@RequestMapping(value="/excel/device.xlsx")
	public void downloadExcel(HttpServletResponse respone) throws IOException {
		List<Devices> devices=deviceService.getAll();
		//System.out.print(devices);
		respone.setContentType("application/actet-stream");
		respone.setHeader("Content-Disposition","attachment;  filename=list-device.xlsx");
		ByteArrayInputStream inputStream= DeviceExcelExport.exportExcel(devices);
		IOUtils.copy(inputStream,respone.getOutputStream());
		
		
	}
}
