package com.jx372.jblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jx372.jblog.service.CategoryService;
import com.jx372.jblog.vo.CategoryVo;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/{userid}/admin/category", method=RequestMethod.GET)
	public String category(@PathVariable String userid,Model model)
	{
		List<CategoryVo> list =categoryService.getList(userid);
		System.out.println(list);
		model.addAttribute("list", list);
		return "/blog/blog-admin-category"; 
	}
	
	@RequestMapping(value="/{userid}/admin/insert",method=RequestMethod.GET)
	public String insert(@PathVariable String userid,BindingResult result,Model model,@ModelAttribute CategoryVo categoryvo)
	{
		System.out.println(userid);
		System.out.println(categoryvo);
		categoryService.insert(userid,categoryvo);
		if(result.hasErrors())
		{
			model.addAllAttributes(result.getModel());
		}
		return "/"+userid+"/admin/category";
	}
	

}
