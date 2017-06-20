package com.kedu.project.dto;

import java.sql.Date;

public class CorpProjDto {

	private String	proj_no;
	private String	proj_nm;
	private String	client;
	private int		price;
	private String	proj_content;
	private Date	res_dt;
	private String	res_emp;
	private Date	start_dt;
	private Date	end_dt;
	private String	update_emp;
	private Date	update_dt;
	
	
	public String getProj_no() {
		return proj_no;
	}
	
	public void setProj_no(String proj_no) {
		this.proj_no = proj_no;
	}
	
	public String getProj_nm() {
		return proj_nm;
	}
	
	public void setProj_nm(String proj_nm) {
		this.proj_nm = proj_nm;
	}
	
	public String getClient() {
		return client;
	}
	
	public void setClient(String client) {
		this.client = client;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getProj_content() {
		return proj_content;
	}
	
	public void setProj_content(String proj_content) {
		this.proj_content = proj_content;
	}
	
	public Date getRes_dt() {
		return res_dt;
	}
	
	public void setRes_dt(Date res_dt) {
		this.res_dt = res_dt;
	}
	
	public String getRes_emp() {
		return res_emp;
	}
	
	public void setRes_emp(String res_emp) {
		this.res_emp = res_emp;
	}
	
	public Date getStart_dt() {
		return start_dt;
	}
	
	public void setStart_dt(Date start_dt) {
		this.start_dt = start_dt;
	}
	
	public Date getEnd_dt() {
		return end_dt;
	}
	
	public void setEnd_dt(Date end_dt) {
		this.end_dt = end_dt;
	}

	public String getUpdate_emp() {
		return update_emp;
	}

	public void setUpdate_emp(String update_emp) {
		this.update_emp = update_emp;
	}

	public Date getUpdate_dt() {
		return update_dt;
	}

	public void setUpdate_dt(Date update_dt) {
		this.update_dt = update_dt;
	}

	@Override
	public String toString() {
		return "CorpProjDto [proj_no=" + proj_no + ", proj_nm=" + proj_nm + ", client=" + client + ", price=" + price
				+ ", proj_content=" + proj_content + ", res_dt=" + res_dt + ", res_emp=" + res_emp + ", start_dt="
				+ start_dt + ", end_dt=" + end_dt + ", update_emp=" + update_emp + ", update_dt=" + update_dt + "]";
	}
	
}
