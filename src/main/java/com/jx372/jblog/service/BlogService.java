package com.jx372.jblog.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jx372.jblog.repository.BlogDao;
import com.jx372.jblog.vo.BlogVo;

@Service
public class BlogService {
	
	private static final String SAVE_PATH="/uploads";
	private static final String PREFIX_URL="/uploads/images";
	
	@Autowired
	private BlogDao blogDao;
	
	public boolean join(Long no) {
		// TODO Auto-generated method stub
		BlogVo vo = new BlogVo();
		vo.setNo(no);
		vo.setTitle("Spring의 이야기");
		vo.setLogo(PREFIX_URL+"/"+"spring-logo.jpg");
		System.out.println("[Controller]no : " +no);
		int count=blogDao.insertBoard(vo);
		
		return count==1;
	}
	public BlogVo restore(BlogVo vo,MultipartFile multipartFile) {
		try{
		String url= "";
		if(multipartFile.isEmpty()==true)
		{
			return vo;
		}
		
		String orginalFileName=multipartFile.getOriginalFilename();
		String extName= orginalFileName.substring(orginalFileName.lastIndexOf("."),orginalFileName.length());
		Long fileSize = multipartFile.getSize();
		String saveFileName=getSaveFileName(extName);
		writeFile(multipartFile,saveFileName);
		url=PREFIX_URL+"/"+saveFileName;
		vo.setLogo(url);
		blogDao.update(vo);
		return vo;
		}catch(IOException e)
	{
		throw new RuntimeException(); 
	}
		
	}

	private String getSaveFileName(String extName) {
		// TODO Auto-generated method stub
		String fileName="";
		Calendar cal = Calendar.getInstance();
		fileName+=cal.get(Calendar.YEAR);
		fileName+=cal.get(Calendar.MONTH);
		fileName+=cal.get(Calendar.DATE);
		fileName+=cal.get(Calendar.HOUR);
		fileName+=cal.get(Calendar.MINUTE);
		fileName+=cal.get(Calendar.SECOND);
		fileName+=cal.get(Calendar.MILLISECOND);
		fileName+=extName;
		return fileName;
	}
	private void writeFile(MultipartFile multipartFile, String saveFileName) throws IOException {
		// TODO Auto-generated method stub
		byte [] fileData = multipartFile.getBytes();
		FileOutputStream fos = new FileOutputStream(SAVE_PATH+"/"+saveFileName);
		fos.write(fileData);
		fos.close();
	}
	public BlogVo getBasic(String userid)
	{
		BlogVo vo= blogDao.getBasic(userid);
		return vo;
	}
}
