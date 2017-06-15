package com.mycompany.myapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Exam14AopController {
	@RequestMapping("/aop/exam01")
	public String exam01(HttpSession session) {
		session.setAttribute("mid", "mididid");
		return "aop/exam01";
	}
	
	@RequestMapping("/aop/exam02write")
	public String exam02write() {
		return "aop/exam02";
	}
	
	@RequestMapping("/aop/exam02update")
	public String exam02update() {
		return "aop/exam02";
	}
}
