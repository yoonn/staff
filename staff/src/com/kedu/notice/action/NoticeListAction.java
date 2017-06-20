package com.kedu.notice.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.common.Action;
import com.kedu.notice.dao.NoticeDao;
import com.kedu.notice.dto.NoticeDto;

public class NoticeListAction implements Action{
	
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url   = "/notice/noticeList.jsp";
		String search_type = request.getParameter("search_type");
		String keyword = request.getParameter("keyword");
		
		int totalPage = 0;
		int totalNotice = 0;
		
		List<NoticeDto> noticeList = null;
		
		String cPage = request.getParameter("cPage");
		int curPage   = 0;
		
		if(cPage == null){
			curPage = 1;
		}else{
			curPage = Integer.parseInt(cPage);
		}
		
		NoticeDao nDao = NoticeDao.getInstance();
		
		if(keyword != null){
			noticeList = nDao.selectSearchNotices(cPage, search_type, keyword);
			totalNotice = nDao.cntSearchNotice(search_type, keyword);
		}else{
			noticeList = nDao.selectAllNotices(cPage);
			totalNotice = nDao.totalNotice();
		}
		

		if(totalNotice != 0){
			if(totalNotice%10==0){
				totalPage = totalNotice/10;
			}else{
				totalPage = totalNotice/10 +1;
			}
		}
		
		System.out.println("cPage : " + cPage);
		System.out.println("noticeList : " + noticeList);
		System.out.println("totalPage : " + totalPage);
		System.out.println("totalNotice : " + totalNotice);
		
		request.setAttribute("noticeList", noticeList);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("curPage", curPage);
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
		
	}
	
}
