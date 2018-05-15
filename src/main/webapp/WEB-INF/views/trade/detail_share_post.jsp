<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
					<span>23023원</span>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-5">
					<span>평점 : </span>
				</div>
				<div class="col-sm-7">
					<span>* * * * *</span>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-5">
					<span>상품 카테고리 : </span>
				</div>
				<div class="col-sm-7">
					<span>유모차</span>
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
					<li><i class="fa fa-user"></i>재상맘스</li>
					<li><i class="fa fa-clock-o"></i>12:41 PM</li>
					<li><i class="fa fa-calendar-o"></i>2014.05.18</li>
				</ul>
			</div>
		</div>
		<ul class="nav">
			<li>제목 : 유모차 삽니다 빨랑 팔아주세요</li>
		</ul>
	</div>
	<pre>유모차 급구합니다. 빨리 팔아주세요 ㅎㅎ
	흥정 안합니다</pre>
</div>