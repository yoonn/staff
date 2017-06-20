package com.kedu.notice.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.common.Action;
import com.kedu.notice.dao.NoticeDao;
import com.kedu.notice.dto.NoticeDto;

public class NoticeUpdateAction implements Action{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeDto nDto = new NoticeDto();
		
		nDto.setNotice_no(request.getParameter("notice_no"));
		nDto.setEmp_id(request.getParameter("emp_id"));
		nDto.setNotice_title(request.getParameter("notice_title"));
		nDto.setNotice_content(request.getParameter("notice_content"));
		
		NoticeDao nDao = NoticeDao.getInstance();
		nDao.updateNotice(nDto);
		
		new NoticeListAction().excute(request, response);
		
	}
}
