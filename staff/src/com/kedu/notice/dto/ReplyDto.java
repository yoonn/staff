package com.kedu.notice.dto;

import java.sql.Timestamp;

public class ReplyDto {

	private String	reply_no;
	private String	notice_no;
	private String	emp_id;
	private String	reply_content;
	private Timestamp reply_dt;
	
	public String getReply_no() {
		return reply_no;
	}
	
	public void setReply_no(String reply_no) {
		this.reply_no = reply_no;
	}
	
	public String getNotice_no() {
		return notice_no;
	}
	
	public void setNotice_no(String notice_no) {
		this.notice_no = notice_no;
	}
	
	public String getEmp_id() {
		return emp_id;
	}
	
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	
	public String getReply_content() {
		return reply_content;
	}
	
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	
	public Timestamp getReply_dt() {
		return reply_dt;
	}
	
	public void setReply_dt(Timestamp reply_dt) {
		this.reply_dt = reply_dt;
	}
	
	@Override
	public String toString() {
		return "ReplyDto [reply_no=" + reply_no + ", notice_no=" + notice_no + ", emp_id=" + emp_id + ", reply_content="
				+ reply_content + ", reply_dt=" + reply_dt + "]";
	}
	
}
