package com.kedu.staff.dto;

import java.sql.Date;

public class LicDto {

	private String	emp_no;
	private int		lic_seq;
	private	String	lic_nm;
	private String	lic_no;
	private	String	institution;
	private	Date	get_dt;
	private	Date	expiration_dt;
	private	String	certificate_img_path;
	
	
	public String getEmp_no() {
		return emp_no;
	}
	
	public void setEmp_no(String emp_no) {
		this.emp_no = emp_no;
	}
	
	public int getLic_seq() {
		return lic_seq;
	}
	
	public void setLic_seq(int lic_seq) {
		this.lic_seq = lic_seq;
	}
	
	public String getLic_nm() {
		return lic_nm;
	}
	
	public void setLic_nm(String lic_nm) {
		this.lic_nm = lic_nm;
	}
	
	public String getLic_no() {
		return lic_no;
	}

	public void setLic_no(String lic_no) {
		this.lic_no = lic_no;
	}

	public String getInstitution() {
		return institution;
	}
	
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	
	public Date getGet_dt() {
		return get_dt;
	}
	
	public void setGet_dt(Date get_dt) {
		this.get_dt = get_dt;
	}
	
	public Date getExpiration_dt() {
		return expiration_dt;
	}
	
	public void setExpiration_dt(Date expiration_dt) {
		this.expiration_dt = expiration_dt;
	}
	
	public String getCertificate_img_path() {
		return certificate_img_path;
	}
	
	public void setCertificate_img_path(String certificate_img_path) {
		this.certificate_img_path = certificate_img_path;
	}

	@Override
	public String toString() {
		return "LicDto [emp_no=" + emp_no + ", lic_seq=" + lic_seq + ", lic_nm=" + lic_nm + ", lic_no=" + lic_no
				+ ", institution=" + institution + ", get_dt=" + get_dt + ", expiration_dt=" + expiration_dt
				+ ", certificate_img_path=" + certificate_img_path + "]";
	}
	
}
