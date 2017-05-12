package com.mycompany.myapp.controller;

import java.io.File;
import java.util.Arrays;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class Exam09FormController {
	@Autowired
	private ServletContext servletContext;
	
	@RequestMapping(value="/form/exam01",method=RequestMethod.GET)
	public String joinForm() {
		return "form/exam01";
	}
	
	@RequestMapping(value="/form/exam01",method=RequestMethod.POST)
	public String join(String mid, String mname, String mpassword, @RequestParam(defaultValue = "0")int mage, String[] mskill, String mbirth) {
		System.out.println("mid: " + mid);
		System.out.println("mname: " + mname);
		System.out.println("mpassword: " + mpassword);
		System.out.println("mage: " + mage);
		System.out.println("mskill: " + Arrays.toString(mskill));
		System.out.println("mbirth: " + mbirth);
		return "form/exam01";
	}
	
	@RequestMapping(value="/form/exam02",method=RequestMethod.GET)
	public String JoinForm2() {
		return "form/exam02";
	}
	@RequestMapping(value="/form/exam02",method=RequestMethod.POST)
	public String Join2(
			String mid,
			String mname,
			String mpassword,
			@RequestParam(defaultValue = "0")int mage,
			String[] mskill,
			String mbirth,
			MultipartFile attach) throws Exception {
		
		//파일 정보 출력
		String fileName = attach.getOriginalFilename();
		String contentType = attach.getContentType();
		long filesize = attach.getSize();
		//파일 서버 하드디스크에 저장
		String realPath = servletContext.getRealPath("/WEB-INF/upload/" + fileName);
		File file = new File(realPath);
		attach.transferTo(file);
		
		System.out.println(fileName);
		System.out.println(contentType);
		System.out.println(filesize);
		
		return "form/exam02";
	}
}
