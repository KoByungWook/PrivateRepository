package com.mycompany.myapp.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myapp.dto.Music;
import com.mycompany.myapp.service.Service;

@Controller
public class HomeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private Service service;
	@Autowired
	private ServletContext servletContext;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.GET)
	public String uploadGet() {
		return "upload";
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String uploadPost(Music music) throws IllegalStateException, IOException {
		music.setMfilename(music.getMattach().getOriginalFilename());
		String filename = music.getMfilename();
		LOGGER.info(filename);
		
		String realPath = servletContext.getRealPath("/resources/music/");
		music.setMfilepath(realPath);
		LOGGER.info(realPath);
		
		//raspberry pi WAS
		File file = new File(realPath + "/" + filename);
		
		//PC WAS
		//File file = new File(realPath + filename);
		music.getMattach().transferTo(file);
		
		service.musicUpload(music);
		
		return "redirect:/";
	}
	
	@RequestMapping("/download")
	public String download(HttpServletResponse response,
			@RequestHeader("User-Agent") String userAgent) throws Exception {
		List<Music> musicList = service.getList();
		for(int i=0; i<musicList.size(); i++) {
			System.out.println(musicList.get(i).getMfilename());
		}
		
		return "redirect:/";
	}
}
