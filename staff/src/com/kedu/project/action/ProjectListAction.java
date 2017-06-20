package com.kedu.project.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kedu.common.Action;
import com.kedu.project.dao.CorpProjDao;
import com.kedu.project.dto.CorpProjDto;

public class ProjectListAction implements Action{
	
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url   = "project/projectList.jsp";
		String cPage = request.getParameter("cPage");
		String search_type = request.getParameter("search_type");
		String keyword = request.getParameter("keyword");
		
		int curPage   = 0;
		int totalPage = 0;
		int totalcorpProj = 0;
		
		List<CorpProjDto> corpProjList = null;
		
		if(cPage == null){
			curPage = 1;
		}else{
			curPage = Integer.parseInt(cPage);
		}
		
		CorpProjDao cpDao = CorpProjDao.getInstance();
		
		if(keyword != null){
			totalcorpProj = cpDao.cntSearchCorpProj(search_type, keyword);
			corpProjList = cpDao.selectSearchCorpProj(cPage, search_type, keyword);
		}else{
			totalcorpProj = cpDao.totalCorpProj();
			corpProjList = cpDao.selectAllCorpProj(cPage);
		}

		if(totalcorpProj != 0){
			if(totalcorpProj%10==0){
				totalPage = totalcorpProj/10;
			}else{
				totalPage = totalcorpProj/10 +1;
			}
		}
		
		System.out.println("cPage : " + cPage);
		System.out.println("corpProjList : " + corpProjList);
		System.out.println("totalPage : " + totalPage);
		System.out.println("totalNotice : " + totalcorpProj);
		
		request.setAttribute("corpProjList", corpProjList);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("curPage", curPage);
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}

}
