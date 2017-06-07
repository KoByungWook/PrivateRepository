package com.mycompany.myapp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.myapp.dto.PhotoBoard;
import com.mycompany.myapp.dto.PhotoBoardMember;
import com.mycompany.myapp.service.PhotoBoardService;

@Controller
public class HomeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private PhotoBoardService service;
	
	@Autowired
	private ServletContext servletContext;
	
	@RequestMapping("/")
	public String home() {
		LOGGER.info("실행");
		return "home";
	}
	
	@RequestMapping("/home")
	public String home2() {
		LOGGER.info("실행");
		return "redirect:/";
	}
	
	@RequestMapping("/main/mainBoard")
	public String mainBoard(@RequestParam(defaultValue="1")int pageNo, Model model, HttpServletRequest request) {
		LOGGER.info("실행");
		// 한 페이지를 구성하는 행의 개수
		int rowsPerPage = 5;
		// 한 그룹을 구성하는 페이지 수
		int pagesPerGroup = 5;
		// 총 행수
		int totalRows = service.boardTotalRows();
		// 전체 페이지 수
		int totalPageNo = (totalRows / rowsPerPage) + ((totalRows % rowsPerPage != 0) ? 1 : 0);
		// 전체 그룹 수
		int totalGroupNo = (totalPageNo / pagesPerGroup) + ((totalPageNo % pagesPerGroup != 0) ? 1 : 0);
		// 현재 그룹
		int groupNo = (pageNo - 1) / pagesPerGroup + 1;
		// 현재 그룹의 시작 페이지 번호
		int startPageNo = (groupNo - 1) * pagesPerGroup + 1;
		// 현재 그룹의 끝 페이지 번호
		int endPageNo = startPageNo + pagesPerGroup - 1;
		if (groupNo == totalGroupNo) {
			endPageNo = totalPageNo;
		}
		
		List<PhotoBoard> list = service.boardListPage(pageNo, rowsPerPage);
		
		model.addAttribute("list", list);
		model.addAttribute("pagesPerGroup", pagesPerGroup);
		model.addAttribute("totalPageNo", totalPageNo);
		model.addAttribute("totalGroupNo", totalGroupNo);
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
		model.addAttribute("pageNo", pageNo);

		HttpSession session = request.getSession(true);
		session.setAttribute("board", null);
		
		return "main/mainBoard";
	}
	
	@RequestMapping("/main/mainMemberImage")
	public void mainMemberImage(HttpServletRequest request, HttpServletResponse response, @RequestHeader("User-Agent") String userAgent) throws Exception {
		
		HttpSession session = request.getSession(true);
		PhotoBoardMember member = (PhotoBoardMember) session.getAttribute("member");
		
		if(member.getMsavedfilename() == null) {
			return;
		}
		
		String fileName = member.getMsavedfilename();
		String encodingFileName;

		if(userAgent.contains("MSIE") || userAgent.contains("Trident") || userAgent.contains("Edge")) {
			encodingFileName = URLEncoder.encode(fileName, "UTF-8");
		} else {
			encodingFileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");				
		}
		
		response.addHeader("Content-Disposition", "attachment; filename=\"" + encodingFileName + "\"");
		response.addHeader("Content-Type", member.getMfilecontent());
		
		File file = new File(servletContext.getRealPath("/WEB-INF/upload/" + fileName));
		long fileSize = file.length();
		response.addHeader("Content-Length", String.valueOf(fileSize));
		
		OutputStream os = response.getOutputStream();
		FileInputStream fis = new FileInputStream(file);
		FileCopyUtils.copy(fis, os);
		os.flush();
		fis.close();
		os.close();
	}
	
	@RequestMapping("/main/photoThumbnail")
	public void photoThumbnail(@RequestParam int bno, HttpServletResponse response, @RequestHeader("User-Agent") String userAgent) throws Exception {
		PhotoBoard board = service.getBoard(bno);
		
		String fileName = board.getBsavedfilename();
		String encodingFileName;

		if(userAgent.contains("MSIE") || userAgent.contains("Trident") || userAgent.contains("Edge")) {
			encodingFileName = URLEncoder.encode(fileName, "UTF-8");
		} else {
			encodingFileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");				
		}
		
		response.addHeader("Content-Disposition", "attachment; filename=\"" + encodingFileName + "\"");
		response.addHeader("Content-Type", board.getBfilecontent());
		
		File file = new File(servletContext.getRealPath("/WEB-INF/upload/" + fileName));
		long fileSize = file.length();
		response.addHeader("Content-Length", String.valueOf(fileSize));
		
		OutputStream os = response.getOutputStream();
		FileInputStream fis = new FileInputStream(file);
		FileCopyUtils.copy(fis, os);
		os.flush();
		fis.close();
		os.close();
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinGet() {
		LOGGER.info("실행");
		return "join";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String joinPost(PhotoBoardMember member) throws Exception {
		LOGGER.info("실행");
		
		member.setMoriginalfilename(member.getMattach().getOriginalFilename());
		
		member.setMfilecontent(member.getMattach().getContentType());
		
		String fileName = new Date().getTime() +"-"+ member.getMoriginalfilename();
		member.setMsavedfilename(fileName);
		
		String realPath = servletContext.getRealPath("/WEB-INF/upload/" + fileName);
		File file = new File(realPath);
		member.getMattach().transferTo(file);
		
		service.memberJoin(member);
		return "redirect:/";
	}
	
	@RequestMapping("/checkLogin")
	public String checkLogin(String mid, String mpassword, HttpServletRequest request, Model model) {
		LOGGER.info("실행");
		String result = service.checkMid(mid);
		PhotoBoardMember member = service.getMember(mid);
		HttpSession session = request.getSession(true);
		
		if(result.equals("success")) {
			result = service.checkMpassword(mid, mpassword);
		}
		
		model.addAttribute("result", result);
		model.addAttribute("member", member);
		session.setAttribute("member", member);
		return "checkLogin";
	}
	
	@RequestMapping("/main/checkMid")
	public String checkMid(String mpassword, HttpServletRequest request, Model model) {
		LOGGER.info("실행");
		HttpSession session = request.getSession();
		PhotoBoardMember member = (PhotoBoardMember)session.getAttribute("member");
		
		String mid = member.getMid();
	
		String result = service.checkMpassword(mid, mpassword);
		LOGGER.info(result);
		model.addAttribute("result", result);
		model.addAttribute("member", member);
		return "main/checkMid";
	}

	
	@RequestMapping("/main/memberDetail")
	public String memberDetail(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(true);
		PhotoBoardMember member = (PhotoBoardMember)session.getAttribute("member");
		LOGGER.info("실행");
		LOGGER.info(member.getMid());
		model.addAttribute("member", member);
		return "main/memberDetail";
	}
	
	@RequestMapping(value="/main/memberUpdate", method=RequestMethod.GET)
	public String memberUpdateGet(String mid, Model model) {
		LOGGER.info("실행");
		PhotoBoardMember member = service.getMember(mid);
		model.addAttribute("member", member);
		return "main/memberUpdate";
	}
	
	@RequestMapping(value="/main/memberUpdate", method=RequestMethod.POST)
	public String memberUpdatePost(HttpServletRequest request, PhotoBoardMember member) throws IllegalStateException, IOException {
		LOGGER.info("실행");
		if(!member.getMattach().isEmpty()) {
			//첨부 파일에 대한 정보를 컬럼값으로 설정
			member.setMoriginalfilename(member.getMattach().getOriginalFilename());
			
			LOGGER.info(member.getMattach().getContentType());
			member.setMfilecontent(member.getMattach().getContentType());
			
			String fileName = new Date().getTime() +"-"+ member.getMoriginalfilename();
			member.setMsavedfilename(fileName);
			
			//첨부된 파일을 서버 로컬 시스템에 저장
			String realPath = servletContext.getRealPath("/WEB-INF/upload/");
			File file = new File(realPath + fileName);
			member.getMattach().transferTo(file);
		}
		
		service.memberUpdate(member);
		
		member = service.getMember(member.getMid());
		HttpSession session = request.getSession(true);
		session.setAttribute("member", member);
		
		return "redirect:/main/memberDetail?mid=" + member.getMid();
	}
	
	@RequestMapping("main/logOut")
	public String logOut(HttpServletRequest request) {
		LOGGER.info("실행");
		HttpSession session = request.getSession(true);
		session.setAttribute("member", null);
		return "redirect:/";
	}
	
	@RequestMapping(value="/main/photoUpLoad", method=RequestMethod.GET)
	public String photoUpLoadGet() {
		LOGGER.info("실행");
		return "main/photoUpLoad";
	}
	
	@RequestMapping(value="/main/photoUpLoad", method=RequestMethod.POST)
	public String photoUpLoadPost(PhotoBoard board) throws Exception {
		LOGGER.info("실행");
		
		board.setBoriginalfilename(board.getBattach().getOriginalFilename());
		
		board.setBfilecontent(board.getBattach().getContentType());
		
		String fileName = new Date().getTime() +"-"+ board.getBoriginalfilename();
		board.setBsavedfilename(fileName);
		
		String realPath = servletContext.getRealPath("/WEB-INF/upload/" + fileName);
		File file = new File(realPath);
		board.getBattach().transferTo(file);
		
		service.boardWrite(board);
		
		return "redirect:/main/mainBoard";
	}
	
	@RequestMapping("/main/photoDetail")
	public String photoDetail(int pageNo, int bno, Model model, HttpServletRequest request) {
		LOGGER.info("실행");
		
		PhotoBoard board = service.getBoardDetail(bno);
		model.addAttribute("board", board);
		model.addAttribute("pageNo", pageNo);
		
		HttpSession session = request.getSession(true);
		session.setAttribute("board", board);
		
		return "main/photoDetail";
	}
	
	@RequestMapping("/main/photoImageDetail")
	public void photoImageDetail(@RequestParam int bno, HttpServletResponse response, @RequestHeader("User-Agent") String userAgent) throws Exception {
		
		PhotoBoard board = service.getBoard(bno);
		String fileName = board.getBsavedfilename();
		String encodingFileName;
		
		if(userAgent.contains("MSIE") || userAgent.contains("Trident") || userAgent.contains("Edge")) {
			encodingFileName = URLEncoder.encode(fileName, "UTF-8");
		} else {
			encodingFileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");				
		}
		
		response.addHeader("Content-Disposition", "attachment; filename=\"" + encodingFileName + "\"");
		response.addHeader("Content-Type", board.getBfilecontent());
		
		File file = new File(servletContext.getRealPath("/WEB-INF/upload/" + fileName));
		long fileSize = file.length();
		response.addHeader("Content-Length", String.valueOf(fileSize));
		
		OutputStream os = response.getOutputStream();
		FileInputStream fis = new FileInputStream(file);
		FileCopyUtils.copy(fis, os);
		os.flush();
		fis.close();
		os.close();
	}
	
	@RequestMapping("/main/checkBid")
	public String checkBid(int bno, String bid, Model model, HttpServletRequest request) {
		LOGGER.info("실행");
		HttpSession session = request.getSession(true);
		PhotoBoardMember member = (PhotoBoardMember)session.getAttribute("member");
		
		String result = service.boardCheckMid(bid, member.getMid());
		
		LOGGER.info(bid + " " + member.getMid());
		model.addAttribute("result", result);
		return "main/checkBid";
	}
	
	@RequestMapping(value="/main/photoUpdate", method=RequestMethod.GET)
	public String photoUpdateGet(int pageNo, int bno, Model model) {
		LOGGER.info("실행");
		PhotoBoard board = service.getBoard(bno);
		model.addAttribute("board", board);
		model.addAttribute("pageNo", pageNo);
		return "main/photoUpdate";
	}
	
	@RequestMapping(value="/main/photoUpdate", method=RequestMethod.POST)
	public String photoUpdatePost(int pageNo, PhotoBoard board) throws IllegalStateException, IOException {
		LOGGER.info("실행");
		if(!board.getBattach().isEmpty()) {
			//첨부 파일에 대한 정보를 컬럼값으로 설정
			board.setBoriginalfilename(board.getBattach().getOriginalFilename());
			
			LOGGER.info(board.getBattach().getContentType());
			board.setBfilecontent(board.getBattach().getContentType());
			
			String fileName = new Date().getTime() +"-"+ board.getBoriginalfilename();
			board.setBsavedfilename(fileName);
			
			//첨부된 파일을 서버 로컬 시스템에 저장
			String realPath = servletContext.getRealPath("/WEB-INF/upload/");
			File file = new File(realPath + fileName);
			board.getBattach().transferTo(file);
		}
		
		service.boardUpdate(board);
		return "redirect:/main/photoDetail?pageNo=" + pageNo +"&bno=" + board.getBno();
	}
	
	@RequestMapping("/main/photoDelete")
	public String photoDelete(int bno) {
		LOGGER.info("실행");
		service.boardDelete(bno);
		return "redirect:/main/mainBoard";
	}
}
