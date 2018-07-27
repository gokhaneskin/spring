package com.obss;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


public class WebAppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext ac=new AnnotationConfigWebApplicationContext();
		ac.register(WebConfig.class);
		ac.setServletContext(servletContext);
		DispatcherServlet servlet=new DispatcherServlet(ac);
		ServletRegistration.Dynamic registration=servletContext.addServlet("app", servlet);
		registration.setLoadOnStartup(1);
		registration.addMapping("/");
		System.out.println("Deployed Succesfull");
	}
	
}
