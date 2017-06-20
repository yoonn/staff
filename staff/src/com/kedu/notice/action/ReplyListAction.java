package com.kedu.notice.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kedu.common.Action;
import com.kedu.notice.dao.ReplyDao;
import com.kedu.notice.dto.ReplyDto;

public class ReplyListAction implements Action{
	
	 @Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String notice_no = request.getParameter("notice_no");
		
		ReplyDao rDao = ReplyDao.getInstance();
		List<ReplyDto> replyList = rDao.selectNoticeReply(notice_no);
		
		Gson gson = new Gson();
		String replyListJson = gson.toJson(replyList);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/x-json");
		response.getWriter().println(replyListJson);
	}

}
