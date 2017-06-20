package com.kedu.staff.action;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.common.Action;
import com.kedu.staff.dao.AcadDao;
import com.kedu.staff.dto.AcadDto;

public class AcadWriteAction implements Action{
	
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AcadDto aDto = new AcadDto();
		
		aDto.setEmp_no(request.getParameter("emp_no"));
		aDto.setAcad_level_no(request.getParameter("acad_level_no"));
		aDto.setAcad_state_no(request.getParameter("acad_state_no"));
		aDto.setAcad_nm(request.getParameter("acad_nm"));
		aDto.setMajor_nm(request.getParameter("major_nm"));
		aDto.setEnter_dt(Date.valueOf(request.getParameter("enter_dt")));
		aDto.setGraduation_dt(Date.valueOf(request.getParameter("graduation_dt")));
		aDto.setCertificate_img_path(request.getParameter("certificate_img_path"));
		aDto.setGrade(Float.parseFloat(request.getParameter("grade")));
		aDto.setPerfect_grade(Float.parseFloat(request.getParameter("perfect_grade")));
		
		AcadDao aDao = AcadDao.getInstance();
		aDao.insertAcad(aDto);
		
	}

}
