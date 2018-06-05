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
           url : 'delete_comment.do',
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
         url:"write_comment.do",
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
//댓글 글자수 카운터
$(function() {
    var maxLength = 300;

    function updateInputCount() {
        var textLength = $('textarea').val().length;
        var count = maxLength - textLength;
        $('span.input-counter').text(count+"/300");
        if (count <= 0) {
            $('span.input-counter').addClass('disabled');
            alert("입력범위를 초과하였습니다");
            $("#bayCommentContent").val('');
            $('input#input-submit').prop('disabled', true);
        } else {
            $('span.input-counter').removeClass('disabled');
            $('input#input-submit').prop('disabled', false);
        }
    }

    $('textarea')
        .focus(updateInputCount)
        .blur(updateInputCount)
        .keypress(updateInputCount);
    window.setInterval(updateInputCount, 500);

    updateInputCount();
});
function selectData(num){
   var sessionId = $("#sessionId").val();
   $.ajax({
      type:'post',
      data : {bayPostNo:num},
      url:'getBayCommentList.do',
      dataType:'json',
      cache:false,
      timeout:30000,
      success:function(data){
         console.log(data);
         var a =''; 
            $(".commentList").empty();
         $.each(data, function(index, item){ 
            a += '<div class="commentArea row" style="border-bottom:1px solid darkgray; margin-bottom: 15px;">';
                a += '<div id="bayCommentNo" class="commentInfo'+item.bayCommentNo+'  col-sm-10 text-left">'+'작성자 : '+item.id+' / '+item.bayCommentRegdate+'</div>';
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
function formUpdate(cno, content){
    var a ='';
  
    a += '<div class="input-group">';
    a += '<input type="text" class="form-control" name="content_'+cno+'" value="'+content+'"/>';
    a += '<span class="input-group-btn"><button class="btn btn-default" type="button" onclick="commentUpdate('+cno+');">수정</button> </span>';
    a += '</div>';
    
    $('.commentContent'+cno).html(a);
    
}
//함수 정의문
function commentUpdate(commentNo){
   var bayPostNo = $("#bayPostNo").val();
   var updateContent = $('[name=content_'+commentNo+']').val();
   $.ajax({
        type : 'post',
        data:{bayCommentNo:commentNo, bayCommentContent:updateContent},
        url : 'update_comment.do',
        dateType:'json',
        cache:false,
        timeout:30000,
        success : function(){
           selectData(bayPostNo);
        },
        error:function(){
         alert('댓글 내용을 작성 해 주세요!');
      }
    });
}