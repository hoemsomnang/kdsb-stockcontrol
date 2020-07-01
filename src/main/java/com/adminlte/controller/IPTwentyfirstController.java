package com.adminlte.controller;

import java.io.ByteArrayInputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adminlte.Excels.IPExcelExport;
import com.adminlte.models.IP;
import com.adminlte.services.IPTwentyfirstService;

@Controller
@RequestMapping("/admin/IP-Twenty-First")
public class IPTwentyfirstController {
	@Autowired
	private IPTwentyfirstService ipTwentyFirstService;
	
	@GetMapping("")
	public String getALl(Model model) {
		
		
		List<IP> system=ipTwentyFirstService.getSystem();
		List<IP> management=ipTwentyFirstService.getManagement();
		List<IP> BizAdmin=ipTwentyFirstService.getBizAdmin();
		List<IP> BizThree=ipTwentyFirstService.getBizThree();
		List<IP> BizFour=ipTwentyFirstService.getBizFour();
		List<IP> Collection=ipTwentyFirstService.getCollection();
		List<IP> Risk=ipTwentyFirstService.getRisk();
		List<IP> Marketing=ipTwentyFirstService.getMarketing();
		List<IP> Assessment=ipTwentyFirstService.getAssessment();
		List<IP> Printer=ipTwentyFirstService.getPrinter();
		List<IP> FingerPrint=ipTwentyFirstService.getFingerPrint();
		List<IP> Phone=ipTwentyFirstService.getPhone();
		List<IP> Switch=ipTwentyFirstService.getSwitch();
		
		model.addAttribute("system",system);
		model.addAttribute("management",management);
		model.addAttribute("BizAdmin",BizAdmin);
		model.addAttribute("BizThree",BizThree);
		model.addAttribute("BizFour",BizFour);
		model.addAttribute("Collection",Collection);
		model.addAttribute("Risk",Risk);
		model.addAttribute("Marketing",Marketing);
		model.addAttribute("Assessment",Assessment);
		model.addAttribute("Printer",Printer);
		model.addAttribute("FingerPrint",FingerPrint);
		model.addAttribute("Phone",Phone);
		model.addAttribute("Switch",Switch);
		
		return "/admin/views/ip-twenty-first-floor";
	}
	
	@RequestMapping("/findById/{id}")
	@ResponseBody
	public IP findById(@PathVariable("id") int id) {
		
		return ipTwentyFirstService.findById(id);
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST,produces={ "application/json"})
	public String updateIP(IP ip) {
		ipTwentyFirstService.update(ip);
		return "redirect:/admin/IP-Twenty-First";
	}
	
	@GetMapping("/delete/{id}")
	public String ReservedIP(@PathVariable("id") int id) {
		ipTwentyFirstService.reserved(id);
		return "redirect:/admin/IP-Twenty-First";
	}
	@GetMapping("/excel/IP.xlsx")
	public void exportToExcel(HttpServletResponse respone) throws Exception {
		List<IP> ips=ipTwentyFirstService.getAll();
		String sheetname="IP-21st-Floor";
		//System.out.print(devices);
		respone.setContentType("application/actet-stream");
		respone.setHeader("Content-Disposition","attachment;  filename=list-IP-21st.xlsx");
		ByteArrayInputStream inputStream= IPExcelExport.exportExcel(ips,sheetname);
		IOUtils.copy(inputStream,respone.getOutputStream());
	}
	

}
