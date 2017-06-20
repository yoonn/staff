/**
 * 
 */
//<![CDATA[
$(function(){
	$("#login_form input").on({
		"mouseover focus":function(){
			$(this).css("border", "5px solid #fe7d27");
		},
		"mouseout blur":function(){
			$(this).css("border", "5px solid #fea434");
		}
	});
});
//]]>