
$(function(){
	$("#proj_nm, #client, #price").blur(function(){
		if(!$(this).val()){
			$(this).next().text("필수입력")
						  .addClass("required_span");
			$(this).removeClass("fill_input")
				   .addClass("required_input");
		}else{
			$(this).next().text("");
			$(this).removeClass("required_input")
				   .addClass("fill_input");
		}
	});
	
	$("#start_dt").blur(function(){
		if(!$(this).val()){
			$("#dt_span").text("필수입력")
						 .addClass("required_span");
			$(this).removeClass("fill_input")
				   .addClass("required_input");
			
			if(!$("#end_dt").val()){//false
				$("#end_dt").removeClass("fill_input")
							.addClass("required_input");
			}else{//true
				$("#end_dt").removeClass("required_input")
							.addClass("fill_input");
			}
		}else{//true
			$(this).css("border", "2px solid #dadada");
			
			if(!$("#end_dt").val()){//false
				$("#dt_span").text("필수입력")
							 .addClass("required_span");
				$("#end_dt").removeClass("fill_input")
							.addClass("required_input");
			}else{//true
				$("#dt_span").text("");
				$("#end_dt").removeClass("required_input")
							.addClass("fill_input");
			}
		}
	});

	$("#end_dt").blur(function(){
		if(!$(this).val()){
			$("#dt_span").text("필수입력")
						 .addClass("required_span");
			$(this).removeClass("fill_input")
				   .addClass("required_input");
			
			if(!$("#start_dt").val()){//false
				$("#start_dt").removeClass("fill_input")
							  .addClass("required_input");
			}else{//true
				$("#start_dt").removeClass("required_input")
							  .addClass("fill_input");
			}
		}else{//true
			$(this).css("border", "2px solid #dadada");
			
			if(!$("#start_dt").val()){//false
				$("#dt_span").text("필수입력")
							 .addClass("required_span");
				$("#start_dt").removeClass("fill_input")
							  .addClass("required_input");
			}else{//true
				$("#dt_span").text("");
				$("#start_dt").css("border", "2px solid #dadada");
			}
		}
	});
	
	$("#delete_btn").click(function(){
		var proj_no = "${proj.proj_no}";
		
		if(confirm("정말 선택하신 항목을 삭제하시겠습니까?")){
			window.location.href="ProjectServlet?command=proj_delete&proj_no="+proj_no;
			alert("삭제에 성공하였습니다.");
		}
	});
	
	/*$("#update_btn").click(function(){
		var proj_no = "${proj.proj_no}";
		
		if(confirm("정말 선택하신 항목을 수정하시겠습니까?")){
			window.location.href="ProjectServlet?command=proj_update&proj_no="+proj_no;
			alert("수정에 성공하였습니다.");
		}
	});*/
	
});

function update_submit(){
	if(confirm("수정하시겠습니까?")){
		alert("수정에 성공하였습니다.");
		return true;
	}
	return false;
};