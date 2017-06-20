package com.kedu.notice.dto;

import java.sql.Date;

public class NoticeDto {
	
	private String	notice_no;
	private String	notice_title;
	private String	notice_content;
	private String	emp_id;
	private Date	res_dt;
	private Date	update_dt;
	private int		readcount;
	
	public String getNotice_no() {
		return notice_no;
	}
	
	public void setNotice_no(String notice_no) {
		this.notice_no = notice_no;
	}
	
	public String getNotice_title() {
		return notice_title;
	}
	
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	
	public String getNotice_content() {
		return notice_content;
	}
	
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	
	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	public Date getRes_dt() {
		return res_dt;
	}

	public void setRes_dt(Date res_dt) {
		this.res_dt = res_dt;
	}

	public Date getUpdate_dt() {
		return update_dt;
	}

	public void setUpdate_dt(Date update_dt) {
		this.update_dt = update_dt;
	}
	
	public int getReadcount() {
		return readcount;
	}
	
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	@Override
	public String toString() {
		return "NoticeDto [notice_no=" + notice_no + ", notice_title=" + notice_title + ", notice_content="
				+ notice_content + ", emp_id=" + emp_id + ", res_dt=" + res_dt + ", update_dt=" + update_dt
				+ ", readcount=" + readcount + "]";
	}
	
	

}
