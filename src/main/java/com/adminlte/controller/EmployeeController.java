package com.adminlte.controller;



import java.sql.Date;
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
import com.adminlte.models.Department;
import com.adminlte.models.Employee;
import com.adminlte.services.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	//Method Get All Employee
	@GetMapping("/admin/employee")
	public String getEmployee(Model model) {
		
		//
		List<Employee> empList=employeeService.findAll(); // All employees in Head Quarter
		List<Employee> empListSaenSokh=employeeService.finAllSaenSokh();//All employees in Saen Sokh Branch
		List<Department> deptList=employeeService.findDeptAll();//
		List<Branch> branchList=employeeService.findBranchAll();
		//
		List<Employee> listManagement=employeeService.findManagement();
		List<Employee> listHR=employeeService.findHR();
		List<Employee> listIT=employeeService.findIT();
		List<Employee> listCard=employeeService.findCard();
		List<Employee> listFinance=employeeService.findFinance();
		List<Employee> listBizAdmin=employeeService.findBizAdmin();
		List<Employee> listBizOne=employeeService.findBizOne();
		List<Employee> listBizTwo=employeeService.findBizTwo();
		List<Employee> listBizThree=employeeService.findBizThree();
		List<Employee> listBizFour=employeeService.findBizFour();
		List<Employee> listMaketing=employeeService.findMarketing();
		List<Employee> listAudit=employeeService.findAudit();
		List<Employee> listLegal=employeeService.findLegal();
		List<Employee> listRecovery=employeeService.findRecovery();
		List<Employee> listAssessment=employeeService.findAssessment();
		List<Employee> listRisk=employeeService.findRisk();
		List<Employee> listSaenSokh=employeeService.findSaenSokh();
		int femaleHQ=employeeService.femaleHQ();
		int maleHQ=employeeService.maleHQ();
		int allHQ=employeeService.allHQ();
		
		int femaleSaenSokh=employeeService.femaleSaenSokh();
		int maleSaenSokh=employeeService.maleSaenSokh();
		int allSaenSokh=employeeService.allSaenSokh();
		
		//Set 
		model.addAttribute("empList",empList);
		model.addAttribute("empListSaenSokh",empListSaenSokh);
		model.addAttribute("deptList",deptList);
		model.addAttribute("branchList",branchList);
		//
		model.addAttribute("listManagement",listManagement);
		model.addAttribute("listHR",listHR);
		model.addAttribute("listIT",listIT);
		model.addAttribute("listCard",listCard);
		model.addAttribute("listFinance",listFinance);
		model.addAttribute("listBizAdmin",listBizAdmin);
		model.addAttribute("listBizOne",listBizOne);
		model.addAttribute("listBizTwo",listBizTwo);
		model.addAttribute("listBizThree",listBizThree);
		model.addAttribute("listBizFour",listBizFour);
		model.addAttribute("listMaketing",listMaketing);
		model.addAttribute("listAudit",listAudit);
		model.addAttribute("listLegal",listLegal);
		model.addAttribute("listRecovery",listRecovery);
		model.addAttribute("listAssessment",listAssessment);
		model.addAttribute("listRisk",listRisk);
		model.addAttribute("listSaenSokh",listSaenSokh);
		//
		model.addAttribute("femaleHQ",femaleHQ);
		model.addAttribute("maleHQ",maleHQ);
		model.addAttribute("allHQ",allHQ);

		model.addAttribute("femaleSaenSokh",femaleSaenSokh);
		model.addAttribute("maleSaenSokh",maleSaenSokh);
		model.addAttribute("allSaenSokh",allSaenSokh);
		//For Using Employee Class
		model.addAttribute("emp",new Employee());
		return"admin/views/employee";
	}
	
	//Save Data
	@RequestMapping(value="/admin/employee/save",method =RequestMethod.POST)
	public String saveEmployee(Employee emp,HttpServletRequest request)  {
		String birth=request.getParameter("dob");
		Date dob=Date.valueOf(birth);
		emp.setDob(dob);		
		System.out.println(emp.getDob());
		  if(employeeService.save(emp)) {
		  
		  }else {
		  
		  }
		return "redirect:/admin/employee";
	}
	
	//Find Single Employee
	
	@RequestMapping("/admin/employee/findById")
	@ResponseBody
	public Optional<Employee> getSingleEmployee(int empid){
		return employeeService.findById(empid);
	}
	
	
	//Update
	@RequestMapping(value="/admin/employee/update",method =RequestMethod.POST)
	public String updateEmployee(Employee emp,HttpServletRequest request) {
		String birth=request.getParameter("dob");
		Date dob=Date.valueOf(birth);
		emp.setDob(dob);	
	    if(employeeService.update(emp)) {
	    	
	    }else {
	    	
	    }
		return "redirect:/admin/employee";
	}
	
	
	//Delete
	@RequestMapping("/admin/employee/delete")
	public String deleteEmployee(int empid) {
		if(employeeService.delete(empid)) {
			
		}else {
			
		}
		return "redirect:/admin/employee";
	}
	
}
