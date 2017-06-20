package com.kedu.staff.action;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.common.Action;
import com.kedu.staff.dao.CarDao;
import com.kedu.staff.dto.CarDto;

public class CarWriteAction implements Action{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CarDto cDto = new CarDto();
		
		cDto.setEmp_no(request.getParameter("emp_no"));
		cDto.setCorp_nm(request.getParameter("corp_nm"));
		cDto.setDept_nm(request.getParameter("dept_nm"));
		cDto.setRank_nm(request.getParameter("rank_nm"));
		cDto.setEmp_role(request.getParameter("emp_role"));
		cDto.setEnter_dt(Date.valueOf(request.getParameter("enter_dt")));
		cDto.setRetire_dt(Date.valueOf(request.getParameter("retire_dt")));
		cDto.setCertificate_img_path(request.getParameter("certificate_img_path"));
		cDto.setEmp_sal(Integer.parseInt(request.getParameter("emp_sal")));
		
		CarDao cDao = CarDao.getInstance();
		cDao.insertCar(cDto);
		
	}
}
