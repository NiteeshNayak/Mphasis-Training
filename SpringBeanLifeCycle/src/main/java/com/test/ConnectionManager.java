package com.test;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class ConnectionManager {
	private boolean isConnected = false;
	
	@PostConstruct
	public void connect() {
		System.out.println("Connecting to external service");
		
		isConnected = true;
		
		System.out.println("Connection established isConnected : "+isConnected);
	}
	
	@PreDestroy
	public void disconnect() {
		System.out.println("Disconnecting from external service..");
		
		isConnected = false;
		
		System.out.println("Connection closed isConnected : "+isConnected);
	}
	
	public void operation() {
		if(isConnected) {
			System.out.println("Performing Operation with active service");
		}else {
			System.out.println("Operation failed not connecting to external service");
		}
	}
}
