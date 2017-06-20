package com.kedu.staff.dto;

import java.sql.Date;

public class StaffDto {

	private String	emp_no;
	private String	dept_no;
	private String	rank_no;
	private Double	emp_sal;
	private String	emp_nm;
	private String	emp_id;
	private String	emp_pwd;
	private Double	res_no;
	private String	zipcode;
	private String	emp_addr;
	private String	emp_detail_addr;
	private Double	emp_mobile;
	private Double	emp_office;
	private	Date	enter_dt;
	private Date	retire_dt;
	private Date	res_dt;
	private String	res_emp;
	private Date	update_dt;
	private String	update_emp;
	private Integer	notice_mgr;
	private String	file_save_url;
	private String	file_request_url;
	
	public String getEmp_no() {
		return emp_no;
	}
	
	public void setEmp_no(String emp_no) {
		this.emp_no = emp_no;
	}
	
	public String getDept_no() {
		return dept_no;
	}
	
	public void setDept_no(String dept_no) {
		this.dept_no = dept_no;
	}
	
	public String getRank_no() {
		return rank_no;
	}
	
	public void setRank_no(String rank_no) {
		this.rank_no = rank_no;
	}
	
	public Double getEmp_sal() {
		return emp_sal;
	}
	
	public void setEmp_sal(Double emp_sal) {
		this.emp_sal = emp_sal;
	}
	
	public String getEmp_nm() {
		return emp_nm;
	}
	
	public void setEmp_nm(String emp_nm) {
		this.emp_nm = emp_nm;
	}
	
	public String getEmp_id() {
		return emp_id;
	}
	
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	
	public String getEmp_pwd() {
		return emp_pwd;
	}
	
	public void setEmp_pwd(String emp_pwd) {
		this.emp_pwd = emp_pwd;
	}
	
	public Double getRes_no() {
		return res_no;
	}
	
	public void setRes_no(Double res_no) {
		this.res_no = res_no;
	}
	
	public String getZipcode() {
		return zipcode;
	}
	
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	public String getEmp_addr() {
		return emp_addr;
	}
	
	public void setEmp_addr(String emp_addr) {
		this.emp_addr = emp_addr;
	}
	
	public String getEmp_detail_addr() {
		return emp_detail_addr;
	}
	
	public void setEmp_detail_addr(String emp_detail_addr) {
		this.emp_detail_addr = emp_detail_addr;
	}
	
	public Double getEmp_mobile() {
		return emp_mobile;
	}
	
	public void setEmp_mobile(Double emp_mobile) {
		this.emp_mobile = emp_mobile;
	}
	
	public Double getEmp_office() {
		return emp_office;
	}
	
	public void setEmp_office(Double emp_office) {
		this.emp_office = emp_office;
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
	
	public Date getUpdate_dt() {
		return update_dt;
	}
	
	public void setUpdate_dt(Date update_dt) {
		this.update_dt = update_dt;
	}
	
	public String getUpdate_emp() {
		return update_emp;
	}
	
	public void setUpdate_emp(String update_emp) {
		this.update_emp = update_emp;
	}
	
	public Integer getNotice_mgr() {
		return notice_mgr;
	}
	
	public void setNotice_mgr(Integer notice_mgr) {
		this.notice_mgr = notice_mgr;
	}

	public String getFile_save_url() {
		return file_save_url;
	}

	public void setFile_save_url(String file_save_url) {
		this.file_save_url = file_save_url;
	}

	public String getFile_request_url() {
		return file_request_url;
	}

	public void setFile_request_url(String file_request_url) {
		this.file_request_url = file_request_url;
	}

	@Override
	public String toString() {
		return "StaffDto [emp_no=" + emp_no + ", dept_no=" + dept_no + ", rank_no=" + rank_no + ", emp_sal=" + emp_sal
				+ ", emp_nm=" + emp_nm + ", emp_id=" + emp_id + ", emp_pwd=" + emp_pwd + ", res_no=" + res_no
				+ ", zipcode=" + zipcode + ", emp_addr=" + emp_addr + ", emp_detail_addr=" + emp_detail_addr
				+ ", emp_mobile=" + emp_mobile + ", emp_office=" + emp_office + ", enter_dt=" + enter_dt
				+ ", retire_dt=" + retire_dt + ", res_dt=" + res_dt + ", res_emp=" + res_emp + ", update_dt="
				+ update_dt + ", update_emp=" + update_emp + ", notice_mgr=" + notice_mgr + ", file_save_url="
				+ file_save_url + ", file_request_url=" + file_request_url + "]";
	}

}
