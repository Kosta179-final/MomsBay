<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
$(document).ready(function(){
	$("#receiveId").autocomplete({
		source : "${pageContext.request.contextPath}/admin/searchMemberById.do?",
		minLength : 2
	});
});
</script>
<div class="container">
	<div class="row">  	
   		<div class="col-sm-8">
   			<div class="contact-form">
   				<h2 class="title text-center">Add Message</h2>
   				<div class="status alert alert-success" style="display: none"></div>
		    	<form action="add_message.do" id="main-contact-form" class="contact-form row" name="contact-form" method="post">
		            <div class="form-group col-md-6">
		            	<span>보내는 사람</span>
		                <input type="text" name="memberVO.id" class="form-control" readonly="readonly" required="required" value="${sessionScope.member.id }">
		            </div>
		            <div class="form-group col-md-6">
		            	<span>받는 사람</span>
		                <input type="text" id="receiveId" name="receiveMemberVO.id" class="form-control" required="required" value="${requestScope.receiveId }">
		            </div>
		            <div class="form-group col-md-12">
		                <input type="text" name="title" class="form-control" required="required" placeholder="제목">
		            </div>
		            <div class="form-group col-md-12">
		                <textarea name="content" id="message" required="required" class="form-control" rows="8" placeholder="메세지를 입력하세요"></textarea>
		            </div>                        
		            <div class="form-group col-md-12">
		                <input type="submit" name="submit" class="btn btn-primary pull-right" value="전송">
		            </div>
		        </form>
   			</div>
   		</div>
	</div>
</div>
<form>
</form>