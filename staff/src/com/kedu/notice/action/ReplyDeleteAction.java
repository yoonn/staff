package com.kedu.notice.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.common.Action;
import com.kedu.notice.dao.ReplyDao;

public class ReplyDeleteAction implements Action{
	
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String reply_no = request.getParameter("reply_no");
		
		ReplyDao rDao = ReplyDao.getInstance();
		rDao.deleteNoticeReply(reply_no);
		
	}

}
