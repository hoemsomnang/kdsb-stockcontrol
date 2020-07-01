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

import com.adminlte.models.Department;
import com.adminlte.services.DepartmentService;

@Controller
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;
	
	@GetMapping("/admin/department")
	public String getDepartment(Model model) {
		//Get List Of Department
		List<Department> deptList=departmentService.findAll();
		
		//Set Value
		model.addAttribute("deptList",deptList);
	    //
		model.addAttribute("dept",new Department());
		return "admin/views/department";
	}
	//Save Department
	@RequestMapping(value="/admin/department/save",method = RequestMethod.POST)
	public String savedepartment(HttpServletRequest request) {
		Department dept=new Department();
		dept.setDeptname(request.getParameter("deptname"));
		if(departmentService.save(dept)) {
			
		}else {
			
		}
		
		return "redirect:/admin/department";
	}
	//Get Single Department 
	@RequestMapping("/admin/department/findById")
	@ResponseBody
	public Optional<Department> getSingle(int deptid){
		return departmentService.findById(deptid);
	}
	//Update Department
	@RequestMapping(value="/admin/department/update",method= RequestMethod.POST)
	public String updateDepartment(HttpServletRequest request) {
		Department dept=new Department();
		dept.setDeptid(Integer.parseInt(request.getParameter("deptid")));
		dept.setDeptname(request.getParameter("deptname"));
		if(departmentService.update(dept)) {
			
		}else {
			
		}
		return "redirect:/admin/department";
	}
	//Delete Department 
	@RequestMapping("/admin/department/delete")
	public String deleteDepartment(int deptid) {
		if(departmentService.delete(deptid)) {
			
		}else {
			
		}
		return "redirect:/admin/department";
	}
	
	
}
