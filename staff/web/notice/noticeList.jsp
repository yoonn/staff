<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt"	%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/notice/noticeList.css">
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script type="text/javascript" src = "js/jquery.tmpl.min.js"></script>
<script type="text/javascript" src="js/common/hover.js"></script>

<script type="text/javascript">
$(function(){
	$("#search").click(function(){
		
		var search_type = $("#search_type").val();
		var keyword = $("#keyword").val();
		
		if($("#keyword").val() == ""){
			alert("키워드를 입력해 주십시오");
			return false;
		}
		
		window.location.href="NoticeServlet?command=notice_list&search_type="+search_type+"&keyword="+keyword;
		
	});
});

</script>

</head>
<body>
<div id="wrap">
	<%@ include file="../common/header.jsp" %>
	<%@ include file="../common/menu.jsp" %>
	<div id="content">
		<span id="title">공지사항 목록</span>
		<table id="search_table">
			<tr id="top">
				<td class="info">검색</td>
				<td class="input">
					&nbsp;
					<select name="search_type" id="search_type">
						<option value="emp_id">작성자</option>
						<option value="notice_title">제목</option>
					</select>
					&nbsp;
					<input type="text" name="keyword" id="keyword" size="45">
					&nbsp;
					<input type="button" value="&nbsp;조회&nbsp;" id="search">
					<input type="button" value="전체목록"
						onclick="location.href='NoticeServlet?command=notice_list'">
				</td>
			</tr>
		</table>
		
		<table id="list_table">
			<thead>
				<tr id="top">
					<th class="no">번호</th>
					<th class="title">제목</th>
					<th class="writer">작성자</th>
					<th class="res_dt">등록일</th>
					<th class="hit">조회</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="notice" items="${noticeList }">
					<tr class="record">
						<td class="no">
							${notice.notice_no }
						</td>
						<td class="title">
							<a class="hover" href="NoticeServlet?command=notice_view&notice_no=${notice.notice_no }">
								${notice.notice_title }
							</a>
						</td>
						<td class="writer">
							${notice.emp_id }
						</td>
						<td class="res_dt">
							<fmt:formatDate value="${notice.res_dt }"/>
						</td>
						<td class="hit">
							${notice.readcount }
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div id="list_page">
		<table>
			<tr>
				<td id="input_btn">
					<input type="button" value="글쓰기"
						onclick="location.href='NoticeServlet?command=notice_write_form'">
				</td>
			</tr>
			<tr>
				<td id="location_btn">
					<c:if test="${curPage ne 1}">
						<a class="hover" href="NoticeServlet?command=notice_list&cPage=${curPage-1}">이전</a>						
					</c:if>
					&nbsp;
					<c:forEach var="page" begin="1" end="${totalPage }">
						<c:if test="${page eq curPage }">
							${page }&nbsp;
						</c:if>
						<c:if test="${page ne curPage }">
							<a class="hover" href="NoticeServlet?command=notice_list&cPage=${page}">${page}</a>&nbsp;
						</c:if>
					</c:forEach>
					<c:if test="${curPage ne totalPage }">
						<a class="hover" href="NoticeServlet?command=notice_list&cPage=${curPage+1}">다음</a>
					</c:if>
				</td>
				
			</tr>
		</table>
	</div>
	<%@ include file="../common/footer.jsp" %>
</div>
</body>
</html>