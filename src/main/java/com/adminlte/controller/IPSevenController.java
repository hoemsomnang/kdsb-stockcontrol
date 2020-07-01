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
import com.adminlte.services.IPSevenService;

@Controller
@RequestMapping("/admin/IP-Seven")
public class IPSevenController {
	
	@Autowired
	private IPSevenService ipSevenService;
	
	@GetMapping("")
	public String getAll(Model model) {
		List<IP> system=ipSevenService.getSystem();
		List<IP> management=ipSevenService.getManagement();
		List<IP> IT=ipSevenService.getIT();
		List<IP> Card=ipSevenService.getCard();
		List<IP> Audit=ipSevenService.getInternalAudit();
		List<IP> Legal=ipSevenService.getLegal();
		List<IP> Recovery=ipSevenService.getRecovery();
		List<IP> Reserved=ipSevenService.getReserved();
		List<IP> Printer=ipSevenService.getPrinter();
		List<IP> FingerPrint=ipSevenService.getFingerPrint();
		List<IP> Phone=ipSevenService.getPhone();
		List<IP> Switch=ipSevenService.getSwitch();
		
		
		model.addAttribute("system",system);
		model.addAttribute("management",management);
		model.addAttribute("IT",IT);
		model.addAttribute("Card",Card);
		model.addAttribute("Audit",Audit);
		model.addAttribute("Legal",Legal);
		model.addAttribute("Recovery",Recovery);
		model.addAttribute("Reserved",Reserved);
		model.addAttribute("Printer",Printer);
		model.addAttribute("FingerPrint",FingerPrint);
		model.addAttribute("Phone",Phone);
		model.addAttribute("Switch",Switch);
		return "/admin/views/ip-seven-floor";
	}
	
	@RequestMapping("/findById/{id}")
	@ResponseBody
	public IP findById(@PathVariable("id") int id) {
		return ipSevenService.findById(id);
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateIP(IP ip) {
		ipSevenService.update(ip);
		return "redirect:/admin/IP-Seven";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		
		ipSevenService.reservedIP(id);
		return "redirect:/admin/IP-Seven";
	}
	
	@GetMapping("/excel/IP.xlsx")
	public void exportToExcel(HttpServletResponse respone) throws Exception {
		List<IP> ips=ipSevenService.getAll();
		String sheetname="IP-7th-Floor";
		//System.out.print(devices);
		respone.setContentType("application/actet-stream");
		respone.setHeader("Content-Disposition","attachment;  filename=list-IP-7th.xlsx");
		ByteArrayInputStream inputStream= IPExcelExport.exportExcel(ips,sheetname);
		IOUtils.copy(inputStream,respone.getOutputStream());
	}

}
