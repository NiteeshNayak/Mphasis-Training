package com.test;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;

@WebFilter("/SessionExp")
public class MyFilter extends HttpFilter {
    
   
	public void destroy() {
		System.out.println("Destroy");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("Before Servlet Pre Filter");
		chain.doFilter(request, response);
		System.out.println("After Servlet Post Filter");
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Init()");
	}

}
