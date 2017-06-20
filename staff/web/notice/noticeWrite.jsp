<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/notice/notice.css">
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="js/common/hover.js"></script>
<script type="text/javascript" src="js/notice/notice.js"></script>
</head>
<body>
<c:set var="now" value="<%= new Date() %>"/>
<div id="wrap">

	<%@ include file="../common/header.jsp" %>
	<%@ include file="../common/menu.jsp" %>
	
	<div id="content">
		<span id="title">
			공지사항 등록
		</span>
		<form name="frm" method="post" action="NoticeServlet">
			<input type="hidden" name="command" value="notice_write">
			<input type="hidden" name="emp_id" value="${login.emp_id }">
			<table id="notice">
				<tr>
					<td class="info">
						제목
					</td>
					<td id="title_input" colspan="5">
						<input type="text" name="notice_title" size="60"/>
					</td>
				</tr>
				<tr>
					<td class="info">
						작성자
					</td>
					<td class="input">
						${login.emp_id}
					</td>
					<td class="info">
						작성일
					</td>
					<td class="input">
						<fmt:formatDate value="${now}" pattern="yyyy-MM-dd"/>
					</td>
					<td class="info">
						수정일
					</td>
					<td class="input">
						<fmt:formatDate value="${now}" pattern="yyyy-MM-dd"/>
					</td>
				</tr>
				<tr>
					<td colspan="6">
						<textarea name="notice_content" rows="15"
							placeholder="공지사항을 입력해주세요."></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="6" id="btn_area">
						<input type="submit" value="등록" onclick="return noticeCheck()">
						&nbsp;&nbsp;
						<input type="reset" value="다시 작성">
						&nbsp;&nbsp;
						<input type="button" value="목록" onclick="location.href='NoticeServlet?command=notice_list'">
						&nbsp;&nbsp;
					</td>
				</tr>
			</table>
		</form>
	</div>
	<%@ include file="../common/footer.jsp" %>
</div>
</body>
</html>
				