package com.kedu.project.action;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.common.Action;
import com.kedu.project.dao.CorpProjDao;
import com.kedu.project.dto.CorpProjDto;

public class ProjectWriteAction implements Action{
	
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CorpProjDto cpDto = new CorpProjDto();
		cpDto.setProj_nm(request.getParameter("proj_nm"));
		cpDto.setClient(request.getParameter("client"));
		/*cpDto.setPrice(Integer.parseInt(request.getParameter("price")));*/
		cpDto.setProj_content(request.getParameter("proj_content"));
		cpDto.setRes_emp(request.getParameter("res_emp"));
		cpDto.setStart_dt(Date.valueOf(request.getParameter("start_dt")));
		cpDto.setEnd_dt(Date.valueOf(request.getParameter("end_dt")));
		
		CorpProjDao cpDao = CorpProjDao.getInstance();
		cpDao.insertCorpProj(cpDto);
		
		new ProjectListAction().excute(request, response);
	}

}
