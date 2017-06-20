package com.kedu.staff.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.common.Action;
import com.kedu.staff.dao.StaffDao;
import com.kedu.staff.dto.StaffDto;

public class StaffListAction implements Action{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="staff/staffList.jsp";
		
		String cPage = request.getParameter("cPage");
		String search_type = request.getParameter("search_type");
		String keyword = request.getParameter("keyword");
		
		int curPage   = 0;
		int totalPage = 0;
		int totalStaff = 0;
		
		List<StaffDto> staffList = null;
		
		if(cPage == null){
			curPage = 1;
		}else{
			curPage = Integer.parseInt(cPage);
		}
		
		StaffDao sDao = StaffDao.getInstance();
		
		System.out.println("in ProjListAction");
		
		System.out.println("keyword : " + keyword);
		System.out.println("search_type : " + search_type);
		
		if(keyword != null){
			totalStaff = sDao.cntSearchStaff(search_type, keyword);
			staffList = sDao.selectSearchStaff(cPage, search_type, keyword);
		}else{
			totalStaff = sDao.totalStaff();
			staffList = sDao.selectAllStaff(cPage);
		}

		if(totalStaff != 0){
			if(totalStaff%10==0){
				totalPage = totalStaff/10;
			}else{
				totalPage = totalStaff/10 +1;
			}
		}
		
		System.out.println("cPage : " + cPage);
		System.out.println("staffList : " + staffList);
		System.out.println("totalPage : " + totalPage);
		System.out.println("totalStaff : " + totalStaff);
		
		request.setAttribute("staffList", staffList);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("curPage", curPage);
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}
}
