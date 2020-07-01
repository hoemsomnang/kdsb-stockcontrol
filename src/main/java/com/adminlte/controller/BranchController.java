package com.adminlte.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adminlte.models.Branch;
import com.adminlte.services.BranchService;

@Controller
public class BranchController {

	@Autowired
	BranchService branchService;
	
	//Get List Of Branch
	@GetMapping("/admin/branch")
	public String getBranch(Model model) {
		List<Branch> branchList=branchService.findAll();
		
		//Set Value
		model.addAttribute("branchList",branchList);
		model.addAttribute("br",new Branch());
		return "admin/views/branch";
	}
	
	//Save Branch Data into Database
	@RequestMapping(value="/admin/branch/save",method =RequestMethod.POST)
	public String save(HttpServletRequest request) {
		Branch br=new Branch();
		br.setBrname(request.getParameter("brname"));
		if(branchService.save(br)) {
			
		}else {
			
		}
		return "redirect:/admin/branch";
	}
	//Get Single Branch
	@RequestMapping("/admin/branch/findById")
	@ResponseBody
	public Optional<Branch> getSingle(int brid) {
		return branchService.findById(brid);
	}
	
	//Update Branch
	@RequestMapping(value="/admin/branch/update",method= RequestMethod.POST)
	public String update(HttpServletRequest request) {
		Branch br=new Branch();
		int brid=Integer.parseInt(request.getParameter("brid"));
		br.setBrid(brid);
		br.setBrname(request.getParameter("brname"));
		if(branchService.update(br)) {
			
		}{
			
		}
		return "redirect:/admin/branch";
	}
	
	//Delete Branch 
	@RequestMapping("/admin/branch/delete")
	public String delete(int brid) {
		if(branchService.delete(brid)) {
			
		}else {
			
		}
		return "redirect:/admin/branch";
	}
	
}
