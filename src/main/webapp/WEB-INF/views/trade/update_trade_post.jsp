<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form action="updateTradePost.do" method="post">
<div class="product-details">
	<!--product-details-->
	<div class="col-sm-5">
		<div class="view-product">
			<img src="${pageContext.request.contextPath}/resources/upload/images/stroller.jpg"
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
					<span><input type="number" name="price" value="${requestScope.tradePostVO.price}">원</span>
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
		<div class="tab-content">
			<div class="tab-pane fade active in" id="reviews">
				<ul>
					<li><i class="fa fa-user">${requestScope.tradePostVO.memberVO.name}</i></li>
					<li><i class="fa fa-clock-o">${requestScope.tradePostVO.regdate}</i></li>
				</ul>
			</div>
		</div>
		<ul class="nav">
			<li><input type="text" name="title" value="${requestScope.tradePostVO.title}"></li>
		</ul>
		<textarea rows="10" name="content">${requestScope.tradePostVO.content}</textarea>
	</div>
	<input type="hidden" name="tradePostNo" value="${requestScope.tradePostVO.tradePostNo}">
	<div class="btn-group">
		<span><input type="submit" class="btn btn-primary" value="글수정"></span>
	</div>
</div>
</form>
