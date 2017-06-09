package com.jx372.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jx372.jblog.repository.PostDao;
import com.jx372.jblog.vo.PostVo;
import com.jx372.jblog.vo.UserVo;

@Service
public class PostService {
	@Autowired
	private PostDao postDao;
	
	public Long getPostNo(UserVo uservo)
	{
		PostVo vo = postDao.get(uservo);
		System.out.println(vo);
		
		if(vo==null)
		{
			return null;
		}
		return vo.getNo();
	}
}
