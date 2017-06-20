package com.kedu.notice.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.common.Action;
import com.kedu.notice.dao.NoticeDao;

public class NoticeDeleteAction implements Action{ 
	
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String notice_no = request.getParameter("notice_no");
		
		NoticeDao nDao = NoticeDao.getInstance();
		nDao.deleteNotice(notice_no);
		
		new NoticeListAction().excute(request, response);
	}
}
