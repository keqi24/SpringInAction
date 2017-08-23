package com.derek.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by qux on 23/8/17.
 */
public class LogFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        PrintWriter writer = response.getWriter();
        writer.write("LogFilter message");

        System.out.println("Log filter");
        chain.doFilter(request, response);
    }

    public void destroy() {

    }
}
