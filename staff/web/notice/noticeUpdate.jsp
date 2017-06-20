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
<div id="wrap">
	<%@ include file="../common/header.jsp" %>
	<%@ include file="../common/menu.jsp" %>
	<div id="content">
		<div id="center">
			<span id="title">
				공지사항 수정
			</span>
			<form name="frm" method="post" action="NoticeServlet">
				<input type="hidden" name="command" value="notice_update">
				<input type="hidden" name="notice_no" value="${notice.notice_no }">
				<table id="notice">
					<tr>
						<td class="info">
							제목
						</td>
						<td id="title_input" colspan="5">
							<input type="text" name="notice_title" size="60" value="${notice.notice_title }"/>
						</td>
					</tr>
					<tr>
						<td class="info">
							작성자
						</td>
						<td class="input">
							${notice.emp_id}
						</td>
						<td class="info">
							작성일
						</td>
						<td class="input">
							<fmt:formatDate value="${notice.res_dt}" pattern="yyyy-MM-dd"/>
						</td>
						<td class="info">
							수정일
						</td>
						<td class="input">
							<fmt:formatDate value="${notice.update_dt }" pattern="yyyy-MM-dd"/>
						</td>
					</tr>
					<tr>
						<td colspan="6">
							<textarea name="notice_content" rows="15">${notice.notice_content }</textarea>
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
	</div>
	<%@ include file="/common/footer.jsp" %>
</div>

</body>
</html>