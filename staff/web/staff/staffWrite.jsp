<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>staffRegForm</title>
<link rel="stylesheet" type="text/css" href="../css/staff/staff.css"/>
<link rel="stylesheet" type="text/css" href="../css/common/js.css"/>
<script type="text/javascript" src="../js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="../js/common/hover.js"></script>
<script type="text/javascript" src="../js/staff/staff.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<script type="text/javascript">
/* $(function) start */
	$(function(){
		
		$(".tab_content").hide(); //Hide all content
		$("#tab_list li:first").addClass("active"); //Activate first tab
		$(".tab_content:first").show(); //Show first tab content

		//On Click Event
		$("ul li").click(function() {

			$("ul li").removeClass("active"); //Remove any "active" class
			$(this).addClass("active"); //Add "active" class to selected tab
			$(".tab_content").hide(); //Hide all tab content

			var activeTab = $(this).find("a").attr("href"); //Find the href attribute value to identify the active tab + content
			$(activeTab).show(); //Fade in the active ID content
			return false;
		});
		
		/* 사원정보 저장  start*/
		$("#empSubmit").click(function(){
			var formData1 = $("#empFrm").serialize();
			var id_check = $("#idCheck").val();
			
			var emp_no;
			
			if(id_check == "1"){
				alert("id 중복체크를 해주세요");
				return false;
			}
			
			/* 사원정보 ajax start */
			$.ajax({
				  url : "StaffServlet?command=staff_write"
				, type : "post"
				, data : formData1
				, enctype : "multipart/form-data"
				, datatype : "json"
				, cache : false
				, success : function(data){
					emp_no = data;
					if(emp_no == null){
						alert("다시 입력해 주세요");
					}else{
						alert("사원정보 저장");
						
						/* 각 form에 emp_no 저장 */
						/* $("#img_emp_id").attr("value", emp_no); */
						$("#img_emp_no").attr("value", emp_no);
						$("#acad_emp_no").attr("value", emp_no);
						$("#car_emp_no").attr("value", emp_no);
						$("#proj_emp_no").attr("value", emp_no);
						$("#lic_emp_no").attr("value", emp_no);
						$("#skill_emp_no").attr("value", emp_no);
					}
				}, error : function(xhr, textStatus, errorThrown){
					alert("error : " + textStatus + " " + xhr.status + " " + errorThrown);
				}
			});
			/* 사원정보 ajax end */
			
			alert(emp_no);
			var formData2 = new FormData();
			formData2.append("emp_no", emp_no);
			formData2.append("file_request_url", $("input[name=file_request_url]")[0].files[0]);
			
			$.ajax({
				  url : "StaffServlet?command=picture_upload"
				, type : "post"
				, data : formData2
				, processData: false
				, contentType: false
				,success : function(){
					alert("success");
				}, error : function(xhr, textStatus, errorThrown){
					alert(textStatus + xhr.status + errorThrown);
				}
			});
			
		});
		/* 사원정보저장 end */
		
		$("#file_submit").click(function(){
			
			var formData = new FormData();
			formData.append("emp_no", $("input[id=img_emp_no]").val());
			formData.append("file_request_url", $("input[name=file_request_url]")[0].files[0]);
			
			alert($("input[name=file_request_url]")[0].files[0]);
			
			$.ajax({
				  url : "StaffServlet?command=picture_upload"
				, type : "post"
				, data : formData
				, processData: false
				, contentType: false
				,success : function(){
					alert("success");
				}, error : function(xhr, textStatus, errorThrown){
					alert(textStatus + xhr.status + errorThrown);
				}
			});
		});
		
		/* 학력정보저장 start */
		$(document).on("click", "#acad_add", function(){
			
			var formData = $("#acadFrm:last").serialize();
			
			/* 학력정보 ajax start */
			$.ajax({
				  url : "StaffServlet?command=acad_write"
				, type : "post"
				, data : formData
				, datatype : "json"
				, cache : false
				, success : function(){
					alert("학력 저장");					
				}, error : function(xhr, textStatus, errorThrown){
					alert(textStatus + " " + xhr.status + " " + errorThrown);
				}
			});			
			/* 학력정보저장 ajax end */
		});
		/* 학력정보저장 end */
		
		/* 경력정보저장 start */
		$(document).on("click", "#car_add", function(){
			
			var formData = $("#carFrm:last").serialize();
		
			/* 경력정보 ajax start */
			$.ajax({
				  url: "StaffServlet?command=car_write"
				, type : "post"
				, data : formData
				, datatype : "json"
				, cache : false
				, success : function(){
					alert("경력 저장");
				}, error : function(xhr, textStatus, errorThrown){
					alert(xhr.status + " " + textStatus + " " + errorThrown);
				}
			});
			/* 경력정보 ajax end */
		});
		/* 경력정보저장 end */
		
		/* 프로젝트정보저장 start */
		$(document).on("click", "#proj_add", function(){
			
			var formData = $("#projFrm:last").serialize();
		
			/* 프로젝트 ajax start */
			$.ajax({
				  url : "StaffServlet?command=car_proj_write"
				, type : "post"
				, data : formData
				, datatype : "json"
				, cache : false
				, success : function(){
					alert("프로젝트 저장");
				}, error : function(xhr, textStatus, errorThrown){
					alert(textStatus + " " + xhr.status + " " + errorThrown);
				}
			});
			/* 프로젝트 ajax end */
		});
		/* 프로젝트정보저장 end */
		
		/* 자젹증정보저장 start */
		$(document).on("click", "#lic_add", function(){
			var formData = $("#licFrm:last").serialize();
		
			/* 자격증 ajax start */
			$.ajax({
				  url : "StaffServlet?command=lic_write"
				, type : "post"
				, data : formData
				, datatype : "json"
				, cache : false
				, success : function(){
					alert("자격증 저장");
				}, error : function(xhr, textStatus, errorThrown){
					alert(textStatus + " " + xhr.status + " " + errorThrown);
				}
			});
			/* 자격증 ajax end */
		});
		/* 자격증정보저장 end */
		
		/* 아이디중복체크 start */
		$("#id_check").click(function(){
			var emp_id = $("#emp_id");
			
			/* 중복체크 ajax start */
			$.ajax({
				  url : "StaffServlet?command=id_check"
				, type : "post"
				, data : emp_id
				, cache : false
				, success : function(data){
					var result = data
					
					if(result == 1){
						$("#id_check").next().text("중복된 아이디").css("color", "red");
						$("#id_check").prev().removeClass("fill_input")
											 .addClass("required_input");
						$("#idCheck").attr("value", "1");
					}else if(result == 0){
						$("#id_check").next().text("사용가능").css("color", "black");
						$("#id_check").prev().removeClass("required_input")
											 .addClass("fill_input");
						$("#idCheck").attr("value", "0");
					}
				}, error : function(xhr, textStatus, errorThrown){
					alert(textStatus + " " + xhr.status + " " + errorThrown);
				}
			});
			/* 중복체크 ajax end */
		});
		/* 중복체크 end */
		
		/* 다음 api 우편 번호  function start*/
		$("#post").click(function(){
	        new daum.Postcode({
	            oncomplete: function(data) {
	                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
	
	                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
	                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                var fullAddr = ''; // 최종 주소 변수
	                var extraAddr = ''; // 조합형 주소 변수
	
	                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
	                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                    fullAddr = data.roadAddress;
	
	                } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                    fullAddr = data.jibunAddress;
	                }
	
	                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
	                if(data.userSelectedType === 'R'){
	                    //법정동명이 있을 경우 추가한다.
	                    if(data.bname !== ''){
	                        extraAddr += data.bname;
	                    }
	                    // 건물명이 있을 경우 추가한다.
	                    if(data.buildingName !== ''){
	                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                    }
	                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
	                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
	                }
	
	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                document.getElementById('postCode').value = data.zonecode; //5자리 새우편번호 사용
	                document.getElementById('emp_addr').value = fullAddr;
	                
	                // 커서를 상세주소 필드로 이동한다.
	                document.getElementById('emp_detail_addr').focus();
	                
	            }
	        }).open();
		});
		/* 다음 api end */
		
		/* 스킬정보저장 start */
		$(document).on("click", "#skill_add", function(){
			
			var skill_no;
			var type = $("#skill_type");
			if(type.val() == "a"){
				skill_no = $("#a_skill").val();
			}else if(type.val() == "b"){
				skill_no = $("#b_skill").val();
			}
			
			/* var formData = new FormData();
			formData.append("emp_no", $("#skill_emp_no"));
			formData.append("skill_no", skill_no);
			formData.append("skill_level", $("#skill_level"));
			
			alert(formData); */
			
			alert("emp_no : " + $("#skill_emp_no").val());
			alert("skill_no : " + skill_no);
			alert("skill_level : " + $("#skill_level").val());
			
			$.ajax({
				  url : "StaffServlet?command=skill_write"
				, type : "post"
				, data : {
					  emp_no : $("#skill_emp_no").val()
					, skill_no : skill_no
					, skill_level : $("#skill_level").val()
				}
				, datatype : "json"
				, processData: false
	        	, contentType: false
				, cache : false
				, success : function(){
					alert("스킬 저장");
				}, error : function(xhr, textStatus, errorThrown){
					alert(textStatus + " " + xhr.status + " " + errorThrown);
				}
			});
		});
		
		/* skill change function */
		$("#a_skill").css("display", "none");
		$("#b_skill").css("display", "none");
		
	});
