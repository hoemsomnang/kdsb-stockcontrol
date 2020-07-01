package com.adminlte.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthenticationController {

	@GetMapping("/USERS")
	@ResponseBody
	public String hasha() {
		return "Hasha";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		if(!auth.getPrincipal().equals("anonymousUser")) {
			//System.out.print(auth.getPrincipal());
			return "/admin/";
		}
		System.out.print(auth.getPrincipal());
		return "/admin/login" ;
	}
	
	@GetMapping("/logout")
	public String logoutURL(HttpServletRequest request,HttpServletResponse response) {
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		if(auth !=null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "/admin/login";
	}
}
