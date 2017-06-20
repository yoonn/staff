package com.kedu.staff.action;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.common.Action;
import com.kedu.staff.dao.LicDao;
import com.kedu.staff.dto.LicDto;

public class LicWriteAction implements Action{
	
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LicDto lDto = new LicDto();
		lDto.setEmp_no(request.getParameter("emp_no"));
		lDto.setLic_nm(request.getParameter("lic_nm"));
		lDto.setLic_no(request.getParameter("lic_no"));
		lDto.setInstitution(request.getParameter("institution"));
		lDto.setGet_dt(Date.valueOf(request.getParameter("get_dt")));
		lDto.setExpiration_dt(Date.valueOf(request.getParameter("expiration_dt")));
		lDto.setCertificate_img_path(request.getParameter("certificate_img_path"));
		
		LicDao lDao = LicDao.getInstance();
		lDao.insertLic(lDto);
		
	}

}
