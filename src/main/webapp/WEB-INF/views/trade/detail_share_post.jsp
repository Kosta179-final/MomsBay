<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	function updateSharePost() {
		location.href="${pageContext.request.contextPath}/trade/update_share_post.do?noneTradePostNo=${requestScope.pvo.noneTradePostNo}"
	}
	function deleteSharePost() {
		location.href="${pageContext.request.contextPath}/trade/deleteSharePost.do?noneTradePostNo=${requestScope.pvo.noneTradePostNo}"
	}
</script>
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
				<div class="col-sm-5">
					<span style="font-size: 30px">제목   : </span>
				</div>
				<div class="col-sm-7">
					<span style="font-size: 30px">${requestScope.pvo.title}</span>
				</div><hr>
			</div>
			<div class="row" align="left">
				<div class="col-sm-5">
					<span>평점   : </span>
				</div>
				<div class="col-sm-7">
					<span>* * * * *</span>
				</div>
			</div>
			<div class="row" align="left">
				<div class="col-sm-5">
					<span>상품 카테고리   : </span>
				</div>
				<div class="col-sm-7">
					<span>${requestScope.pvo.categoryNo}</span>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="category-tab">	
	<h1 align="left">DETAIL INFO</h1><hr>
	<pre style="text-align:left">${requestScope.pvo.content}</pre>
</div>
<c:if test="${!empty member}">
	<div class="row">
		<div class="col-sm-11">
			<c:if test="${sessionScope.member.id==requestScope.pvo.memberVO.id || sessionScope.member.grade=='admin'}">
			<div align="right">
				<button name="button" class="btn btn-primary" onclick="updateSharePost()">글수정</button>
				<button name="button" class="btn btn-primary" onclick="deleteSharePost()">글삭제</button>
			</div>
			</c:if>
		</div>
	</div>
	<div class="row">
		<div class=col-sm-12><br></div>
	</div>
</c:if>


