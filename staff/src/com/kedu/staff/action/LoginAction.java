package com.kedu.staff.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kedu.common.Action;
import com.kedu.staff.dao.StaffDao;
import com.kedu.staff.dto.StaffDto;

public class LoginAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="StaffServlet?command=login_form";
		String emp_id  = request.getParameter("emp_id");
		String emp_pwd = request.getParameter("emp_pwd");
		int	notice_mgr = Integer.parseInt(request.getParameter("notice_mgr"));
		
		StaffDao sDao = StaffDao.getInstance();
		
		int result = sDao.userCheck(emp_id, emp_pwd, notice_mgr);
		
		if(result==3){
			StaffDto sDto = sDao.getStaff(emp_id);
			HttpSession session = request.getSession();
			session.setAttribute("login", sDto);
			url="NoticeServlet?command=notice_list";
		}else if(result==2){
			request.setAttribute("message", "사원입니다.");
		}else if(result==1){
			request.setAttribute("message", "권한을 다시 설정해 주십시오");
		}else if(result==0){
			request.setAttribute("message", "비밀번호가 맞지 않습니다.");
		}else if(result==-1){
			request.setAttribute("message", "존재하지 않는 아이디 입니다.");
		}
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}
}
