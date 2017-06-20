package com.kedu.staff.dto;

public class SkillDto {

	private String	emp_no;
	private	String	skill_no;
	private	String	skill_level;
	
	public String getEmp_no() {
		return emp_no;
	}
	
	public void setEmp_no(String emp_no) {
		this.emp_no = emp_no;
	}
	
	public String getSkill_no() {
		return skill_no;
	}
	
	public void setSkill_no(String skill_no) {
		this.skill_no = skill_no;
	}
	
	public String getSkill_level() {
		return skill_level;
	}
	
	public void setSkill_level(String skill_level) {
		this.skill_level = skill_level;
	}

	@Override
	public String toString() {
		return "SkillDto [emp_no=" + emp_no + ", skill_no=" + skill_no + ", skill_level=" + skill_level + "]";
	}
	
}
