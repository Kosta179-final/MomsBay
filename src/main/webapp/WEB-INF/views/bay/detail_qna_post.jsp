<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% pageContext.setAttribute("newLineChar", "\n"); %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>  
<script src="${pageContext.request.contextPath}/resources/js/qna.reply.js"></script>   
<script type="text/javascript">
$(document).ready(function(){
	$("#deleteBtn").click(function(){ 
		if(confirm("게시물을 삭제하시겠습니까?")==true){
		var url = "${pageContext.request.contextPath}";
		var bayPostNo = "${requestScope.qnaPostVO.bayPostNo}";
		$("#bay").attr("action", url+"/bay/deleteQnaPost.do");
		$("#bayPostNo").attr("value",bayPostNo);
		$("#bay").submit();
		}else{
			return;
		}
	});
	
	$("#updateBtn").click(function(){  
		if(confirm("게시물을 수정하시겠습니까?")==true){
		var url = "${pageContext.request.contextPath}";
		var bayPostNo = "${requestScope.qnaPostVO.bayPostNo}";
		$("#bay").attr("action", url+"/bay/updateQnaPostView.do");
		$("#bayPostNo").attr("value",bayPostNo);
		$("#bay").submit();
		}else{
			return;
		}
	});
});	

</script>
<!-- container-fluid: 화면 너비와 상관없이 항상 100% -->
<div class="container-fluid">
  <div class="row header">
    <div class="col-sm-2" ></div>
    <div class="col-sm-8" align="right">
    </div>
    <div class="col-sm-2" ></div>
  </div>
  <div class="row main">
    <div class="col-sm-2" ></div>
    <div class="col-sm-8">
     <form action="" id="bay" method="post">
     <input type="hidden" value="${requestScope.qvo.bayPostNo}" name="bayPostNo"> 
<table  class="table">
	<tr>
			<td>글번호 : ${requestScope.qvo.bayPostNo }</td>
			<td>제목 : ${requestScope.qvo.title} </td>
			<td>작성자 : ${requestScope.qvo.memberVO.id}</td>
			<td>조회수 : ${requestScope.qvo.hits} </td>
			<td>작성일 : ${requestScope.qvo.regdate}</td>
		</tr>		
		<tr>
			<td colspan="5" class="content">
			<pre style="text-align: left;">${requestScope.qvo.content}</pre>
			</td>
		</tr>
		<tr>
			<td colspan="5" class="btnArea">
			<c:if test="${requestScope.qvo.memberVO.id==sessionScope.member.id}">
			 <button name="button" id="updateBtn" class="btn">수정</button>
			 </c:if>
			 <c:if test="${requestScope.qvo.memberVO.id==sessionScope.member.id || sessionScope.member.id eq 'sys'}">
			<input type="hidden" name="boardTypeNo" value="${requestScope.qvo.boardTypeNo}">
			 <button type="reset" id="deleteBtn" class="btn" >삭제</button>
			 </c:if>
			 </td>
		</tr>
	</table>
	</form>
	<!--                     추가                         -->
    <!--  댓글  -->
	  <label for="content">comment</label>
        <input type="hidden" id="sessionId" value="${sessionScope.member.id }"/>
        <form method="post" id="write_commentForm">
            <div class="input-group" style="margin-bottom: 15px;">
               <input type="hidden" name="bayPostNo" id="bayPostNo" value="${requestScope.qvo.bayPostNo}"/>
                <input type="hidden" id="sessionId" name="id" value="${sessionScope.member.id}"/>
               <textarea rows="1" cols="100" name="bayCommentContent" id="bayCommentContent" maxlength="300" class="form-control rep-content" required="required" placeholder="내용을 입력해주세요"></textarea>
               <span class="input-group-btn">
                    <button class="btn btn-default" type="button" id="insert">등록</button>
               </span>
                <span class="input-counter"></span>
              </div>
        </form>
        <div class="commentList"></div>
    </div>
  </div>
</div>



