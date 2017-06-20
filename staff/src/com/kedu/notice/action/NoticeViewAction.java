package com.kedu.notice.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.common.Action;
import com.kedu.notice.dao.NoticeDao;
import com.kedu.notice.dao.ReplyDao;
import com.kedu.notice.dto.NoticeDto;
import com.kedu.notice.dto.ReplyDto;

public class NoticeViewAction implements Action{
	
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/notice/noticeView.jsp";
		String notice_no = request.getParameter("notice_no");
		
		NoticeDao nDao = NoticeDao.getInstance();
		nDao.updateReadCount(notice_no);
		NoticeDto nDto = nDao.selectOneNoticeByNum(notice_no);
		
		ReplyDao rDao = ReplyDao.getInstance();
		List<ReplyDto> replyList = rDao.selectNoticeReply(notice_no);
		
		request.setAttribute("notice", nDto);
		request.setAttribute("replyList", replyList);
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
						
	}

}
