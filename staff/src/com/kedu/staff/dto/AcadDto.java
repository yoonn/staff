package com.kedu.staff.dto;

import java.sql.Date;

public class AcadDto {

	private String	emp_no;
	private String	acad_level_no;
	private int		emp_acad_seq;
	private String	acad_state_no;
	private String	acad_nm;
	private	String	major_nm;
	private Date	enter_dt;
	private Date	graduation_dt;
	private	String	certificate_img_path;
	private float	grade;
	private float	perfect_grade;
	
	
	public String getEmp_no() {
		return emp_no;
	}
	
	public void setEmp_no(String emp_no) {
		this.emp_no = emp_no;
	}
	
	public String getAcad_level_no() {
		return acad_level_no;
	}
	
	public void setAcad_level_no(String acad_level_no) {
		this.acad_level_no = acad_level_no;
	}
	
	public int getEmp_acad_seq() {
		return emp_acad_seq;
	}
	
	public void setEmp_acad_seq(int emp_acad_seq) {
		this.emp_acad_seq = emp_acad_seq;
	}
	
	public String getAcad_state_no() {
		return acad_state_no;
	}
	
	public void setAcad_state_no(String acad_state_no) {
		this.acad_state_no = acad_state_no;
	}
	
	public String getAcad_nm() {
		return acad_nm;
	}
	
	public void setAcad_nm(String acad_nm) {
		this.acad_nm = acad_nm;
	}
	
	public String getMajor_nm() {
		return major_nm;
	}
	
	public void setMajor_nm(String major_nm) {
		this.major_nm = major_nm;
	}
	
	public Date getEnter_dt() {
		return enter_dt;
	}
	
	public void setEnter_dt(Date enter_dt) {
		this.enter_dt = enter_dt;
	}
	
	public Date getGraduation_dt() {
		return graduation_dt;
	}
	
	public void setGraduation_dt(Date graduation_dt) {
		this.graduation_dt = graduation_dt;
	}
	
	public String getCertificate_img_path() {
		return certificate_img_path;
	}
	
	public void setCertificate_img_path(String certificate_img_path) {
		this.certificate_img_path = certificate_img_path;
	}

	public float getGrade() {
		return grade;
	}

	public void setGrade(float grade) {
		this.grade = grade;
	}
	
	public float getPerfect_grade() {
		return perfect_grade;
	}

	public void setPerfect_grade(float perfect_grade) {
		this.perfect_grade = perfect_grade;
	}

	@Override
	public String toString() {
		return "AcadDto [emp_no=" + emp_no + ", acad_level_no=" + acad_level_no + ", emp_acad_seq=" + emp_acad_seq
				+ ", acad_state_no=" + acad_state_no + ", acad_nm=" + acad_nm + ", major_nm=" + major_nm + ", enter_dt="
				+ enter_dt + ", graduation_dt=" + graduation_dt + ", certificate_img_path=" + certificate_img_path
				+ ", grade=" + grade + ", perfect_grade=" + perfect_grade + "]";
	}
	
	
}
