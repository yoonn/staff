<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href="../css/common/header.css"/>

<div id="header_space">
	<div id="header">
		<div id="header_title">
			<a href="NoticeServlet?command=notice_list">사원정보 관리 페이지</a>
		</div>
		<div id="header_login">
			<div id="login_info">
				<img id="img_login" src="../images/staff/profile.jpg">
				<span id="login_name">
					${login.emp_nm} 님
				</span>
			</div>
			<div id="logout">
				<input type="button" id="logout_btn" value="logout" 
						onclick="location.href='StaffServlet?command=logout'" />
			</div>
		</div>
	</div>
</div>