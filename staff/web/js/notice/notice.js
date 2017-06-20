
/*$(function(){
	
	$("#delete_btn").click(function(){
		var notice_no = "${notice.notice_no }";
		
		if(confirm("정말 선택하신 항목을 삭제하시겠습니까?")){
			window.location.href="NoticeServlet?command=notice_delete&notice_no="+notice_no;
			alert("삭제에 성공하였습니다.");
		}
	});
	
});*/

function noticeCheck(){
	if(document.frm.name.value.length == 0){
		alert("작성자를 입력하세요.");
		return false;
	}
	
	if(document.frm.pass.value.length == 0){
		alert("비밀번호를 입력하세요.");
		return false;
	}
	
	if(document.frm.title.value.length == 0){
		alert("제목을 입력하세요.");
		return false;
	}
	return true;
}

function open_win(url, name){
	window.open(url, name, "width=500, height=230");
}

function passCheck(){
	if(document.frm.pass.value.length == 0){
		alert("비밀번호를 입력하세요.");
		return false;
	}
	return true;
}