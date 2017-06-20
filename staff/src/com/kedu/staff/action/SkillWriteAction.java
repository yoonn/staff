package com.kedu.staff.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.common.Action;
import com.kedu.staff.dao.SkillDao;
import com.kedu.staff.dto.SkillDto;

public class SkillWriteAction implements Action{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SkillDto skDto = new SkillDto();
		skDto.setEmp_no(request.getParameter("emp_no"));
		skDto.setSkill_no(request.getParameter("skill_no"));
		skDto.setSkill_level(request.getParameter("skill_level"));
		
		System.out.println(skDto);
		
		SkillDao skDao = SkillDao.getInstance();
		skDao.insertSkill(skDto);
		
	}
}
