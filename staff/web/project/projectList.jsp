<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/project/projectList.css">
<script type="text/javascript" src="../js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="../js/common/hover.js"></script>

<script type="text/javascript">
$(function(){
	$("#search").click(function(){
		
		var search_type = $("#search_type").val();
		var keyword = $("#keyword").val();
		
		if($("#keyword").val() == ""){
			alert("키워드를 입력해 주십시오");
			return false;
		}
		
		window.location.href="ProjectServlet?command=proj_list&search_type="+search_type+"&keyword="+keyword;
		
	});
});

</script>

</head>
<body>
<div id="wrap">
	<%@ include file="../common/header.jsp" %>
	<%@ include file="../common/menu.jsp" %>
	<div id="content">
		<span id="title">프로젝트 이력 목록</span>
		<table id="search_table">
			<tr id="top">
				<td class="info">검색</td>
				<td class="input">
					&nbsp;
					<select name="search_type" id="search_type">
						<option value="res_emp">작성자</option>
						<option value="proj_nm">프로젝트 명</option>
						<option value="proj_no">프로젝트 번호</option>
					</select>
					&nbsp;
					<input type="text" name="keyword" id="keyword" size="39">
					&nbsp;
					<input type="button" value="&nbsp;조회&nbsp;" id="search">
					<input type="button" value="전체목록" onclick="location.href='ProjectServlet?command=proj_list'">
				</td>
			</tr>
		</table>
		
		<table id="list_table">
			<tr>
				<td class="info short" >순번</td>
				<td class="info short" >작성자</td>
				<td class="info long"  >프로젝트명</td>
				<td class="info middle">등록일</td>
			</tr>
			<c:forEach var="proj" items="${corpProjList }">
				<tr>
					<td class="input short">${proj.proj_no}</td>
					<td class="input short">${proj.res_emp}</td>
					<td class="input long">
						<a class="hover" href="ProjectServlet?command=proj_view&proj_no=${proj.proj_no}">${proj.proj_nm}</a>
					</td>
					<td class="input middle">${proj.res_dt}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="4" id="submit_btn">
					<input type="button" value="작성"
						onclick="location.href='ProjectServlet?command=proj_write_form'">
				</td>
			</tr>
			<tr>
			</tr>
		</table>
		
		<div id="list_page">
			<table>
				<tr>
					<td id="location_btn">
						<c:if test="${curPage ne 1}">
							<a class="hover" href="ProjectServlet?command=proj_list&cPage=${curPage-1}">이전</a>						
						</c:if>
						&nbsp;
						<c:forEach var="page" begin="1" end="${totalPage }">
							<c:if test="${page eq curPage }">
								${page }&nbsp;
							</c:if>
							<c:if test="${page ne curPage }">
								<a class="hover" href="ProjectServlet?command=proj_list&cPage=${page}">${page}</a>&nbsp;
							</c:if>
						</c:forEach>
						<c:if test="${curPage ne totalPage }">
							<a class="hover" href="ProjectServlet?command=proj_list&cPage=${curPage+1}">다음</a>
						</c:if>
					</td>
				</tr>
			</table>
		</div>
		
	</div>
</div>
</body>
</html>
				