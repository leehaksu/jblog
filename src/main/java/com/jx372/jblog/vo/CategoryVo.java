package com.jx372.jblog.vo;

public class CategoryVo {
	private Long category_no;
	private Long no;
	private String name;
	private String content;
	private String reg_date;
	private Long postNo;

	public Long getPostNo() {
		return postNo;
	}

	public void setPostNo(Long postNo) {
		this.postNo = postNo;
	}

	public Long getCategory_no() {
		return category_no;
	}

	public void setCategory_no(Long category_no) {
		this.category_no = category_no;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		return "CategoryVo [category_no=" + category_no + ", no=" + no + ", name=" + name + ", content=" + content
				+ ", reg_date=" + reg_date + ", postNo=" + postNo + "]";
	}
}
