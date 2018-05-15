<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form action="addPost" method="post">
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
			<div class="row">
				<div class="col-sm-5">
					<span>상품 카테고리 : </span>
				</div>
				<div class="col-sm-7">
					<span>(카테고리)</span>
				</div>
			</div>
		</div>
		<div class="btn-group">
			<span><button type="button" class="btn btn-primary">거래하기</button></span>
			<span><button type="button" class="btn btn-primary">거래취소</button></span>
		</div>
	</div>
</div>

<div class="category-tab">
	<!--category-tab-->
	<div class="col-sm-12">
		<div class="tab-content">
			<div class="tab-pane fade active in" id="reviews">
				<ul>
					<li><i class="fa fa-user"></i>(작성자)</li>
					<li><i class="fa fa-clock-o"></i>(작성시간)</li>
					<li><i class="fa fa-calendar-o"></i>(작성일)</li>
				</ul>
			</div>
		</div>
		<ul class="nav">
			<li><input type="text" name="title" placeholder="제목을 입력하세요"></li>
		</ul>
		<textarea rows="10" name="content" placeholder="내용을 입력하세요"></textarea>
	</div>
	<div class="btn-group">
		<span><input type="submit" class="btn btn-primary" value="글수정"></span>
	</div>
</div>
</form>
