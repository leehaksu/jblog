package com.jx372.jblog.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jx372.jblog.service.BlogService;
import com.jx372.jblog.vo.BlogVo;
import com.jx372.jblog.vo.UserVo;

@Controller
@RequestMapping("")
public class BlogController {

	@Autowired
	private BlogService blogService;

	@RequestMapping({"/{userid}/{postNo}"})
	public String main(@PathVariable String userid,@PathVariable Optional<Long> postNo,Model model) {
		System.out.println("[controller main]"+userid);
		//그냥 메인화면 보여주는 부분 구현 필요
		BlogVo vo= blogService.getBasic(userid);
		System.out.println("[controller main]"+vo);
		model.addAttribute("BlogVo", vo);
		return "/blog/blog-main";
	}

	@RequestMapping(value = "/{userid}/admin/basic", method = RequestMethod.GET)
	public String admin(@PathVariable String userid,HttpSession authUser,UserVo uservo,Model model) {
		System.out.println("[controller admin]"+userid);
		BlogVo vo= blogService.getBasic(userid);
		System.out.println("[controller admin]"+vo);
		model.addAttribute("BlogVo", vo);
		return "/blog/blog-admin-basic";
		
	}

	@RequestMapping(value = "/{userid}/admin/basic", method = RequestMethod.POST)
	public String admin(@RequestParam(value="title", required=true, defaultValue="Spring의 이야기") String title, @RequestParam("logo-file") MultipartFile file, Model model,
			BlogVo vo,HttpSession authUser) {
		System.out.println(title + file);
		UserVo uservo=(UserVo) authUser.getAttribute("authUser");
		System.out.println(uservo);
		vo.setNo(uservo.getNo());
		vo.setTitle(title);
		System.out.println(vo);
		vo= blogService.restore(vo,file);
		model.addAttribute("BlogVo", vo);
		return "/blog/blog-main";
	}

}
