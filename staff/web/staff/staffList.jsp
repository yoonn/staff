<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/staff/staffList.css">
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
		
		window.location.href="StaffServlet?command=staff_list&search_type="+search_type+"&keyword="+keyword;
		
	});
});

</script>

</head>
<body>
<div id="wrap">
	<%@ include file="../common/header.jsp" %>
	<%@ include file="../common/menu.jsp" %>
	<div id="content">
		<span id="title">사원정보 목록</span>
		<table id="search_table">
			<tr id="top">
				<td class="info">검색</td>
				<td class="input">
					&nbsp;
					<select name="search_type" id="search_type">
						<option value="emp_no">사번</option>
						<option value="emp_nm">사원명</option>
						<option value="dept_no">부서</option>
						<option value="rank_no">직급</option>
					</select>
					&nbsp;
					<input type="text" name="keyword" id="keyword" size="45">
					&nbsp;
					<input type="button" value="&nbsp;조회&nbsp;" id="search">
					<input type="button" value="전체목록" onclick="location.href='StaffServlet?command=staff_list'">
				</td>
			</tr>
		</table>
		
		<table id="list_table">
			<tr>
				<td class="info">사번</td>
				<td class="info">사원명</td>
				<td class="info">부서</td>
				<td class="info">직급</td>
				<td class="info">입사일</td>
			</tr>
			<c:forEach var="staff" items="${staffList }">
				<tr>
					<td class="input">${staff.emp_no}</td>
					<td class="input">
						<a class="hover" href="">${staff.emp_nm}</a>
					</td>
					<td class="input">
						<c:if test="${0 eq staff.dept_no}">
							경영
						</c:if>
						<c:if test="${1 eq staff.dept_no}">
							전산
						</c:if>
						<c:if test="${2 eq staff.dept_no}">
							회계
						</c:if>
					</td>
					<td class="input">
						<c:if test="${0 eq staff.rank_no}">
							사장
						</c:if>
						<c:if test="${1 eq staff.rank_no}">
							부장
						</c:if>
						<c:if test="${2 eq staff.rank_no}">
							사원
						</c:if>
					</td>
					<td class="input">${staff.enter_dt}</td>
				</tr>
			</c:forEach>
		</table>
		
		<div id="list_page">
			<table>
				<tr>
					<td id="location_btn">
						<c:if test="${curPage ne 1}">
							<a class="hover" href="StaffServlet?command=staff_list&cPage=${curPage-1}">이전</a>						
						</c:if>
						&nbsp;
						<c:forEach var="page" begin="1" end="${totalPage }">
							<c:if test="${page eq curPage }">
								${page }&nbsp;
							</c:if>
							<c:if test="${page ne curPage }">
								<a class="hover" href="StaffServlet?command=staff_list&cPage=${page}">${page}</a>&nbsp;
							</c:if>
						</c:forEach>
						<c:if test="${curPage ne totalPage }">
							<a class="hover" href="StaffServlet?command=staff_list&cPage=${curPage+1}">다음</a>
						</c:if>
					</td>
				</tr>
			</table>
		</div>
		
	</div>
</div>
</body>
</html>
				