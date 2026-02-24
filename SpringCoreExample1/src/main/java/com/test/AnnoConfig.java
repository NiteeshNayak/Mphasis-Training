package com.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Configuration
public class AnnoConfig {

	@Bean
	@Scope(scopeName = "singleton" , value = "", proxyMode = ScopedProxyMode.DEFAULT)
	public BookDetails getBookDt() {
		return new BookDetails();
	}
	
	@Bean
	public Book getBook() {
		return new Book();
	}
}
