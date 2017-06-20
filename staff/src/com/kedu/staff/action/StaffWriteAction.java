package com.kedu.staff.action;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.common.Action;
import com.kedu.staff.dao.StaffDao;
import com.kedu.staff.dto.StaffDto;

public class StaffWriteAction implements Action{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int result = 0;
		String emp_no = null;
		
		//insertStaff(sDto)만들기
		StaffDto sDto = new StaffDto();
		
		String res_front_num = request.getParameter("res_front_num");
		String res_back_num = request.getParameter("res_back_num");		
		
		sDto.setDept_no(request.getParameter("dept_no"));
		sDto.setRank_no(request.getParameter("rank_no"));
		sDto.setEmp_sal(Double.parseDouble(request.getParameter("emp_sal")));
		sDto.setEmp_nm(request.getParameter("emp_nm"));
		sDto.setEmp_id(request.getParameter("emp_id"));
		sDto.setEmp_pwd(request.getParameter("emp_pwd"));
		sDto.setRes_no(Double.parseDouble(res_front_num+res_back_num));
		sDto.setZipcode(request.getParameter("zipcode"));
		sDto.setEmp_addr(request.getParameter("emp_addr"));
		sDto.setEmp_detail_addr(request.getParameter("emp_detail_addr"));
		sDto.setEmp_mobile(Double.parseDouble(request.getParameter("emp_mobile")));
		sDto.setEmp_office(Double.parseDouble(request.getParameter("emp_office")));
		sDto.setEnter_dt(Date.valueOf(request.getParameter("enter_dt")));
		sDto.setRes_dt(Date.valueOf(request.getParameter("res_dt")));
		sDto.setRes_emp(request.getParameter("res_emp"));
		sDto.setNotice_mgr(Integer.parseInt(request.getParameter("notice_mgr")));
		
		StaffDao sDao = StaffDao.getInstance();
		result = sDao.insertStaff(sDto);
		
		if(result == 1){
			emp_no = sDao.getEmpNo(request.getParameter("emp_id"));
		}
		
		response.getWriter().print(emp_no);
		
	}
}
