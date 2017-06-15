package com.mycompany.myapp.exception;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
@ControllerAdvice	//컨트롤러 마다 공통으로 발생하는 예외를 처리하는 객체이다
public class NoAccountExceptionHandler {
	@ExceptionHandler
	public String handleNoAccountException(NoAccountException e, Model model) {
		model.addAttribute("cause", e.getMessage());
		return "transaction/exam02";
	}
}
