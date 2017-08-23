package com.derek.servlet;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by qux on 23/8/17.
 */
public class OtherServeltInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {
        ServletRegistration.Dynamic otherServlet = servletContext.addServlet("otherServlet", OtherServlet.class);
        otherServlet.addMapping("/other/*");

//        FilterRegistration.Dynamic logFilter = servletContext.addFilter("logFilter", LogFilter.class);
//        logFilter.addMappingForUrlPatterns(null, false, "/*");
    }
}
