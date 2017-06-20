package com.kedu.staff.action;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.common.Action;
import com.kedu.staff.dao.CarDao;
import com.kedu.staff.dao.CarProjDao;
import com.kedu.staff.dto.CarProjDto;

public class CarProjWriteAction implements Action{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String corp_nm = request.getParameter("corp_nm");
		
		CarDao cDao = CarDao.getInstance();
		int emp_career_seq = Integer.parseInt(cDao.selectSeqbyCorpNm(corp_nm));
		
		System.out.println(emp_career_seq);
		System.out.println(request.getParameter("emp_no"));
		
		CarProjDto cpDto = new CarProjDto();
		
		cpDto.setEmp_no(request.getParameter("emp_no"));
		cpDto.setEmp_career_seq(emp_career_seq);
		cpDto.setRole_nm(request.getParameter("role_nm"));
		cpDto.setProj_nm(request.getParameter("proj_nm"));
		cpDto.setProj_content(request.getParameter("proj_content"));
		cpDto.setStart_dt(Date.valueOf(request.getParameter("start_dt")));
		cpDto.setEnd_dt(Date.valueOf(request.getParameter("end_dt")));
		
		CarProjDao cpDao = CarProjDao.getInstance();
		cpDao.insertCarPorj(cpDto);
		
	}
}
