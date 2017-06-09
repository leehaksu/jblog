package com.jx372.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jx372.jblog.vo.UserVo;

public class LogoutInterCeptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession authUser=request.getSession();
		UserVo uservo = (UserVo) authUser.getAttribute("authUser");
		if(uservo==null)
		{
			response.sendRedirect("login");
			return false;
		}
		authUser.removeAttribute("authUser");
		authUser.invalidate();
		
		response.sendRedirect("/jblog/main");
		return false;
	}

}
