package com.jx372.jblog.repository;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jx372.jblog.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public Long insert(UserVo uservo)
	{
		System.out.println("[UserDao] uservo = " + uservo);
		sqlSession.insert("user.insert",uservo);
		return uservo.getNo();
	}
	
	public UserVo get(UserVo vo)
	{
		System.out.println("[UserDao] uservo = " + vo);
		UserVo uservo=sqlSession.selectOne("user.get", vo);
		return uservo;
	}

	
}
