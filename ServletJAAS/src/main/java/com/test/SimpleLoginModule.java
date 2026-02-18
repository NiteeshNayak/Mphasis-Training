package com.test;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class SimpleLoginModule implements LoginModule{

	private Subject subject;
	
	private CallbackHandler callbackHandler;
	
	private String userName;
	
	private List<String> roles = new ArrayList<>();
	
	private List<UserPrinciple> principals = new ArrayList<>();
	
	
	@Override
	public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState,
			Map<String, ?> options) {
		this.subject = subject;
		this.callbackHandler = callbackHandler;
		
	}

	@Override
	public boolean login() throws LoginException {
		
		NameCallback nameCB = new NameCallback("username");
		PasswordCallback pasCB = new PasswordCallback("password", false);
		
		try {
			callbackHandler.handle(new Callback[] {nameCB,pasCB});
			userName = nameCB.getName();
			String password = new String(pasCB.getPassword());
			
			if("admin".equals(userName) && "java".equals(password)) {
				roles = Arrays.asList("ADMIN","MANAGER");
				return true;
			}else if("user".equals(userName) && "123".equals(password)) {
				roles = Arrays.asList("USER","CUSTOMER");
				return true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean commit() throws LoginException {
		subject.getPrincipals().add(new UserPrinciple(userName));
		
		for(String role : roles) {
			UserPrinciple p = new UserPrinciple(role);
			
			principals.add(p);
			
			subject.getPrincipals().add(p);
		}
		return true;
	}

	@Override
	public boolean abort() throws LoginException {
		
		return false;
	}

	@Override
	public boolean logout() throws LoginException {
		subject.getPrincipals().removeAll(principals);
		return true;
	}
	
}
