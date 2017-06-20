package com.kedu.project.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.common.Action;
import com.kedu.project.dao.CorpProjDao;
import com.kedu.project.dto.CorpProjDto;

public class ProjectViewAction implements Action{
	
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "project/projectView.jsp";
		
		String proj_no = request.getParameter("proj_no");
		
		CorpProjDto cpDto = new CorpProjDto();
		CorpProjDao cpDao = CorpProjDao.getInstance();
		cpDto = cpDao.selectOneCorpProjByNum(proj_no);
		
		request.setAttribute("proj", cpDto);
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}

}
