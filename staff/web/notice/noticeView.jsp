<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/notice/notice.css">
<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="js/common/hover.js"></script>
<script type="text/javascript" src="js/notice/notice.js"></script>
<script type="text/javascript" src="js/jquery.tmpl.min.js"></script>

<script id="reply_tmpl" type="text/x-jquery-tmpl">
	<tr>
		<td class="emp_id">\${emp_id}</td>
		<td class="reply_content">\${reply_content}</td>
		<td class="reply_dt">\${reply_dt }</td>
		<td class="reply_delete">
			<input type="button" value="삭제" data-num=\${reply_no} id="reply_delete">
		</td>
	</tr>
</script>

<script type="text/javascript">
	
	$(function(){
		
		var notice_no = "${notice.notice_no }";
		var emp_id = "${login.emp_id}";
		
		$("#delete_btn").click(function(){
			if(confirm("정말 선택하신 항목을 삭제하시겠습니까?")){
				window.location.href="NoticeServlet?command=notice_delete&notice_no="+notice_no;
			}
		});
		
		function replyList(){
			$.ajax({
				  url : "NoticeServlet?command=reply_list"
						+"&notice_no="+notice_no
				, type : "post"
				, dataType : "json"
				, cache : false
				, success : function(replyList){
					var tmpl = $("#reply_tmpl").tmpl(replyList);
					$("#reply > tbody").empty();
					$("#reply > tbody").append(tmpl);
				}, error : function(xhr, textStatus, errorThrown){
					alert(textStatus + xhr.status + errorThrown);
				}
			});
		}		
		
		$("#reply_btn").click(function(){
			
			$.ajax({
				  url : "NoticeServlet?command=reply_write"
						+"&notice_no="+notice_no
						+"&emp_id="+emp_id
						+"&reply_content="+$("#reply_content").val()
				, type : "post"
				, cache : false
				, success : function(){
					replyList();
					$("#reply_content").val("").focus();
				}, error : function(xhr, textStatus, errorThrown){
					alert(textStatus + xhr.status + errorThrown);
				}
			});
		});
		
		$(document).on("click", "#reply_delete", function(){
			
			var reply_no = $(this).attr("data-num");
			
			$.ajax({
				  url : "NoticeServlet?command=reply_delete"
						+"&reply_no="+reply_no
				, type : "post"
				, cache : false
				, success : function(){
					alert("삭제 완료");
					replyList();
				}, error : function(xhr, textStatus, errorThrown){
					alert(textStatus + xhr.status + errorThrown);
				}
				
			});
		});
		
	});

</script>

</head>
<body>
<div id="wrap">
	<%@ include file="../common/header.jsp" %>
	<%@ include file="../common/menu.jsp" %>
	<div id="content">
		<div id="center">
			<span id="title">
				공지사항
			</span>
			<table>
				<tr>
					<td class="info">
						번호
					</td>
					<td class="input" >
						${notice.notice_no }
					</td>
					<td class="info">
						제목
					</td>
					<td colspan="3" id="title_input">
						${notice.notice_title }
					</td>
				</tr>
				<tr>
					<td class="info">
						작성자
					</td>
					<td class="input">
						${notice.emp_id }
					</td>
					<td class="info">
						작성일
					</td>
					<td class="input">
						<fmt:formatDate value="${notice.res_dt }"/>
					</td>
					<td class="info">
						조회수
					</td>
					<td class="input">
						${notice.readcount }
					</td>
				</tr>
				<tr>
					<td colspan="6">
						<pre id="notice_content">${notice.notice_content}</pre>
					</td>
				</tr>
				<tr>
					<td colspan="6">
						<span id="small_title">댓글</span>
						<table id="reply">
							<tbody>
								<c:forEach var="reply" items="${replyList}">
									<tr>
										<td class="emp_id">${reply.emp_id}</td>
										<td class="reply_content">${reply.reply_content}</td>
										<td class="reply_dt">${reply.reply_dt }</td>
										<td class="reply_delete">
											<input type="button" value="삭제" data-num="${reply.reply_no }" id="reply_delete">
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>					
					</td>
				</tr>
				<tr>
					<td colspan="6" id="reply_input">
						<form id="reply_frm">
							<input type="text" size="80" name="reply_content" id="reply_content">
							<input type="button" value="등록" id="reply_btn">
						</form>
					</td>
				</tr>
				<tr>
					<td colspan="6" id="btn_area">
						<input type="button" value="공지사항 수정"
							onclick="location.href='NoticeServlet?command=notice_update_form&notice_no=${notice.notice_no}'">
						<input type="submit" value="공지사항 삭제" id="delete_btn">
						<input type="button" value="공지사항 리스트"
							onclick="location.href='NoticeServlet?command=notice_list'">
						<input type="button" value="공지사항 등록"
							onclick="location.href='NoticeServlet?command=notice_write_form'">
					</td>
				</tr>
			</table>
		</div>
	</div>
	<%@ include file="../common/footer.jsp" %>
</div>
</body>
</html>
