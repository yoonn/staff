package com.kedu.staff.dto;

import java.sql.Date;

public class CarDto {

	private String	emp_no;
	private int		emp_career_seq;
	private String	corp_nm;
	private	String	dept_nm;
	private	String	rank_nm;
	private String	emp_role;
	private	Date	enter_dt;
	private Date	retire_dt;
	private String	certificate_img_path;
	private int		emp_sal;
	
	
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
	
	public String getCorp_nm() {
		return corp_nm;
	}
	
	public void setCorp_nm(String corp_nm) {
		this.corp_nm = corp_nm;
	}
	
	public String getDept_nm() {
		return dept_nm;
	}
	
	public void setDept_nm(String dept_nm) {
		this.dept_nm = dept_nm;
	}
	
	public String getRank_nm() {
		return rank_nm;
	}
	
	public void setRank_nm(String rank_nm) {
		this.rank_nm = rank_nm;
	}
	
	public String getEmp_role() {
		return emp_role;
	}
	
	public void setEmp_role(String emp_role) {
		this.emp_role = emp_role;
	}
	
	public Date getEnter_dt() {
		return enter_dt;
	}
	
	public void setEnter_dt(Date enter_dt) {
		this.enter_dt = enter_dt;
	}
	
	public Date getRetire_dt() {
		return retire_dt;
	}
	
	public void setRetire_dt(Date retire_dt) {
		this.retire_dt = retire_dt;
	}
	
	public String getCertificate_img_path() {
		return certificate_img_path;
	}
	
	public void setCertificate_img_path(String certificate_img_path) {
		this.certificate_img_path = certificate_img_path;
	}

	public int getEmp_sal() {
		return emp_sal;
	}

	public void setEmp_sal(int emp_sal) {
		this.emp_sal = emp_sal;
	}

	@Override
	public String toString() {
		return "CarDto [emp_no=" + emp_no + ", emp_career_seq=" + emp_career_seq + ", corp_nm=" + corp_nm + ", dept_nm="
				+ dept_nm + ", rank_nm=" + rank_nm + ", emp_role=" + emp_role + ", enter_dt=" + enter_dt
				+ ", retire_dt=" + retire_dt + ", certificate_img_path=" + certificate_img_path + ", emp_sal=" + emp_sal
				+ "]";
	}
	
}
