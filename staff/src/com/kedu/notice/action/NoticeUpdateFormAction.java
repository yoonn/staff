package com.kedu.notice.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.common.Action;
import com.kedu.notice.dao.NoticeDao;
import com.kedu.notice.dto.NoticeDto;

public class NoticeUpdateFormAction implements Action{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/notice/noticeUpdate.jsp";
		
		String notice_no = request.getParameter("notice_no");
		
		NoticeDao nDao = NoticeDao.getInstance();
		
		nDao.updateReadCount(notice_no);
		
		NoticeDto nDto = nDao.selectOneNoticeByNum(notice_no);
		
		request.setAttribute("notice", nDto);
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}
}
