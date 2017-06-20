<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/staff/staffReg.css"/>
<script type="text/javascript" src="../js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="../js/common/hover.js"></script>
<title>staffRegResult</title>
</head>
<body>

<%
	request.setCharacterEncoding("UTF-8");
%>

<div id="wrap">

	<%@ include file="../common/header.jsp" %>
	
	<%@ include file="../common/menu.jsp" %>
	
	<div id="content">
	
		<div id="center">
			<span id="title">사원정보 등록</span>
			
			<table>
				<tr>
					<td rowspan="16" id="img_d">
						<div>
							<img id="img_profile" src="../img/staff/profile.jpg">
						</div>
					</td>
				</tr>
				<tr class="nomal">
					<td class="info">
						사번
					</td>
					<td class="input">
						2012312031
					</td>
				</tr>
				<tr class="nomal">
					<td class="info">
						이름
					</td>
					<td class="input">
						${param.staff_name}
					</td>
				</tr>
				<tr class="nomal">
					<td class="info">
						주민번호
					</td>
					<td class="input">
						${param.res_front_num }
						-
						${param.res_back_num }
					</td>
				</tr>
				<tr class="nomal">
					<td class="info">
						성별
					</td>
					<td class="input">
						${param.gender }
					</td>
				</tr>
				<tr class="nomal">
					<td class="info">
						생년월일
					</td>
					<td class="input">
						${param.birth }
					</td>
				</tr>
				<tr class="nomal">
					<td class="info">
						부서
					</td>
					<td class="input">
						${param.dept }
					</td>
				</tr>
				<tr class="nomal">
					<td class="info">
						직급
					</td>
					<td class="input">
						${param.rank }
					</td>
				</tr>
				<tr class="nomal">
					<td class="info">
						입사일
					</td>
					<td class="input">
						${param.join_date }
					</td>
				</tr>
				<tr class="nomal">
					<td class="info">
						퇴사일
					</td>
					<td class="input">
						${param.resign_date }
					</td>
				</tr>
				<tr class="nomal">
					<td class="info">
						우편번호
					</td>
					<td class="input">
						서울시
					</td>
				</tr>
				<tr class="nomal">
					<td class="info">
						주소
					</td>
					<td class="input">
						구리구
					</td>
				</tr>
				<tr class="nomal">
					<td class="info">
						상세주소
					</td>
					<td class="input">
						${param.detail_addr}
					</td>
				</tr>
				<tr class="nomal">
					<td class="info">
						급여
					</td>
					<td class="input">
						<fmt:formatNumber value="${param.sal}"/>&nbsp;원
					</td>
				</tr>
				<tr id="large">
					<td class="info">
						비고
					</td>
					<td class="input">
						${param.note}
					</td>
				</tr>
				<tr class="nomal">
					<td class="info">
						등록일
					</td>
					<td class="input">
						${param.res_date}
					</td>
				</tr>
				<tr>
					<td id="fix_btn" colspan="3">
						<input type="submit" value="목록"/>
						&nbsp;
						<input type="reset" value="수정"/>
						&nbsp;
						<input type="reset" value="삭제"/>
					</td>
				</tr>
			</table>
			<div id="fix_btn">
				<p>
					
				</p>
			</div>

		</div>
	</div>
	
	<%@ include file="../common/footer.jsp" %>

</div>

</body>
</html>