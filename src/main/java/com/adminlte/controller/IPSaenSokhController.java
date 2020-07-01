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
import com.adminlte.services.IPSaenSokhService;

@Controller
@RequestMapping("/admin/IP-SaenSokh")
public class IPSaenSokhController {
	
	@Autowired
	private IPSaenSokhService ipSaenSokhService;
	
	@GetMapping("")
	public String getAll(Model model) {
		List<IP> system=ipSaenSokhService.getSystem();
		List<IP> management=ipSaenSokhService.getManagement();
		List<IP> Staffs=ipSaenSokhService.getStaff();
		List<IP> Printer=ipSaenSokhService.getPrinter();
		List<IP> FingerPrint=ipSaenSokhService.getFingerPrint();
		List<IP> Phone=ipSaenSokhService.getPhone();
		List<IP> Switch=ipSaenSokhService.getSwitch();
		
		
		
		model.addAttribute("system",system);
		model.addAttribute("management",management);
		model.addAttribute("Staffs",Staffs);
		model.addAttribute("Printer",Printer);
		model.addAttribute("FingerPrint",FingerPrint);
		model.addAttribute("Phone",Phone);
		model.addAttribute("Switch",Switch);
		
		return "/admin/views/ip-saensokh";
	}
	
	@RequestMapping("/findById/{id}")
	@ResponseBody()
	public IP findById(@PathVariable("id") int id) {
		return ipSaenSokhService.findById(id);
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateIP(IP ip) {
		ipSaenSokhService.update(ip);
		return "redirect:/admin/IP-SaenSokh";
	}
	
	@RequestMapping("/delete/{id}")
	public String reservedIP(@PathVariable("id") int id) {
	    ipSaenSokhService.reservedIP(id);
		return "redirect:/admin/IP-SaenSokh";
	}
	
	@RequestMapping("/excel/IP.xlsx")
	public void exportToExcel(HttpServletResponse respone) throws Exception{
		List<IP> ips=ipSaenSokhService.getAll();
		String sheetname="IP-SaenSokh";
		respone.setContentType("application/actet-stream");
		respone.setHeader("Content-Disposition","attachment;  filename=list-IP-SaenSokh.xlsx");
		ByteArrayInputStream inputStream= IPExcelExport.exportExcel(ips,sheetname);
		IOUtils.copy(inputStream,respone.getOutputStream());
	}
	

}
