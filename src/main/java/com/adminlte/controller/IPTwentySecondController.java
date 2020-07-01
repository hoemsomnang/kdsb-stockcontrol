package com.adminlte.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adminlte.Excels.IPExcelExport;
import com.adminlte.models.IP;
import com.adminlte.services.IPTwentysecondService;

@Controller
@RequestMapping("/admin/IP-Twenty-Second")
public class IPTwentySecondController {

	@Autowired
	private IPTwentysecondService ipTwentySecondService;
	
	@RequestMapping("")
	public String getAll(Model model) {
		List<IP> system=ipTwentySecondService.getSystem();
		List<IP> management=ipTwentySecondService.getManagement();
		List<IP> finance=ipTwentySecondService.getFinance();
		List<IP> HR=ipTwentySecondService.getHR();
		List<IP> BizOne=ipTwentySecondService.getBizone();
		List<IP> BizTwo=ipTwentySecondService.getBiztwo();
		List<IP> IPQuest=ipTwentySecondService.getIPquest();
		List<IP> AllCO=ipTwentySecondService.getAllCO();
		List<IP> Printer=ipTwentySecondService.getPrinter();
		List<IP> FingerPrint=ipTwentySecondService.getFingerprint();
		List<IP> Phone=ipTwentySecondService.getPhone();
		List<IP> Switch=ipTwentySecondService.getSwitch();
		
		model.addAttribute("system",system);
		model.addAttribute("management",management);
		model.addAttribute("finance",finance);
		model.addAttribute("HR",HR);
		model.addAttribute("BizOne",BizOne);
		model.addAttribute("BizTwo",BizTwo);
		model.addAttribute("IPQuest",IPQuest);
		model.addAttribute("AllCO",AllCO);
		model.addAttribute("Printer",Printer);
		model.addAttribute("FingerPrinter",FingerPrint);
		model.addAttribute("Phone",Phone);
		model.addAttribute("Switch",Switch);
		return "/admin/views/ip-twenty-second-floor";
	}
	@RequestMapping(value="/delete/{id}")
	public String ReservedIP(@PathVariable("id")int id) {
		ipTwentySecondService.reserved(id);
		return "redirect:/admin/IP-Twenty-Second";
	}
	
	@RequestMapping("/findById/{id}")
	@ResponseBody
	public IP getSingleIP(@PathVariable("id") int id) {
		return ipTwentySecondService.findById(id);
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateIP(IP ip) {
		ipTwentySecondService.update(ip);
		return "redirect:/admin/IP-Twenty-Second";
	}
	
	/*--------- Generate to Excel ---------*/
	@RequestMapping(value="/excel/IP.xlsx")
	public void exportToExecl(HttpServletResponse respone)throws IOException {
		List<IP> ips=ipTwentySecondService.getAll();
		String sheetname="IP-22nd-Floor";
		//System.out.print(devices);
		respone.setContentType("application/actet-stream");
		respone.setHeader("Content-Disposition","attachment;  filename=list-IP-22nd.xlsx");
		ByteArrayInputStream inputStream= IPExcelExport.exportExcel(ips,sheetname);
		IOUtils.copy(inputStream,respone.getOutputStream());
	}
	
}
