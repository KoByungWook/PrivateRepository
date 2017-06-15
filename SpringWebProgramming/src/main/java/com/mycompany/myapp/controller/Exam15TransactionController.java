package com.mycompany.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myapp.exception.NoAccountException;
import com.mycompany.myapp.service.Exam15Service;

@Controller
public class Exam15TransactionController {
	@Autowired
	private Exam15Service service;
	
	@RequestMapping(value="/transaction/exam01", method=RequestMethod.GET)
	public String exam01() {
		return "transaction/exam01";
	}
	
	@RequestMapping(value="/transaction/exam01", method=RequestMethod.POST)
	public String exam01(String fromAno, String toAno, int amount) {
		service.transfer(fromAno, toAno, amount);
		return "redirect:/";
	}
	
	/*
	@ExceptionHandler
	public String handleNoAccountException(NoAccountException e, Model model) {
		model.addAttribute("cause", e.getMessage());
		return "transaction/exam02";
	}
	*/
}
