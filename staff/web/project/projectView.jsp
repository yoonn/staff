<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>projectReg</title>
<script type="text/javascript" src="../js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="../js/common/hover.js"></script>
<link rel="stylesheet" type="text/css" href="../css/project/projectView.css"/>

<script type="text/javascript">
	
	$(function(){
		
		$("#delete_btn").click(function(){
			var proj_no = "${proj.proj_no}";
			
			if(confirm("정말 선택하신 항목을 삭제하시겠습니까?")){
				window.location.href="ProjectServlet?command=proj_delete&proj_no="+proj_no;
				alert("삭제에 성공하였습니다.");
			}
		});
		
	});
</script>
</head>
<body>

<div id="wrap">

	<%@ include file="../common/header.jsp" %>
	<%@ include file="../common/menu.jsp" %>
	
	<div id="content">
		<span id="title">프로젝트 이력</span>
		<table id="project_input">
			<tr>
				<td class="info">프로젝트 명</td>
				<td class="input" colspan="3">
					${proj.proj_nm }
				</td>
			</tr>
			<tr>
				<td class="info">프로젝트 번호</td>
				<td class="input">
					${proj.proj_no }
				</td>
				<td class="info">작성자</td>
				<td class="input">
					${proj.res_emp }
				</td>
			</tr>
			<tr>
				<td class="info">거래처</td>
				<td class="input">
					${proj.client }
				</td>
				<td class="info">등록일</td>
				<td class="input">
					${proj.res_dt}
				</td>
			</tr>
			<tr>
				<td class="info">기간</td>
				<td class="input" colspan="3">
					${proj.start_dt }
					&nbsp;~&nbsp;
					${proj.end_dt }
				</td>
			</tr>
			<tr>
				<td class="info">사용 기술??</td>
				<td class="input" colspan="3">
					<%-- <c:forEach var="use_skill" items="${paramValues.use_skills }">
						${use_skill },&nbsp;
					</c:forEach> --%>
				</td>
			</tr>
			<tr>
				<td class="input" colspan="4" id="proj_content">
					${proj.proj_content }
				</td>
			</tr>
			<tr>
				<td colspan="4" id="btn_area">
					<input type="button" value="프로젝트 수정"
						onclick="location.href='ProjectServlet?command=proj_update_form&proj_no=${proj.proj_no}'">
					<input type="submit" value="프로젝트 삭제" id="delete_btn">
					<input type="button" value="프로젝트 리스트"
						onclick="location.href='ProjectServlet?command=proj_list'">
					<input type="button" value="프로젝트 등록"
						onclick="location.href='ProjectServlet?command=proj_write_form'">
				</td>
			</tr>
		</table>
	</div>
		
	<%@ include file="../common/footer.jsp" %>

</div>


</body>
</html>