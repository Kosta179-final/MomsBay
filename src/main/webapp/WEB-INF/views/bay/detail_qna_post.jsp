<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<script type="text/javascript">
    $(document).ready(function(){
    	$("#deleteBtn").click(function(){ 
    		if(confirm("게시물을 삭제하시겠습니까?")){
    			location.href="deleteQnaPost.do?bayPostNo=${qvo.bayPostNo}&boardTypeNo=${qvo.boardTypeNo}";
    		}
    	});
    });	
    	function updateQnaPost() {
    		if(confirm("글수정 페이지로 이동 하시겠습니까?")==true){
    			location.href="updateQnaPostView.do?bayPostNo="+${requestScope.qvo.bayPostNo};
    		}else{
    			return;			
    		}
    	}
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
    
<table  class="table">
	<tr>
			<td>글번호 ${requestScope.qvo.bayPostNo }</td>
			<td>제목: ${requestScope.qvo.title} </td>
			<td>작성자:  ${requestScope.qvo.memberVO.id }</td>
			<td>${requestScope.qvo.regdate}</td>
		</tr>		
		<tr>
			<td colspan="5" class="content">
			<pre>${requestScope.qvo.content}</pre>
			</td>
		</tr>
		<tr>
			<td colspan="5" class="btnArea">
			 <c:if test="${requestScope.qvo.memberVO.id==sessionScope.member.id}">
			 <input type="button" class="btn" onclick="updateQnaPost()" value="수정">
			 <input type="button" name="button" id="deleteBtn" class="btn" value="삭제">
			 </c:if>
			 </td>
		</tr>
	</table>
    </div>
    <div class="col-sm-2" ></div>
  </div>
</div>