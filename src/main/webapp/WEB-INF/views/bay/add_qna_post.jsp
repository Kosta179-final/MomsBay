<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<div class="container">
	<div class="row">
		<form action="qna_write.do" method="post">
		<div class="col-sm-2">
				<select name="subjectNo">
					<option value="1">후기</option>
					<option value="2">팁</option>
					<option value="3">고민상담</option>
				</select>	
			</div>
			<div class="col-sm-8">
				<textarea cols="90" rows="1" name="title" required="required"
						placeholder="제목을 입력하세요"></textarea>
			</div>
			<br><br>
			<textarea cols="90" rows="15" name="content" required="required"
						placeholder="내용을 입력하세요"></textarea>
			<input type="hidden" name="memberVO.id" value="${sessionScope.member.id}">
			<input type="hidden" name="boardTypeNo" value="${requestScope.boardTypeNo}">
			<input type="submit" class="btn btn-primary" value="작성">
			<input type="reset" class="btn btn-primary" value="취소">
		</form>
	</div>
</div>
