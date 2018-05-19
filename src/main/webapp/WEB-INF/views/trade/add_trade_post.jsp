<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form action="${pageContext.request.contextPath}/trade/addTradePost.do" method="post">
<script src="/momsbay/resources/ckeditor/ckeditor.js"></script>
 <script>
window.onload=function()
{
	CKEDITOR.replace('content');
}
</script>
<div class="category-tab">
	<div class="col-sm-12"  style="text-align: left;">
		<span>희망가격 : </span>
		<span><input type="number" name="price">원</span><br>
		<textarea rows="1" name="title" placeholder="제목을 입력하세요"></textarea><br><br>
		<textarea rows="10" name="content" placeholder="내용을 입력하세요"></textarea>
	</div>
	<div class="btn-group">
		<input type="hidden" name="memberVO.id" value="${sessionScope.member.id}">
		<input type="hidden" name="boardTypeNo" value="${requestScope.boardTypeNo}">
		<input type="hidden" name="categoryNo" value="${requestScope.categoryNo}">
		<span><input type="submit" class="btn btn-primary" value="글쓰기"></span>
	</div>
</div>
</form>