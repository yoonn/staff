package com.kedu.notice.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.common.Action;

public class NoticeWriteFormAction implements Action{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "notice/noticeWrite.jsp";
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}
}
