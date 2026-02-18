package com.test;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

public class SimpleCallBackHandler implements CallbackHandler{
	
	private final String userName;
	private final String password;
	
	
	public SimpleCallBackHandler(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}


	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		// TODO Auto-generated method stub
		for(Callback cb : callbacks) {
			if(cb instanceof NameCallback) {
				((NameCallback)cb).setName(userName);
			}else if(cb instanceof PasswordCallback) {
				((PasswordCallback)cb).setPassword(password.toCharArray());
			}else {
				throw new UnsupportedCallbackException(cb);
			}
		}
	}
}
