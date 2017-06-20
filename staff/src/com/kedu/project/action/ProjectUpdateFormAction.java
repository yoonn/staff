package com.kedu.project.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.common.Action;
import com.kedu.project.dao.CorpProjDao;
import com.kedu.project.dto.CorpProjDto;

public class ProjectUpdateFormAction implements Action{
	
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "project/projectUpdate.jsp";
		
		String proj_no = request.getParameter("proj_no");
		
		CorpProjDao cpDao = CorpProjDao.getInstance();
		CorpProjDto cpDto = new CorpProjDto();
		cpDto = cpDao.selectOneCorpProjByNum(proj_no);
		
		request.setAttribute("proj", cpDto);
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}

}
