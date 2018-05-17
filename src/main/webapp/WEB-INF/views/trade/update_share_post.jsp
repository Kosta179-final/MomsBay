<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form action="updateSharePost.do" method="post">
<div class="product-details">
	<!--product-details-->
	<div class="col-sm-5">
		<div class="view-product">
			<img src="${pageContext.request.contextPath}/resources/upload/images/default.png"
				alt="" />
				<ul>
					<li><i class="fa fa-clock-o"></i>등록일시 ${requestScope.pvo.regdate}</li>
				</ul>
		</div>
	</div>
	<div class="col-sm-7">
		<div class="product-information">
			<!--/product-information-->
			<div class="row" align="left">
				<div class="col-sm-3">
					<span style="font-size: 30px">제목   : </span>
				</div>
				<div class="col-sm-9">
					<span style="font-size: 30px"><input type="text" name="title" value="${requestScope.pvo.title }"></span>
				</div><hr>
			</div>
			<div class="row" align="left">
				<div class="col-sm-2">
					<span>평점   : </span>
				</div>
				<div class="col-sm-10">
					<span>* * * * *</span>
				</div>
			</div>
			<div class="row" align="left">
				<div class="col-sm-4">
					<span>상품 카테고리   : </span>
				</div>
				<div class="col-sm-8">
					<span>${requestScope.pvo.categoryNo}</span>
				</div>
			</div>
		</div>
		<div class="btn-group">
			<span><button type="button" class="btn btn-primary">찜하기</button></span>
		</div>
	</div>
</div>
<div class="category-tab">	
	<h1 align="left">DETAIL INFO</h1><hr>
</div>
	<textarea rows="10" name="content">${requestScope.pvo.content }</textarea>
		<input type="hidden" name="noneTradePostNo" value="${requestScope.pvo.noneTradePostNo}">
			<div class="btn-group">
				<span><input type="submit" class="btn btn-primary" value="글수정"></span>
			</div>
</form>




