package com.jx372.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jx372.jblog.vo.BlogVo;

@Repository
public class BlogDao {

	@Autowired
	private SqlSession sqlSession;
	
	public int insertBoard(BlogVo vo) {
		// TODO Auto-generated method stub
		System.out.println("[UserDao] BoardVo = " + vo);
		int count =sqlSession.insert("blog.insert",vo);
		return count;
	}
	public int update(BlogVo vo) {
		// TODO Auto-generated method stub
		
		int count =sqlSession.update("blog.update",vo);
		
		return count;
	}
	public BlogVo getBasic(String userid) {
		// TODO Auto-generated method stub
		
		BlogVo vo = sqlSession.selectOne("blog.selectBasic",userid);
		System.out.println(vo);
		return vo;
		
	}

}
