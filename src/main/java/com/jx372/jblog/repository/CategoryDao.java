package com.jx372.jblog.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jx372.jblog.vo.CategoryVo;

@Repository
public class CategoryDao {

	@Autowired
	private SqlSession sqlSession;
	
	public boolean insert(Long no)
	{
		System.out.println(no);
		String title="기타";
		String content=" ";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("no", no);
		map.put("name", title);
		map.put("content",content);
		int count=sqlSession.insert("category.insert", map);
		return count==1;
	}

	public List<CategoryVo> getList(String userid) {
		// TODO Auto-generated method stub
		
		List<CategoryVo> list = sqlSession.selectList("category.getList", userid);
		
		return list;
	}
	
	public boolean insert(String userid,CategoryVo vo)
	{
		System.out.println(userid);
		System.out.println(vo);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userid", userid);
		map.put("name", vo.getName());
		map.put("content", vo.getContent());
		System.out.println(map.toString());
		int count=sqlSession.insert("category.insertCategory", map);
		
		return count==1;
	}
}
