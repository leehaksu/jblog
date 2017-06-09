package com.jx372.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jx372.jblog.service.BlogService;
import com.jx372.jblog.service.CategoryService;
import com.jx372.jblog.service.UserService;
import com.jx372.jblog.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join()
	{
		return "user/join";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(@ModelAttribute UserVo uservo)
	{
		Long no=userService.join(uservo);
		System.out.println("[Controller]no : " +no);
		blogService.join(no);
		categoryService.join(no);
		
		return "redirect:/user/joinsuccess";
	}
	@RequestMapping(value="/joinsuccess", method=RequestMethod.GET)
	public String joinSuccess()
	{
		return "/user/joinsuccess";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login()
	{
		return "/user/login";
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute UserVo uservo)
	{
		
		return "/user/login";
	}

}
