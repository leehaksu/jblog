package com.jx372.jblog.vo;

public class CommentVo {
	
	private Long comment_no;
	private Long no;
	private String content;
	private String reg_date;
	
	public Long getComment_no() {
		return comment_no;
	}
	public void setComment_no(Long comment_no) {
		this.comment_no = comment_no;
	}
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
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
		return "CommentVo [comment_no=" + comment_no + ", no=" + no + ", content=" + content + ", reg_date=" + reg_date
				+ "]";
	}
	
}
