package com.kedu.notice.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.common.Action;
import com.kedu.notice.dao.ReplyDao;
import com.kedu.notice.dto.ReplyDto;

public class ReplyWriteAction implements Action{
	
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ReplyDao rDao = ReplyDao.getInstance();
		
		ReplyDto rDto = new ReplyDto();
		
		rDto.setNotice_no(request.getParameter("notice_no"));
		rDto.setEmp_id(request.getParameter("emp_id"));
		rDto.setReply_content(request.getParameter("reply_content"));
		
		rDao.insertNoticeReply(rDto);
		
	}

}
