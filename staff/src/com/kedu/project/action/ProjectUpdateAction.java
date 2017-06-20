package com.kedu.project.action;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.common.Action;
import com.kedu.project.dao.CorpProjDao;
import com.kedu.project.dto.CorpProjDto;

public class ProjectUpdateAction implements Action{
	
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url     = "project/projectUpdate.jsp";
		String proj_no = request.getParameter("proj_no");
		
		CorpProjDto cpDto = new CorpProjDto();
		cpDto.setProj_no(proj_no);
		cpDto.setProj_nm(request.getParameter("proj_nm"));
		cpDto.setClient(request.getParameter("client"));
		cpDto.setProj_content(request.getParameter("proj_content"));
		cpDto.setStart_dt(Date.valueOf(request.getParameter("start_dt")));
		cpDto.setEnd_dt(Date.valueOf(request.getParameter("end_dt")));
		cpDto.setUpdate_emp(request.getParameter("update_emp"));
		cpDto.setUpdate_dt(Date.valueOf(request.getParameter("update_dt")));
		
		CorpProjDao cpDao = CorpProjDao.getInstance();
		cpDao.updateCorpProj(cpDto);
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}

}
