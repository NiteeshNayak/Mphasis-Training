package com.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product1")
public class Product1Controller {

	@GetMapping("/service1")
	public String product1Service() {
		return "This is simple cloud reactive API service - 1";
	}
	
}