/* $(function) end */


	/* skill change function start*/
	function change_skill(){
		var type = $("#skill_type");
		
		if(type.val() == "x"){
			$("#select_skill").css("display", "");
			$("#a_skill").css("display", "none");
			$("#b_skill").css("display", "none");
		}else if(type.val() == "a"){
			$("#select_skill").css("display", "none");
			$("#a_skill").css("display", "");
			$("#b_skill").css("display", "none");
		}else if(type.val() == "b"){
			$("#select_skill").css("display", "none");
			$("#a_skill").css("display", "none");
			$("#b_skill").css("display", "");
		}
	}
	
</script>


</head>
<body>

	<c:set var="now" value="<%= new Date() %>"/>
	<div id="wrap">
	
		<%@ include file="../common/header.jsp" %>
		<%@ include file="../common/menu.jsp" %>
		
		<div id="content">
			<span id="title">사원정보 등록</span>
			<div id="tab_list">
				<ul>
					<li><a href="#emp">개인정보</a></li>
					<li><a href="#acad">학력정보</a></li>
					<li><a href="#career">경력정보</a></li>
					<li><a href="#proj">프로젝트</a></li>
					<li><a href="#lic">자격증</a></li>
				</ul>
			</div>
			<div id="tab_container">
				<div id="emp" class="tab_content">
					<span class="small_title">
							개인정보
					</span>
					<form name="empFrm" id="empFrm">
						<input type="hidden" value="${login.emp_id }" name="res_emp">
						<input type="hidden" value="1" id="idCheck">
						<div id="img_d">
							<div>
								<img id="img_profile" src="../images/staff/noimage.png">
							</div>
							<div id="img_btn">
								<input type="file" name="img_file">
							</div>
						</div>
						<table>
							<tr id="top">
								<td class="info">
									이름
								</td>
								<td class="input">
									<input type="text" id="emp_nm" name="emp_nm" size="20" class="fill_input"/>
									<span id="name_span" class="required_span"></span>
								</td>
							</tr>
							<tr>
								<td class="info">
									주민번호
								</td>
								<td class="input">
									<input type="text" id="res_front_num" name="res_front_num" maxlength="6" size="5" class="fill_input"/>
									-
									<input type="text" id="res_back_num" name="res_back_num" maxlength="7" size="5" class="fill_input"/>
									<span id="res_span" class="required_span"></span>
								</td>
							</tr>
							<tr>
								<td class="info">
									ID
								</td>
								<td class="input">
									<input type="text" id="emp_id" name="emp_id" class="fill_input">
									<input type="button" id="id_check" name="id_check" value="중복체크">
									<span class="required_span"></span>
								</td>
							</tr>
							<tr>
								<td class="info">
									부서
								</td>
								<td class="input">
									<select id="dept_no" name="dept_no" class="fill_input">
										<option value="">&nbsp;부서선택&nbsp;</option>
										<option value="0">경영</option>
										<option value="1">전산</option>
										<option value="2">회계</option>
									</select>
									<span id="dept_span" class="required_span"></span>
								</td>
							</tr>
							<tr>
								<td class="info">
									직급
								</td>
								<td class="input">
									<select id="rank_no" name="rank_no" class="fill_input">
										<option value="">&nbsp;직급선택&nbsp;</option>
										<option value="0">사장</option>
										<option value="1">부장</option>
										<option value="2">사원</option>
									</select>
									<span id="rank_span" class="required_span"></span>
								</td>
							</tr>
							<tr>
								<td class="info">
									입사일
								</td>
								<td class="input">
									<input type="date" id="enter_dt" name="enter_dt" class="fill_input"/>
									<span id="join_span" class="required_span"></span>
								</td>
							</tr>
							<!-- <tr>
								<td class="info">
									퇴사일
								</td>
								<td class="input">
									<input type="date" id="retire_dt" name="retire_dt" class="fill_input"/>
								</td>
							</tr> -->
							<tr>
								<td class="info">
									핸드폰
								</td>
								<td class="input">
									<input type="text" id="emp_mobile" name="emp_mobile" class="fill_input"/>
									<span id="mobile_span" class="required_span"></span>
								</td>
							</tr>
							<tr>
								<td class="info">
									내선
								</td>
								<td class="input">
									<input type="text" id="emp_office" name="emp_office" class="fill_input"/>
									<span id="office_span" class="required_span"></span>
								</td>
							</tr>
							<tr>
								<td class="info">
									우편번호
								</td>
								<td class="input">
									<input type="text" disabled="disabled" id="postCode" name="postCode" size="10" class="fill_input"/>
									<input type="button" value="검색" id="post">
								</td>
							</tr>
							<tr>
								<td class="info">
									주소
								</td>
								<td class="input">
									<input type="text" disabled="disabled" id="emp_addr" name="emp_addr" size="50" class="fill_input"/>
								</td>
							</tr>
							<tr>
								<td class="info">
									상세주소
								</td>
								<td class="input">
									<input type="text" id="emp_detail_addr" name="emp_detail_addr" size="50" class="fill_input"/>
								</td>
							</tr>
							<tr>
								<td class="info">
									급여
								</td>
								<td class="input">
									<input type="text" id="emp_sal" name="emp_sal" size="10" class="fill_input"/>원
									<span id="sal_span" class="required_span"></span>
								</td>
							</tr>
							<tr>
								<td class="info">
									등록일
								</td>
								<td class="input">
									<input type="date" name="res_dt" value='<fmt:formatDate value="${now }" pattern="yyyy-MM-dd"/>' class="fill_input"/>
								</td>
							</tr>
							<tr>
								<td class="info">
									권한
								</td>
								<td class="input">
									<input type="radio" name="notice_mgr" id="notice_mgr" value="1" checked="checked">사원
									<input type="radio" name="notice_mgr" id="notice_mgr" value="0">관리자
								</td>
							</tr>
							<tr>
								<td colspan="3" id="input_btn">
									<input type="button" value="저장" id="empSubmit"/>
									&nbsp;&nbsp;
									<input type="button" value="초기화" class="reset"/>
								</td>
							</tr>
						</table>
					</form>
				</div>
		
				<div id="acad" class="tab_content">
					<span class="small_title">
						학력사항
					</span>
					<form name="acadFrm" id="acadFrm">
						<input type="hidden" name="emp_no" id="acad_emp_no" value="">
						<table>
							<tr class="sub_title">
								<td colspan="2" class="right">
									<input type="button" value="추가" id="acad_add" class="add">
									<input type="button" value="초기화" class="reset"/>
									<input type="button" value="삭제"  class="delete"/>
								</td>
							</tr>
							<tr>
								<td class="info">
									분류
								</td>
								<td class="input">
									<input type="radio" name="acad_level_no" value="0" checked="checked">고등학교
									&nbsp;&nbsp;
									<input type="radio" name="acad_level_no" value="1">대학(2,3년제)
									&nbsp;&nbsp;
									<input type="radio" name="acad_level_no" value="2">대학교
									&nbsp;&nbsp;
									<input type="radio" name="acad_level_no" value="3">대학원
								</td>
							</tr>
							<tr>
								<td class="info">
									학교명
								</td>
								<td class="input">
									<input type="text" name="acad_nm" id="acad_nm" size="60" class="fill_input">
								</td>
							</tr>
							<tr>
								<td class="info">
									재학기간
								</td>
								<td class="input">
									<input type="date" name="enter_dt" id="enter_dt" class="fill_input">
									&nbsp;~&nbsp;
									<input type="date" name="graduation_dt" id="graduaction_dt" class="fill_input">
									&nbsp;&nbsp;
									<select class="fill_input" name="acad_state_no"	>
										<!-- <option selected="selected" value="">상태</option> -->
										<option value="0">졸업</option>
										<option value="1">휴학</option>
										<option value="2">재학</option>
										<option value="3">퇴학</option>
									</select>
								</td>
							</tr>
							<tr>
								<td class="info">
									전공
								</td>
								<td class="input">
									<input type="text" name="major_nm" id="major_nm" size="60" class="fill_input">
								</td>
							</tr>
							<tr>
								<td class="info">
									학점
								</td>
								<td class="input">
									<input type="text" name="grade" id="grade" class="fill_input">
									/
									<select class="fill_input" name="perfect_grade">
										<!-- <option selected="selected" value="">학점</option> -->
										<option value="4.5">4.5</option>
										<option value="4.3">4.3</option>
										<option value="4.0">4.0</option>
										<option value="100">100</option>
									</select>
								</td>
							</tr>
							<tr>
								<td class="info">
									졸업 증명서
								</td>
								<td class="input">
									<input type="text" disabled="disabled" class="fill_input" size=50>
									<input type="button" value="파일선택" onclick="return chooseFile()">
								</td>
							</tr>
						</table>
					</form>
					
				</div>
		
				<div id="career" class="tab_content">
					<span class="small_title">
						경력사항
					</span>
					
					<form name="carFrm" id="carFrm">
						<input type="hidden" name="emp_no" id="car_emp_no" value="">
						<table>
							<tr class="sub_title">
								<td colspan="5" class="right">
									<input type="button" value="추가" id="car_add"  class="add">
									<input type="button" value="초기화" class="reset"/>
									<input type="button" value="삭제"  class="delete"/>
								</td>
							</tr>
							<tr>
								<td class="info">
									회사명
								</td>
								<td colspan="3" class="input">
									<input type="text" size="60" name="corp_nm" class="fill_input">
								</td>
							</tr>
							<tr>
								<td class="info">
									근무기간
								</td>
								<td colspan="3" class="input">
									<input type="date" class="fill_input" name="enter_dt">
									&nbsp;~&nbsp;
									<input type="date" class="fill_input" name="retire_dt">
								</td>
							</tr>
							<tr>
								<td class="info">
									부서명
								</td>
								<td class="input">
									<input type="text" class="fill_input" name="dept_nm">
								</td>
								<td class="info">
									직책
								</td>
								<td class="input">
									<input type="text" class="fill_input" name="rank_nm">
								</td>
							</tr><tr>
								<td class="info">
									급여
								</td>
								<td class="input">
									<input type="text" class="fill_input" name="emp_sal">
								</td>
								<td class="info">
									직무
								</td>
								<td class="input">
									<input type="text" class="fill_input" name="emp_role">
								</td>
							</tr>
							<tr>
								<td class="info">
									경력증명서
								</td>
								<td colspan="3" class="input">
									<input type="text" disabled="disabled" class="fill_input" size=50 name="certificate_img_path">
									<input type="button" value="파일선택" onclick="return chooseFile()">
								</td>
							</tr>
						</table>
					</form>
					
				</div>
							
				<div id="proj" class="tab_content">
					<span class="small_title">
						진행 프로젝트
					</span>
					<span class="comment">
						* 경력사항에 기술한 회사에서 진행한 프로젝트만 기술하여 주십시오
					</span>
					
					<form name="projFrm" id="projFrm">
						<input type="hidden" name="emp_no" id="proj_emp_no" value="">
						<table id="proj">
							<tr class="sub_title">
								<td colspan="2" class="right">
									<input type="button" value="추가" id="proj_add"  class="add">
									<input type="button" value="초기화" class="reset"/>
									<input type="button" value="삭제"  class="delete"/>
								</td>
							</tr>
							<tr>
								<td class="info">
									회사명
								</td>
								<td>
									<input type="text" class="fill_input" name="corp_nm" size=60>
								</td>
							</tr>
							<tr>
								<td class="info">
									프로젝트명
								</td>
								<td class="input">
									<input type="text" class="fill_input" name="proj_nm" size=60>
								</td>
							</tr>
							<tr>
								<td class="info">
									역할
								</td>
								<td class="input">
									<input type="text" class="fill_input" name="role_nm" size=60>
								</td>
							</tr>
							<tr>
								<td class="info">
									진행기간
								</td>
								<td class="input">
									<input type="date" class="fill_input" name="start_dt">
									&nbsp;~&nbsp;
									<input type="date" class="fill_input" name="end_dt">
								</td>
							</tr>
							<tr>
								<td class="info">
									상세 내용
								</td>
								<td class="input">
									<textarea rows="3" cols="68" name="proj_content"></textarea>
								</td>
							</tr>
						</table>
					</form>
					
					
				</div>
		
				<div id="lic" class="tab_content">
					<span class="small_title">
						자격증
					</span>
					
					<form id="licFrm" class="licFrm">
						<input type="hidden" name="emp_no" id="lic_emp_no" value="">
						<table>
							<tr class="sub_title">
								<td colspan="4" class="right">
									<input type="button" value="추가" id="lic_add" class="add">
									<input type="button" value="초기화" class="reset"/>
									<input type="button" value="삭제"  class="delete"/>
								</td>
							</tr>
							<tr>
								<td class="info">
									자격증명
								</td>
								<td colspan="3" class="input">
									<input type="text" size="60" class="fill_input" name="lic_nm">
								</td>
							</tr>
							<tr>
								<td class="info">
									자격증 번호
								</td>
								<td class="input">
									<input type="text" class="fill_input" name="lic_no">
								</td>
								<td class="info">
									발행처
								</td>
								<td class="input">
									<input type="text" class="fill_input" name="institution">
								</td>
							</tr>
							<tr>
								<td class="info">
									취급일
								</td>
								<td class="input">
									<input type="date" class="fill_input" name="get_dt">
								</td>
								<td class="info">
									만료일
								</td>
								<td class="input">
									<input type="date" class="fill_input" name="expiration_dt">
								</td>
							</tr>
							<tr>
								<td class="info">
									자격증 증명서
								</td>
								<td colspan="3" class="input">
									<input type="text" disabled="disabled" class="fill_input" size=50 name="certificate_img_path">
									<input type="button" value="파일선택" onclick="return chooseFile()">
								</td>
							</tr>
						</table>
					</form>
				</div>
				
				<!-- <div id="skill">
					<span class="small_title">
						기술
					</span>
					
					<form id="skillFrm" class="skillFrm">
						<input type="hidden" name="emp_no" id="skill_emp_no" value="111">
						<table>
							<tr class="sub_title">
								<td colspan="2" class="right">
									<input type="button" value="초기화" class="reset"/>
									<input type="button" value="삭제"  class="delete"/>
								</td>
							</tr>
							<tr>
								<td class="info">
									기술
								</td>
								<td class="input">
									<select name="skill_type" id="skill_type" onchange="change_skill()">
										<option value="x" selected="selected">선택</option>
										<option value="a">분석</option>
										<option value="b">개발</option>
									</select>
									<select id="select_skill">
										<option>선택</option>
									</select>
									<select name="skill_no" id="a_skill">
										<option value="a1">알</option>
										<option value="a2">하둡</option>
										<option value="a3">파이선</option>
									</select>
									<select name="skill_no" id="b_skill">
										<option value="b1">자바</option>
										<option value="b2">씨</option>
										<option value="b3">씨++</option>
									</select>
								</td>
							</tr>
							<tr>
								<td class="info">
									숙련도
								</td>
								<td class="input">
									<input type="radio" value="C" name="skill_level" id="skill_level">초급
									&nbsp;
									<input type="radio" value="B" name="skill_level" id="skill_level">중급
									&nbsp;
									<input type="radio" value="A" name="skill_level" id="skill_level">고급
									&nbsp;
									<input type="radio" value="S" name="skill_level" id="skill_level">고고급
								</td>
							</tr>
						</table>
					</form>
					<div class="add_btn">
						<input type="button" value="추가" id="skill_add" class="add">
					</div>
				</div> -->
			</div>
			
		</div>
			
		<%@ include file="../common/footer.jsp" %>
	
	</div>

</body>
</html>
