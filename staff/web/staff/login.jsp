<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
<link rel="stylesheet" type="text/css" href="../css/main/login.css"/>
<script type="text/javascript" src="../js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="../js/main/login.js"></script>
</head>
<body>
<div id="wrap">
	<span id="login_title">LOGIN</span>
	<form action="StaffServlet" method="post" name="login_frm">
		<input type="hidden" name="command" value="login">
		<div id="login_form">
			<input type="text" id="userid" name="emp_id" size="25"
				   placeholder="id"/>
			<input type="password" id="userpwd" name="emp_pwd" size="25"
				   placeholder="password"/>
		</div>
		<div id="admin_form">
			<label for="staff">
				직원
			</label>
			<input type="radio" name="notice_mgr" id="staff" value="1" checked="checked"/>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<label for="admin">
				관리자
			</label>
			<input type="radio" name="notice_mgr" id="admin" value="0"/>
		</div>
		<div id="btn_form">
			<input type="submit" name="login_btn" value="로그인"/>
		</div>
		<div>
			<span>${message }</span>
		</div>
	</form>
</div>
</body>
</html>