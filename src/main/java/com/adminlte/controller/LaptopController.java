package com.adminlte.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adminlte.Excels.LaptopExcelExport;
import com.adminlte.models.Branch;
import com.adminlte.models.Employee;
import com.adminlte.models.Laptop;
import com.adminlte.services.LaptopService;

@Controller
@RequestMapping("/admin/laptop")
public class LaptopController {

	@Autowired
	private LaptopService laptopService;
	/*============================================*/
	/*.................Instock Block.............*/
	@RequestMapping("/instock")
	public String getLaptopInstock(Model model) {
		/*....List.......*/
		List<Laptop> listInstockHQ=laptopService.getListInstockHQ();
		List<Laptop> listInstockSaenSokh=laptopService.getListInstockSaenSokh();
		List<Branch> branch=laptopService.getListOfBranch();
		/*....Counting.....*/
		/*...Head Quarter..*/
		int countInstockHQ=laptopService.countInstockHQ();
		int countUsingHQ=laptopService.countUsingHQ();
		int countAllHQ=laptopService.countAllHQ();
		/*.....Saen Sokh...*/
		int countInstockSaenSokh=laptopService.countInstockSaenSokh();
		int countUsingSaenSokh=laptopService.countUsingSaenSokh();
		int countAllSaenSokh=laptopService.countAllSaenSokh();
		
		
		model.addAttribute("listInstockHQ",listInstockHQ);
		model.addAttribute("listInstockSaenSokh",listInstockSaenSokh);
		model.addAttribute("branch",branch);
		
		model.addAttribute("countInstockHQ",countInstockHQ);
		model.addAttribute("countUsingHQ",countUsingHQ);
		model.addAttribute("countAllHQ",countAllHQ);
		
		model.addAttribute("countInstockSaenSokh",countInstockSaenSokh);
		model.addAttribute("countUsingSaenSokh",countUsingSaenSokh);
		model.addAttribute("countAllSaenSokh",countAllSaenSokh);
		
		return "/admin/views/laptop-instock";
	}
	/*--- Save Laptop Instock ---*/
	@RequestMapping(value="/instock/save",method =RequestMethod.POST)
	public String saveInstock(HttpServletRequest request,Laptop laptop) {
		String din=request.getParameter("datein");
		Date datein=Date.valueOf(din);
		laptop.setDatein(datein);
		if(laptopService.saveInstock(laptop)) {
			
		}else {
			
		}
		return "redirect:/admin/laptop/instock";
	}
	
	/*--- Get Single Laptop Instock ---*/
	@RequestMapping("/instock/findById")
	@ResponseBody
	public Optional<Laptop> getSingleInstock(int lapid){
		
		return laptopService.findById(lapid);
	}
	/*--- Update Laptop Instock ---*/
	@RequestMapping(value="/instock/update",method=RequestMethod.POST)
	public String updateInstock(Laptop laptop,HttpServletRequest request) {
		String date=request.getParameter("datein");
		Date datein=Date.valueOf(date);
		laptop.setDatein(datein);
		if(laptopService.updateInstock(laptop)){
			
		}else {
			
		}
		return "redirect:/admin/laptop/instock";
	}
	
	/*--- Delete Laptop instock ---*/
	@RequestMapping("/instock/delete")
	public String deleteInstock(int lapid) {
		if(laptopService.deleteInstock(lapid)) {
			
		}else {
			
		}
		return "redirect:/admin/laptop/instock";
	}
	/*---------- End Laptop Instock Block -----------*/
	/*===============================================*/
	
