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

import com.adminlte.Excels.DesktopExcelExport;
import com.adminlte.models.Branch;
import com.adminlte.models.Employee;
import com.adminlte.models.Desktop;
import com.adminlte.services.DesktopService;

@Controller
@RequestMapping("/admin/desktop")
public class DesktopController {

	@Autowired
	private DesktopService desktopService;
	/*============================================*/
	/*.................Instock Block.............*/
	@RequestMapping("/instock")
	public String getLaptopInstock(Model model) {
		/*....List.......*/
		List<Desktop> listInstockHQ=desktopService.getListInstockHQ();
		List<Desktop> listInstockSaenSokh=desktopService.getListInstockSaenSokh();
		List<Branch> branch=desktopService.getListOfBranch();
		/*....Counting.....*/
		/*...Head Quarter..*/
		int countInstockHQ=desktopService.countInstockHQ();
		int countUsingHQ=desktopService.countUsingHQ();
		int countAllHQ=desktopService.countAllHQ();
		/*.....Saen Sokh...*/
		int countInstockSaenSokh=desktopService.countInstockSaenSokh();
		int countUsingSaenSokh=desktopService.countUsingSaenSokh();
		int countAllSaenSokh=desktopService.countAllSaenSokh();
		
		
		model.addAttribute("listInstockHQ",listInstockHQ);
		model.addAttribute("listInstockSaenSokh",listInstockSaenSokh);
		model.addAttribute("branch",branch);
		
		model.addAttribute("countInstockHQ",countInstockHQ);
		model.addAttribute("countUsingHQ",countUsingHQ);
		model.addAttribute("countAllHQ",countAllHQ);
		
		model.addAttribute("countInstockSaenSokh",countInstockSaenSokh);
		model.addAttribute("countUsingSaenSokh",countUsingSaenSokh);
		model.addAttribute("countAllSaenSokh",countAllSaenSokh);
		
		return "/admin/views/desktop-instock";
	}
	/*--- Save Desktop Instock ---*/
	@RequestMapping(value="/instock/save",method =RequestMethod.POST)
	public String saveInstock(HttpServletRequest request,Desktop desktop) {
		String din=request.getParameter("datein");
		Date datein=Date.valueOf(din);
		desktop.setDatein(datein);
		if(desktopService.saveInstock(desktop)) {
			
		}else {
			
		}
		return "redirect:/admin/desktop/instock";
	}
	
	/*--- Get Single Desktop Instock ---*/
	@RequestMapping("/instock/findById")
	@ResponseBody
	public Optional<Desktop> getSingleInstock(int desid){
		
		return desktopService.findById(desid);
	}
	/*--- Update Desktop Instock ---*/
	@RequestMapping(value="/instock/update",method=RequestMethod.POST)
	public String updateInstock(Desktop desktop,HttpServletRequest request) {
		String date=request.getParameter("datein");
		Date datein=Date.valueOf(date);
		desktop.setDatein(datein);
		if(desktopService.updateInstock(desktop)){
			
		}else {
			
		}
		return "redirect:/admin/desktop/instock";
	}
	
	/*--- Delete Laptop instock ---*/
	@RequestMapping("/instock/delete")
	public String deleteInstock(int desid) {
		if(desktopService.deleteInstock(desid)) {
			
		}else {
			
		}
		return "redirect:/admin/desktop/instock";
	}
	/*---------- End Desktop Instock Block -----------*/
	/*===============================================*/
	
