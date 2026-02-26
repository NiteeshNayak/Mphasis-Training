package com.test;

import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class HelloServlet {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/text")
	public String simplePlainTextResponse() {
		return "This is simple restful web service Plain text response";
	}
	
	@GET
	@Produces
	@Path("/html/{debit}")
	public String htmlTextResponse(@PathParam("debit") String card) {
		return "<html><body><h1>Simple RestFul API HTML response card number : "+card+"</h1></body></html>";
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String greetUserResponse(@QueryParam("msg") String msg) {
		return msg;
	}
	
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserDetails> listAllUserData(){
		UserDetails u1 = new UserDetails(1, "rohith","Sha","rs@gmail.com", 950989);
		UserDetails u2 = new UserDetails(2, "karthik","Sapaliga","bs@gmail.com", 95465);
		UserDetails u3 = new UserDetails(3, "yadiyurappa","ba","bsy@gmail.com", 86889);
		
		return List.of(u1, u2, u3);
	}
}