	/*------------Laptop Using Block-----------------*/
	/*===============================================*/
	@RequestMapping("/using")
	public String getLaptopUsing(Model model) {
		
		List<Laptop> listManagement=laptopService.getListManagement();
		List<Laptop> listHR=laptopService.getListHR();
		List<Laptop> ListIT=laptopService.getListITSupport();
		List<Laptop> listCard=laptopService.getListCard();
		List<Laptop> listFinance=laptopService.getListFinance();
		List<Laptop> listBizAdmin=laptopService.getListBizAdmin();
		List<Laptop> listBizOne=laptopService.getListBizOne();
		List<Laptop> listBizTwo=laptopService.getListBizTwo();
		List<Laptop> listBizThree=laptopService.getListBizThree();
		List<Laptop> listBizFour=laptopService.getListBizFour();
		List<Laptop> listLegal=laptopService.getListLegal();
		List<Laptop> listAudit=laptopService.getListInternalAudit();
		List<Laptop> listRisk=laptopService.getListRisk();
		List<Laptop> listCO=laptopService.getListAllCO();
		List<Laptop> listSaenSokh=laptopService.getListusingSaenSokh();
		/*---------Get list of employee-----------------*/
		List<Employee> listEmployee=laptopService.getListEmployee(); 
		List<Laptop> listLaptop=laptopService.getListLaptop();
		/* Counting */
		/*....HQ....*/
		int countInstockHQ=laptopService.countInstockHQ();
		int countUsingHQ=laptopService.countUsingHQ();
		int countAllHQ=laptopService.countAllHQ();
		/*....Saen Sokh...*/
		int countInstockSaenSokh=laptopService.countInstockSaenSokh();
		int countUsingSaenSokh=laptopService.countUsingSaenSokh();
		int countAllSaenSokh=laptopService.countAllSaenSokh();
		
		model.addAttribute("listManagement",listManagement);
		model.addAttribute("listHR",listHR);
		model.addAttribute("ListIT",ListIT);
		model.addAttribute("listCard",listCard);
		model.addAttribute("listFinance",listFinance);
		model.addAttribute("listBizAdmin",listBizAdmin);
		model.addAttribute("listBizOne",listBizOne);
		model.addAttribute("listBizTwo",listBizTwo);
		model.addAttribute("listBizThree",listBizThree);
		model.addAttribute("listBizFour",listBizFour);
		model.addAttribute("listLegal",listLegal);
		model.addAttribute("listAudit",listAudit);
		model.addAttribute("listRisk",listRisk);
		model.addAttribute("listCO",listCO);
		model.addAttribute("listSaenSokh",listSaenSokh);
		
		model.addAttribute("countInstockHQ",countInstockHQ);
		model.addAttribute("countUsingHQ",countUsingHQ);
		model.addAttribute("countAllHQ",countAllHQ);
		
		/*....Sean Sokh.......*/
		model.addAttribute("countInstockSaenSokh",countInstockSaenSokh);
		model.addAttribute("countUsingSaenSokh",countUsingSaenSokh);
		model.addAttribute("countAllSaenSokh",countAllSaenSokh);
		
		/*....List employee......*/
		model.addAttribute("listEmployee",listEmployee);
		model.addAttribute("listLaptop",listLaptop);
		
		return"/admin/views/laptop-using";
	}
	
	/*----------Add Laptop Using Form Block--------------*/
	/*-----------Get Employee for text box---------------*/
	@RequestMapping(value="/using/empname")
	@ResponseBody
	public Optional<Employee> showEmployee(int empid){
		return laptopService.getSingleEmployee(empid);
	}
	/*--------Get Laptop not yet Using for Combo Box-----*/
	@RequestMapping(value="/using/laptop-not-yet-using")
	@ResponseBody
	public Optional<Laptop> showLaptop(int lapid){
		return laptopService.getSingleLaptop(lapid);
	}
	/*--------Save laptop using-------------------------*/
	@RequestMapping(value="/using/add-Using",method=RequestMethod.POST)
	public String addLaptopusing(Laptop laptop,HttpServletRequest request ) {
		String date=request.getParameter("dateusing");
		Date dateusing=Date.valueOf(date);
		laptop.setDateusing(dateusing);
		if(laptopService.saveUsing(laptop)) {
			
		}else {
			
		}
		return "redirect:/admin/laptop/using";
	}
	/*----Get Single laptop for update using-------*/
	@RequestMapping("/using/findById")
	@ResponseBody
	public Optional<Laptop> getSingleUsing(int lapid){
		
		return laptopService.findById(lapid);
	}
	/*-------Update laptop using----------------*/
	@RequestMapping(value="/using/update",method=RequestMethod.POST)
	public String updaeLaptopUsing(Laptop laptop,HttpServletRequest request) {
		String date=request.getParameter("dateusing"); 
		Date dateusing=Date.valueOf(date);
		laptop.setDateusing(dateusing);
		laptopService.updateUsing(laptop);
		return "redirect:/admin/laptop/using";
	}
	/*-----Return to stock when user change laptop or employee resigns ..need to return to stock first-----*/
	@RequestMapping(value="/using/return-to-stock")
	public String returnToStock(int lapid) {
		laptopService.returnTostock(lapid);
		return "redirect:/admin/laptop/using";
	}
	
	/*-----Generate Excel------------*/
	@RequestMapping(value="/using/excel/laptop.xlsx")
	public void downloadExcel(HttpServletResponse respone) throws IOException {
		List<Laptop> laptops=laptopService.getAll();
		respone.setContentType("application/actet-stream");
		respone.setHeader("Content-Disposition","attachment;  filename=list-laptop.xlsx");
		ByteArrayInputStream inputStream= LaptopExcelExport.exportExcel(laptops);
		IOUtils.copy(inputStream,respone.getOutputStream());
		
		
	}
}
