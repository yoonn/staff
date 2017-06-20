<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>projectRegForm</title>
<script type="text/javascript" src="../js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="../js/common/hover.js"></script>
<script type="text/javascript" src="../js/project/project.js"></script>
<link rel="stylesheet" type="text/css" href="../css/project/project.css">
<link rel="stylesheet" type="text/css" href="../css/common/js.css">
</head>
<body>



<div id="wrap">

	<%@ include file="../common/header.jsp" %>
	<%@ include file="../common/menu.jsp" %>
	
	<div id="content">
		<span id="title">프로젝트 이력 수정</span>
		<form action="ProjectServlet" method="post">
			<input type="hidden" name="command" value="proj_update">
			<table id="project_input">
				<tr>
					<td class="info">수정자</td>
					<td class="input">
						<input type="text" disabled="disabled" value="${login.emp_id }"/>
						<input type="hidden" value="${login.emp_id }" name="update_emp">
					</td>
				</tr>
				<tr>
					<td class="info">프로젝트 명</td>
					<td class="input">
						<input type="text" id="proj_nm" name="proj_nm" size="50" class="fill_input" value="${proj.proj_nm }"/>
						<span></span>
					</td>
				</tr>
				<tr>
					<td class="info">거래처</td>
					<td class="input">
						<input type="text" id="client" name="client" size="50" class="fill_input" value="${proj.client }">
						<span></span>
					</td>
				</tr>
				<!-- <tr>
					<td class="info">가격</td>
					<td class="input">
						<input type="text" id="price" name="price" size="40" class="fill_input">
						<span></span>
					</td>
				</tr> -->
				<tr>
					<td class="info">기간</td>
					<td class="input">
						<input type="date" id="start_dt" name="start_dt" class="fill_input" value="${proj.start_dt }"/>
						&nbsp;~&nbsp;
						<input type="date" id="end_dt" name="end_dt" class="fill_input" value="${proj.end_dt }"/>
						<span id="dt_span"></span>
					</td>
				</tr>
				<tr>
					<td class="info">사용 기술</td>
					<td class="input">
						<table id="skill_input">
							<tr>
								<td class="skill_input">
									<input type="checkbox" name="skill_no" value="css">css
								</td>
								<td class="skill_input">
									<input type="checkbox" name="skill_no" value="jsp">jsp
								</td>
								<td class="skill_input">
									<input type="checkbox" name="skill_no" value="html">html
								</td>
							</tr>
							<tr>
								<td class="skill_input">
									<input type="checkbox" name="skill_no" value="DB">DB
								</td>
								<td class="skill_input">
									<input type="checkbox" name="skill_no" value="R">R
								</td>
								<td class="skill_input">
									<input type="checkbox" name="skill_no" value="python">python
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td class="info">상세 내용</td>
					<td class="input">
						<textarea id="proj_content" name="proj_content" rows="10">${proj.proj_content }</textarea>
					</td>
				</tr>
				<tr>
					<td id="btn_area" colspan="2">
						<input type="submit" value="수정" onclick="return update_submit()"/>
						&nbsp;&nbsp;
						<input type="button" value="취소" />
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<%@ include file="../common/footer.jsp" %>
	
</div>
</body>
</html>
