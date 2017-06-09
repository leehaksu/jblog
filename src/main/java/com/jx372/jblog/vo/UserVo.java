package com.jx372.jblog.vo;

public class UserVo {
	private Long no;
	private String name;
	private String id;
	private String passwd;
	private Long PostNo;
	
	public Long getPostNo() {
		return PostNo;
	}
	public void setPostNo(Long postNo) {
		PostNo = postNo;
	}
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return passwd;
	}
	public void setPwd(String passwd) {
		this.passwd = passwd;
	}
	@Override
	public String toString() {
		return "UserVo [no=" + no + ", name=" + name + ", id=" + id + ", passwd=" + passwd + ", PostNo=" + PostNo + "]";
	}

}
