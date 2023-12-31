updateHeader();

function postBoard(){
	

	// [기존] let formData = $('#memberInfo').serialize();
	// [Controller 파라미터 전달 시 (Map) 사용]
	let formData = {
        btitle: $("input[name=btitle]").val(),
        bcontent: $("textarea[name=bcontent]").val()
    };
	
	/* 게시글 등록 */
	$.ajax({
		url: "/postBoard",
		method: "post",
		data: JSON.stringify(formData),
		contentType: "application/json",
		async: false,
		success: result => {
			
			if( result ){
				alert('게시글 수정에 성공했습니다')
			} else {
				alert('게시글 수정에 실패했습니다')
				return;
			}
			
		},
		error : e => {
			console.log(e)
		}
		
	})
	
	window.location.href = "/board?page=1";
	
}

$('.buttonBox input[type="button"]').on('click', postBoard);