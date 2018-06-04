<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/bulletin.reply.js"></script>   
      <script type="text/javascript">
    $(document).ready(function(){
    	$("#deleteBtn").click(function(){ 
    		if(confirm("게시물을 삭제하시겠습니까?")) {
    		var url = "${pageContext.request.contextPath}";
			var bayPostNo = "${requestScope.bayPostVO.bayPostNo}";
			$("#bay").attr("action", url+"/bay/deletePost.do");
			$("#bayPostNo").attr("value",bayPostNo);
    		$("#bay").submit();
    		} else
    			return;
    	});
    	
    	$("#updateBtn").click(function(){  
    		if(confirm("게시물을 수정하시겠습니까?")==true) {
    		var url = "${pageContext.request.contextPath}";
			var bayPostNo = "${requestScope.bayPostVO.bayPostNo}";
			$("#bay").attr("action", url+"/bay/updatePostView.do");
			$("#bayPostNo").attr("value",bayPostNo);
			$("#bay").submit();
    		}else
			return;
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
    <input type="hidden" value="${requestScope.pvo.bayPostNo}" name="bayPostNo"> 
<table  class="table">
	<tr>
			<td>글번호 ${requestScope.pvo.bayPostNo }</td>
			<td>제목: ${requestScope.pvo.title} </td>
			<td>작성자:  ${requestScope.pvo.memberVO.id }</td>
			<td>조회수:  ${requestScope.pvo.hits }</td>
			<td>${requestScope.pvo.regdate }</td>
		</tr>		
		<tr>
			<td colspan="5" class="content">
			<pre>${requestScope.pvo.content}</pre>
			</td>
		</tr>
		
		<tr>
			<td colspan="5" class="btnArea">
			 <c:if test="${requestScope.pvo.memberVO.id==sessionScope.member.id}">
			 <button type="button" id="updateBtn" class="btn">수정</button>
			 </c:if>
			 <c:if test="${requestScope.pvo.memberVO.id==sessionScope.member.id}">			 
			 <input type="hidden" name="boardTypeNo" value="${requestScope.pvo.boardTypeNo}"> 
			 <button type="button" id="deleteBtn" class="btn">삭제</button>			
			 </c:if>
			 </td>
			 </tr>
	</table>
	</form>
	  		<label for="content">comment</label>
  			<input type="hidden" id="sessionId" value="${sessionScope.member.id }"/>
  			<form method="post" id="write_commentForm">
  				<div class="input-group" style="margin-bottom: 15px;">
  					<input type="hidden" name="bayPostNo" id="bayPostNo" value="${requestScope.pvo.bayPostNo }"/>
  					<input type="hidden" id="sessionId" name="id" value="${sessionScope.member.id }"/>
  					<input type="text" class="form-control" id="bayCommentContent" name="bayCommentContent" required="required" placeholder="내용을 입력해주세요">
  					<span class="input-group-btn">
  						<button class="btn btn-default" type="button" id="insert">등록</button>
  					</span>
  				</div>
  			</form>
  			<div class="commentList"></div>
    </div>
  </div>
</div>
