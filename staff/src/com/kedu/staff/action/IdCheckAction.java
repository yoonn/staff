package com.kedu.staff.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.common.Action;
import com.kedu.staff.dao.StaffDao;

public class IdCheckAction implements Action{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String emp_id = request.getParameter("emp_id");
		
		StaffDao sDao = StaffDao.getInstance();
		int result = sDao.selectIdCheck(emp_id);
		
		response.getWriter().println(result);
		
	}
	
}