	/*------------Desktop Using Block-----------------*/
	/*===============================================*/
	@RequestMapping("/using")
	public String getLaptopUsing(Model model) {
		
		List<Desktop> listManagement=desktopService.getListManagement();
		List<Desktop> listHR=desktopService.getListHR();
		List<Desktop> ListIT=desktopService.getListITSupport();
		List<Desktop> listCard=desktopService.getListCard();
		List<Desktop> listFinance=desktopService.getListFinance();
		List<Desktop> listBizAdmin=desktopService.getListBizAdmin();
		List<Desktop> listBizOne=desktopService.getListBizOne();
		List<Desktop> listBizTwo=desktopService.getListBizTwo();
		List<Desktop> listBizThree=desktopService.getListBizThree();
		List<Desktop> listBizFour=desktopService.getListBizFour();
		List<Desktop> listLegal=desktopService.getListLegal();
		List<Desktop> listAudit=desktopService.getListInternalAudit();
		List<Desktop> listRisk=desktopService.getListRisk();
		List<Desktop> listCO=desktopService.getListAllCO();
		List<Desktop> listSaenSokh=desktopService.getListusingSaenSokh();
		/*---------Get list of employee-----------------*/
		List<Employee> listEmployee=desktopService.getListEmployee(); 
		List<Desktop> listDesktop=desktopService.getListDesktop();
		/* Counting */
		/*....HQ....*/
		int countInstockHQ=desktopService.countInstockHQ();
		int countUsingHQ=desktopService.countUsingHQ();
		int countAllHQ=desktopService.countAllHQ();
		/*....Saen Sokh...*/
		int countInstockSaenSokh=desktopService.countInstockSaenSokh();
		int countUsingSaenSokh=desktopService.countUsingSaenSokh();
		int countAllSaenSokh=desktopService.countAllSaenSokh();
		
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
		model.addAttribute("listLaptop",listDesktop);
		
		return"/admin/views/desktop-using";
	}
	
	/*----------Add Desktop Using Form Block--------------*/
	/*-----------Get Employee for text box---------------*/
	@RequestMapping(value="/using/empname")
	@ResponseBody
	public Optional<Employee> showEmployee(int empid){
		return desktopService.getSingleEmployee(empid);
	}
	/*--------Get Desktop not yet Using for Combo Box-----*/
	@RequestMapping(value="/using/desktop-not-yet-using")
	@ResponseBody
	public Optional<Desktop> showLaptop(int desid){
		return desktopService.getSingleDesktop(desid);
	}
	/*--------Save Desktop using-------------------------*/
	@RequestMapping(value="/using/add-Using",method=RequestMethod.POST)
	public String addLaptopusing(Desktop desktop,HttpServletRequest request ) {
		String date=request.getParameter("dateusing");
		Date dateusing=Date.valueOf(date);
		desktop.setDateusing(dateusing);
		if(desktopService.saveUsing(desktop)) {
			
		}else {
			
		}
		return "redirect:/admin/desktop/using";
	}
	/*----Get Single Desktop for update using-------*/
	@RequestMapping("/using/findById")
	@ResponseBody
	public Optional<Desktop> getSingleUsing(int desid){
		
		return desktopService.findById(desid);
	}
	/*-------Update Desktop using----------------*/
	@RequestMapping(value="/using/update",method=RequestMethod.POST)
	public String updaeLaptopUsing(Desktop desktop,HttpServletRequest request) {
		String date=request.getParameter("dateusing"); 
		Date dateusing=Date.valueOf(date);
		desktop.setDateusing(dateusing);
		desktopService.updateUsing(desktop);
		return "redirect:/admin/desktop/using";
	}
	/*-----Return to stock when user change Desktop or employee resigns ..need to return to stock first-----*/
	@RequestMapping(value="/using/return-to-stock")
	public String returnToStock(int desid) {
		desktopService.returnTostock(desid);
		return "redirect:/admin/desktop/using";
	}
	
	/*-----Generate Excel------------*/
	@RequestMapping(value="/using/excel/desktop.xlsx")
	public void downloadExcel(HttpServletResponse respone) throws IOException {
		List<Desktop> desktops=desktopService.getAll();
		respone.setContentType("application/actet-stream");
		respone.setHeader("Content-Disposition","attachment;  filename=list-desktop.xlsx");
		ByteArrayInputStream inputStream= DesktopExcelExport.exportExcel(desktops);
		IOUtils.copy(inputStream,respone.getOutputStream());
		
		
	}
}
