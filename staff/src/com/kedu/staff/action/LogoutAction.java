package com.kedu.staff.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.common.Action;

public class LogoutAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "StaffServlet?command=login_form";
		
		request.removeAttribute("loginMgr");
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}
}
