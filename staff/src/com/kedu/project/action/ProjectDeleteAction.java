package com.kedu.project.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.common.Action;
import com.kedu.project.dao.CorpProjDao;

public class ProjectDeleteAction implements Action{ 
	
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String proj_no = request.getParameter("proj_no");
		
		CorpProjDao cpDao = CorpProjDao.getInstance();
		cpDao.deleteCorpProj(proj_no);
		
		new ProjectListAction().excute(request, response);
		
	}
}
