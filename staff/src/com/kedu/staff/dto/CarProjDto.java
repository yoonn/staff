package com.kedu.staff.dto;

import java.sql.Date;

public class CarProjDto {

	private String	emp_no;
	private int		emp_career_seq;
	private int		emp_car_proj_seq;
	private String	role_nm;
	private String	proj_nm;
	private String	proj_content;
	private Date	start_dt;
	private Date	end_dt;
	
	public String getEmp_no() {
		return emp_no;
	}
	
	public void setEmp_no(String emp_no) {
		this.emp_no = emp_no;
	}
	
	public int getEmp_career_seq() {
		return emp_career_seq;
	}
	
	public void setEmp_career_seq(int emp_career_seq) {
		this.emp_career_seq = emp_career_seq;
	}
	
	public int getEmp_car_proj_seq() {
		return emp_car_proj_seq;
	}

	public void setEmp_car_proj_seq(int emp_car_proj_seq) {
		this.emp_car_proj_seq = emp_car_proj_seq;
	}

	public String getRole_nm() {
		return role_nm;
	}
	
	public void setRole_nm(String role_nm) {
		this.role_nm = role_nm;
	}
	
	public String getProj_nm() {
		return proj_nm;
	}
	
	public void setProj_nm(String proj_nm) {
		this.proj_nm = proj_nm;
	}
	
	public String getProj_content() {
		return proj_content;
	}
	
	public void setProj_content(String proj_content) {
		this.proj_content = proj_content;
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

	@Override
	public String toString() {
		return "CarProjDto [emp_no=" + emp_no + ", emp_career_seq=" + emp_career_seq + ", emp_car_proj_seq="
				+ emp_car_proj_seq + ", role_nm=" + role_nm + ", proj_nm=" + proj_nm + ", proj_content=" + proj_content
				+ ", start_dt=" + start_dt + ", end_dt=" + end_dt + "]";
	}
	
}
