package com.jx372.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jx372.jblog.service.PostService;
import com.jx372.jblog.service.UserService;
import com.jx372.jblog.vo.UserVo;

public class LoginInterCeptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		UserVo uservo = new UserVo();
		uservo.setId(request.getParameter("id"));
		uservo.setPwd(request.getParameter("passwd"));
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		UserService userService = ac.getBean(UserService.class);
		uservo = userService.login(uservo);
		if (uservo == null) {
			response.sendRedirect("login");
			return false;
		}
		ApplicationContext ac2 = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		PostService postService = ac2.getBean(PostService.class);
		Long PostNo = postService.getPostNo(uservo);
		if (PostNo == null) {
			uservo.setPostNo(0L);
		} else {
			uservo.setPostNo(PostNo);
		}
		HttpSession authUser = request.getSession();
		authUser.setAttribute("authUser", uservo);
		response.sendRedirect("/jblog/main");
		return false;
	}

}
