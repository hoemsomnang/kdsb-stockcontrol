package com.adminlte.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component("customSuccessHandler")
public class CustomSuccessHanlder implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		System.out.print("Login Success" );
		String targetURL=determineTargetUrl(authentication);
		if(response.isCommitted()) {
			System.out.print("Respone has already been commited."+targetURL);
			
		}
		response.sendRedirect(targetURL);
	}
	private String determineTargetUrl(Authentication auth) {
		Collection<? extends GrantedAuthority> authorites=auth.getAuthorities();
		List<String> roles=new ArrayList<String>();
		for(GrantedAuthority authority: authorites) {
			System.out.print("ROLE"+authority.getAuthority());
			roles.add(authority.getAuthority());
		}
		if(roles.contains("ROLE_ADMIN")) {
			return "/admin/";
		}else if(roles.contains("ROLE_USER")) {
			return "/USERS";
		}else {
			return "/errors/403";
		}
	}

}
