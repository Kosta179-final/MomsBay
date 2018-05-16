<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form action="${pageContext.request.contextPath}/trade/tradeWrite.do" method="post">
<div class="product-details">
	<!--product-details-->
	<div class="col-sm-5">
		<div class="view-product">
			<img src="${pageContext.request.contextPath}/resources/upload/images/default.png"
				alt="" />
		</div>
	</div>
	<div class="col-sm-7">
		<div class="product-information">
			<!--/product-information-->
			<div class="row">
				<div class="col-sm-5">
					<span>희망가격 : </span>
				</div>
				<div class="col-sm-7">
					<span><input type="number" name="price">원</span>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-5">
					<span>평점 : </span>
				</div>
				<div class="col-sm-7">
					<span>(회원평점)</span>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="category-tab">
	<!--category-tab-->
	<div class="col-sm-12">
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
