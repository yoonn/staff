//<![CDATA[
$(function(){
	$(".hover").on({
		"mouseover focus":function(){
			$(this).css("color", "#5f5f5f");
			$(this).css("font-weight", "bold");
		},
		"mouseout blur":function(){
			$(this).css("color", "#7d7d7d");
			$(this).css("font-weight", "normal");
		}
	});
});
//]]>