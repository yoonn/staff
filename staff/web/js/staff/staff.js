
//validation
$(function(){
	$("#emp_nm, #dept_no, #rank_no, #enter_dt, #emp_mobile, #emp_office, #emp_sal, #emp_pwd").blur(function(){
		if(!$(this).val()){
			$(this).next().text("필수입력");
			$(this).removeClass("fill_input")
				   .addClass("required_input");
		}else{
			$(this).next().text("");
			$(this).removeClass("required_input")
				   .addClass("fill_input");
		}
	});
	
	$("#emp_id").blur(function(){
		if(!$(this).val()){
			$(this).next().next().text("필수입력").css("color", "red");
			$(this).removeClass("fill_input")
			       .addClass("required_input");
		}else{
			$(this).next().next().text("");
			$(this).removeClass("required_input")
				   .addClass("fill_input");
		}
	});
	
	$("#res_front_num").blur(function(){
		if(!$(this).val()){
			$("#res_span").text("필수입력");
			$(this).removeClass("fill_input").addClass("required_input");
			
			if(!$("#res_back_num").val()){//false
				$("#res_back_num").removeClass("fill_input")
								  .addClass("required_input");
			}else{//true
				$("#res_back_num").removeClass("required_input")
								  .addClass("fill_input");
			}
		}else{//true
			$(this).removeClass("required_input")
				   .addClass("fill_input");
			
			if(!$("#res_back_num").val()){//false
				$("#res_span").text("필수입력");
				$("#res_back_num").removeClass("fill_input")
								  .addClass("required_input");
			}else{//true
				$("#res_span").text("");
				$("#res_back_num").removeClass("required_input")
								  .addClass("fill_input");
			}
		}
	});
	
	$("#res_back_num").blur(function(){
		if(!$(this).val()){
			$("#res_span").text("필수입력");
			$(this).removeClass("fill_input")
				   .addClass("required_input");
			
			if(!$("#res_front_num").val()){//false
				$("#res_front_num").removeClass("fill_input")
								   .addClass("required_input");
			}else{//true
				$("#res_front_num").removeClass("required_input")
								   .addClass("fill_input");
			}
		}else{//true
			$(this).removeClass("required_input")
				   .addClass("fill_input");
			
			if(!$("#res_front_num").val()){//false
				$("#res_span").text("필수입력");
				$("#res_front_num").removeClass("fill_input")
								   .addClass("required_input");
			}else{//true
				$("#res_span").text("");
				$("#res_front_num").removeClass("required_input")
								   .addClass("fill_input");
			}
		}
	});
	
	/*$(".reset").click(function(){
		var table = $(this).parents("table");
		table.find("input[type='text'], input[type='date'], textarea").val("");
	});*/
	
	$(document).on("click", ".reset", function(){
		var table = $(this).parents("table");
		table.find("input[type='text'], input[type='date'], textarea").val("");
	});
	
	$(document).on("click", ".delete", function(){
		$(this).closest("form").remove();
	});
	
	$(document).on("click", ".add", function(){
		var table = $(this).parent().prev();
		var copy_table = table.clone();
		table.before(copy_table).find("input[type='text'], input[type='date']" +
									  ", textarea, select").val("");
	});
	
	$(document).on("click", ".proj_add", function(){
		var table = $(this).closest("table");
		var copy_table = table.clone();
		table.after(copy_table);
	});
	
});