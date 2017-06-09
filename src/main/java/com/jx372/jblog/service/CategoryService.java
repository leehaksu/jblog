package com.jx372.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jx372.jblog.repository.CategoryDao;
import com.jx372.jblog.vo.CategoryVo;

@Service
public class CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	public boolean join(Long no) {
		// TODO Auto-generated method stub
		System.out.println("[CategoryBoard]"+no);
		boolean check=categoryDao.insert(no);
		return check;
	}

	public List<CategoryVo> getList(String userid) {
		// TODO Auto-generated method stub
		List<CategoryVo> list =categoryDao.getList(userid);
		return list;
	}

	public boolean insert(String userid, CategoryVo categoryvo) {
		// TODO Auto-generated method stub
		
		boolean check = categoryDao.insert(userid,categoryvo);
		return false;
		
	}

}
