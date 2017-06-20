<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="../css/common/menu.css"/>
<div id="menu">
	<div id="munu_area">
		<div id="staff_proj_menu">
			<div id="staff_proj_title">
				<h4>개인프로젝트 이력관리</h4>
			</div>
			<div id="staff_proj_list">
				<a class="hover" href="ProjectServlet?command=proj_list">
					프로젝트 이력 목록
				</a>
			</div>
			<div id="staff_porj_reg">
				<a class="hover" href="ProjectServlet?command=proj_write_form">
					프로젝트 이력 등록
				</a>
			</div>
		</div>
		<div id="staff_info_menu">
			<div id="staff_info_title">
				<h4>개인정보관리</h4>
			</div>
			<div id="staff_info_list">
				<a class="hover" href="StaffServlet?command=staff_list">
					사원 정보 목록
				</a>
			</div>
			<div id="staff_info_reg">
				<a class="hover" href="StaffServlet?command=staff_write_form">
					사원 정보 등록
				</a>
			</div>
		</div>
		<div id="notice_menu">
			<div id="notice_title">
				<h4>공지사항</h4>
			</div>
			<div id="notice_list">
				<a class="hover" href="NoticeServlet?command=notice_list">
					공지사항 목록
				</a>
			</div>
			<div id="notice_reg">
				<a class="hover" href="NoticeServlet?command=notice_write_form">
					공지사항 등록
				</a>
			</div>
		</div>
	</div>
</div>