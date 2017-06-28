package com.mycompany.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/")
	public String home() {
		return "dashboard";
	}
	
}