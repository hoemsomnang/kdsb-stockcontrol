package com.adminlte.controller.configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc

public class ApplicationConfiguration extends WebMvcConfigurerAdapter {
	
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// Front End
		/*
		 * registry.addViewController("/about").setViewName("/about");
		 * registry.addViewController("/contact").setViewName("/contact");
		 * registry.addViewController("/home").setViewName("/home");
		 */
	
		// Back End
		
		registry.addViewController("/admin/").setViewName("/admin/dashboard");
		registry.addViewController("/login").setViewName("/admin/login");
		registry.addViewController("/errors/403").setViewName("/admin/errors/errors");
		//registry.addViewController("/admin/user").setViewName("/admin/user");
		registry.addViewController("/admin/layout").setViewName("/admin/admin-layout");
		
		// Front End
	}
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
               
                "/admin/**",
                "/img/**",
                "/css/**",
                "/js/**")
                .addResourceLocations(
                        
                        "classpath:/static/admin/",	
                        "classpath:/static/img/",
                        "classpath:/static/css/",
                        "classpath:/static/js/");
    }
}
