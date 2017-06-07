package com.mycompany.myapp.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.mycompany.myapp.dto.PhotoBoardMember;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter {
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession(false);
		
		if(session == null) {
			response.sendRedirect(request.getContextPath()+"/");
			return false;
		}
		
		PhotoBoardMember member = (PhotoBoardMember)session.getAttribute("member");
		
		if(member == null) {
			response.sendRedirect(request.getContextPath()+"/");
			return false;
		}
		
		return true;
	}
}
