package com.test;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SessionExp")
public class SessionExp extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter  out = response.getWriter();
		
		String usr = request.getParameter("user");
		
		System.out.println("from login servlet...");
		
		
//		Cookie ck = new Cookie("info",usr);
//		
//		response.addCookie(ck);
		
		HttpSession session = request.getSession();
		session.setAttribute("info", usr);
		
		ServletContext ctx = getServletContext();
		
		int t = (int)ctx.getAttribute("tusers");
		
		int c = (int)ctx.getAttribute("cusers");
		
		
		out.println("From login page : "+usr);
		out.println("<br>Total User : "+t);
		out.println("<br>Current User : "+c);
		
		
		out.println("<br><br><a href = 'Logout1'>Logout Here</a>");
	}

}
