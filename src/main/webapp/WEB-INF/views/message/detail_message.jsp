<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<div class="row">  	
   		<div class="col-sm-8">
   			<div class="contact-form">
   				<h2 class="title text-center">Read Message</h2>
	    		
		    	<form action="add_message.do" id="main-contact-form" class="contact-form row" name="contact-form" method="post">
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
		        </form>
		        
		        <br>
   				<div>
   				    <button type="button" class="btn btn-default">답장</button>
   				    <button type="button" class="btn btn-default">목록</button>
   				    <button type="button" class="btn btn-default">삭제</button>
	    		</div>
   			</div>
   		</div>
	</div>
</div>
<form>
</form>