<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
$(document).ready(function() {
	$("#addSharePost").click(function() {
		location.href="add_share_post.do?boardTypeNo=${requestScope.boardTypeNo}";
	});
});
</script>
<div class="features_items">
	<!--features_items-->
	<h2 class="title text-center">게시글 목록</h2>

	<div class="col-sm-4">
		<div class="product-image-wrapper">
			<div class="single-products">
				<div class="productinfo text-center">
					<img
						src="${pageContext.request.contextPath}/resources/images/home/product6.jpg"
						alt="" />
					<h2>$56</h2>
					<p>Easy Polo Black Edition</p>
					<a href="#" class="btn btn-default add-to-cart"><i
						class="fa fa-shopping-cart"></i>Add to cart</a>
				</div>
				<div class="product-overlay">
					<div class="overlay-content">
						<h2>$56</h2>
						<p>Easy Polo Black Edition</p>
						<a href="#" class="btn btn-default add-to-cart"><i
							class="fa fa-shopping-cart"></i>Add to cart</a>
					</div>
				</div>
			</div>
			<div class="choose">
				<ul class="nav nav-pills nav-justified">
					<li><a href=""><i class="fa fa-plus-square"></i>
							상세보기</a></li>
				</ul>
			</div>
		</div>
	</div>

	<div class="col-sm-4">
		<div class="product-image-wrapper">
			<div class="single-products">
				<div class="productinfo text-center">
					<img
						src="${pageContext.request.contextPath}/resources/images/home/product5.jpg"
						alt="" />
					<h2>$56</h2>
					<p>Easy Polo Black Edition</p>
					<a href="#" class="btn btn-default add-to-cart"><i
						class="fa fa-shopping-cart"></i>Add to cart</a>
				</div>
				<div class="product-overlay">
					<div class="overlay-content">
						<h2>$56</h2>
						<p>Easy Polo Black Edition</p>
						<a href="#" class="btn btn-default add-to-cart"><i
							class="fa fa-shopping-cart"></i>Add to cart</a>
					</div>
				</div>
			</div>
			<div class="choose">
				<ul class="nav nav-pills nav-justified">
					<li><a href=""><i class="fa fa-plus-square"></i>
							상세보기</a></li>
				</ul>
			</div>
		</div>
	</div>

	<div class="col-sm-4">
		<div class="product-image-wrapper">
			<div class="single-products">
				<div class="productinfo text-center">
					<img
						src="${pageContext.request.contextPath}/resources/images/home/product4.jpg"
						alt="" />
					<h2>$56</h2>
					<p>Easy Polo Black Edition</p>
					<a href="#" class="btn btn-default add-to-cart"><i
						class="fa fa-shopping-cart"></i>Add to cart</a>
				</div>
				<div class="product-overlay">
					<div class="overlay-content">
						<h2>$56</h2>
						<p>Easy Polo Black Edition</p>
						<a href="#" class="btn btn-default add-to-cart"><i
							class="fa fa-shopping-cart"></i>Add to cart</a>
					</div>
				</div>
			</div>
			<div class="choose">
				<ul class="nav nav-pills nav-justified">
					<li><a href=""><i class="fa fa-plus-square"></i>
							상세보기</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="col-sm-11 off-set-1">
		<div align="right">
			<button name="button" class="btn btn-primary" id="addSharePost">글쓰기</button><br>
		</div>
	</div>
	<ul class="pagination">
		<li class="active"><a href="">1</a></li>
		<li><a href="">2</a></li>
		<li><a href="">3</a></li>
		<li><a href="">&raquo;</a></li>
	</ul>
</div>
