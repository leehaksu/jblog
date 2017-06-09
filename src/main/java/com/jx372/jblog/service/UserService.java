package com.jx372.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jx372.jblog.repository.UserDao;
import com.jx372.jblog.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	

	public Long join(UserVo uservo)
	{
		return userDao.insert(uservo);
	}
	
	public UserVo login(UserVo vo)
	{
		UserVo uservo=userDao.get(vo);
		
		return uservo;
	}
	

	

}
