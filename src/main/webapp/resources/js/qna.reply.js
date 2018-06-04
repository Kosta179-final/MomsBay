/**
 * 
 */
$(document).ready(function(){
	//함수 호출문
	var bayPostNo = $("#bayPostNo").val();
	selectData(parseInt(bayPostNo));
	
	$(document).on("click", "#deleteComment", function(){
		var target =event.target;
		deleteComment(target);
	});
	$(document).on("click", "#insert", function(event){
		var target = event.target;
		insertComment();
		$("#bayCommentContent").val("");
		
	});
});
function deleteComment(target){
	var commentNo = parseInt(target.getAttribute("data-value"));
	var bayPostNo = $("#bayPostNo").val();
	$.ajax({
	        type : 'post',
	        data:{bayCommentNo:commentNo},
	        url : 'deleteComment.do',
	        dateType:'json',
	        cache:false,
	        timeout:30000,
	        success : function(){
	        	selectData(bayPostNo);
	        },
	        error:function(){
				alert('댓글 삭제시 네트워크 오류!');
			}
	    });
}
function insertComment(){
      var formData = $("#write_commentForm").serialize();
      var bayPostNo = $("#bayPostNo").val();
      if($("#bayCommentContent").val()==''){
     	 alert("댓글 내용을 작성 해 주세요");
      }else{
      $.ajax({
         type:'post',
         data:formData,
         url:"addQnaComment.do",
         dataType:'json',
         success:function(){
            selectData(bayPostNo);
         },
         error:function(request,error){
			alert('댓글 작성 오류!');
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
         }
      });
      }
   }
function selectData(num){
	var sessionId = $("#sessionId").val();
	$.ajax({
		type:'post',
		data : {bayPostNo:num},
		url:'getQnaCommentList.do',
		dataType:'json',
		cache:false,
		timeout:30000,
		success:function(data){
			console.log(data);
			var a =''; 
            $(".commentList").empty();
			$.each(data, function(index, item){ 
				a += '<div class="commentArea row" style="border-bottom:1px solid darkgray; margin-bottom: 15px;">';
                a += '<div id="bayCommentNo" class="commentInfo'+item.bayCommentNo+'  col-sm-10 text-left">'+'댓글번호 : '+item.bayCommentNo+' / 작성자 : '+item.id+'</div>';
                if(item.id == sessionId){
                	a += '<div><a id="updateComment" class="col-sm-1 text-right" onclick="formUpdate('+item.bayCommentNo+',\''+item.bayCommentContent+'\');"> 수정 </a>';
                	a += '<a id="deleteComment" class="col-sm-1 text-right" data-value='+item.bayCommentNo+'> 삭제 </a></div>';
                }
                a += '<div id ="commentContent'+item.bayCommentNo+'" class="commentContent'+item.bayCommentNo+' col-sm-10 text-left"> <p> 내용 : '+item.bayCommentContent +'</p>';
                a += '</div></div>';
            });
            
            $(".commentList").append(a);
		}
	});
}

//댓글 수정 - 댓글 내용 출력을 input 폼으로 변경 
function formUpdate(bayCommentNo, content){
    var a ='';
  
    a += '<div class="input-group">';
    a += '<input type="text" class="form-control" name="content_'+bayCommentNo+'" value="'+content+'"/>';
    a += '<span class="input-group-btn"><button class="btn btn-default" type="button" onclick="commentUpdate('+bayCommentNo+');">수정</button> </span>';
    a += '</div>';
    
    $('.commentContent'+bayCommentNo).html(a);
    
}
//함수 정의문
function commentUpdate(bayCommentNo){
	var bayPostNo = $("#bayPostNo").val();
	var updateContent = $('[name=content_'+bayCommentNo+']').val();
	$.ajax({
        type : 'post',
        data:{bayCommentNo:bayCommentNo, bayCommentContent:updateContent},
        url : 'updateComment.do',
        dateType:'json',
        cache:false,
        timeout:30000,
        success : function(){
        	selectData(bayPostNo);
        },
        error:function(){
			alert('댓글 수정시 네트워크 오류!');
		}
    });
}
