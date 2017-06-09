package com.jx372.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jx372.jblog.vo.PostVo;
import com.jx372.jblog.vo.UserVo;

@Repository
public class PostDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public PostVo get(UserVo uservo)
	{
		System.out.println("uservo"+uservo);
		PostVo postvo=sqlSession.selectOne("post.SelectPostNo", uservo);
		System.out.println(postvo);
		return postvo;
	}

}
