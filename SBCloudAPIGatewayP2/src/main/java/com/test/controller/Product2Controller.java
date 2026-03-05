package com.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product2")
public class Product2Controller {

	@GetMapping("/service1")
	public String product2Service() {
		return new String("This is a simple cloud API service - 2");
	}
}
