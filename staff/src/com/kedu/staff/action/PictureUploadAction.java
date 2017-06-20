package com.kedu.staff.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.common.Action;
import com.kedu.staff.dao.StaffDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class PictureUploadAction implements Action{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("staff-file");
		String encType = "UTF-8";
		int    sizeLimit = 20 * 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(request
													 , path
													 , sizeLimit
													 , encType
													 , new DefaultFileRenamePolicy()
													 );
		
		String emp_no = multi.getParameter("emp_no");
		String file_name = multi.getFilesystemName("file_request_url");
		
		StaffDao sDao = StaffDao.getInstance();
		sDao.updatePicture(emp_no, path, file_name);
	}
}
