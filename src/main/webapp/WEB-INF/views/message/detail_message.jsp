<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(document).ready(function(){
		$('#reply_btn').click(function(){
			location.href='add_message_form.do?receiveId=${requestScope.messageVO.memberVO.id}';
		});
		
		$('#list_btn').click(function(){
			history.back();
		});
		
		$('#delete_btn').click(function(){
			location.href='delete_message.do?messageNo=${param.messageNo }&messageType=${param.messageType }';
		});
	});
	
</script>
<div class="container">
	<div class="row">  	
   		<div class="col-sm-8">
   			<div class="contact-form">
   				<h2 class="title text-center">Read Message</h2>
		    		<br>
            		<div class="form-group col-md-3">
	                	글번호<input type="text" name="name" class="form-control" readonly="readonly" value="${param.messageNo }">
		            </div>
		            <div class="form-group col-md-3">
		               	보낸사람<input type="text" name="name" class="form-control" readonly="readonly" value="${requestScope.messageVO.memberVO.id}">
		            </div>
		            <div class="form-group col-md-3">
	                	받는사람<input type="email" name="email" class="form-control" readonly="readonly" value="${requestScope.messageVO.receiveMemberVO.id}">
		            </div>
		            <div class="form-group col-md-3">
	                	보낸시간<input type="text" name="name" class="form-control" readonly="readonly" value="${requestScope.messageVO.regdate}">
		            </div>
		            <div class="form-group col-md-12">
                		제목<input type="text" name="subject" class="form-control" readonly="readonly" value="${requestScope.messageVO.title}">
		            </div>
		            <div class="form-group col-md-12">
	                	내용<textarea name="message" id="message" required="required" readonly="readonly" class="form-control" rows="8">${requestScope.messageVO.content}</textarea>
		            </div>       
		        <br>
   				<div>
   				    <button id="reply_btn" type="button" class="btn btn-default">답장</button>
   				    <button id="list_btn" type="button" class="btn btn-default">목록</button>
 				    <button id="delete_btn" type="button" class="btn btn-default">삭제</button>
	    		</div>
   			</div>
   		</div>
	</div>
</div>
