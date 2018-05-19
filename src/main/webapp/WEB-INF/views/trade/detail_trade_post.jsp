<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	function updateTradePost(){
		location.href="${pageContext.request.contextPath}/trade/update_trade_post.do?tradePostNo=${requestScope.tradePostVO.tradePostNo}";
	}
	function deleteTradePost(){
		location.href="${pageContext.request.contextPath}/trade/deleteTradePost.do?tradePostNo=${requestScope.tradePostVO.tradePostNo}";
	}
</script>

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
					<span>${requestScope.tradePostVO.price}원</span>
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
			
		</div>
		<div class="btn-group">
			<span><button type="button" class="btn btn-primary">거래하기</button></span>
			<span><button type="button" class="btn btn-primary">거래취소</button></span>
		</div>
	</div>
</div>

<div class="category-tab">
	<!--category-tab-->
	<div class="tab-content">
		<div class="tab-pane fade active in" id="reviews">
			<ul>
				<li><i class="fa fa-user"></i>${requestScope.tradePostVO.memberVO.name}</li>
				<li><i class="fa fa-clock-o"></i>${requestScope.tradePostVO.regdate}</li>
			</ul>
			<p>제목 : ${requestScope.tradePostVO.title}</p>
		</div>
	</div>
	<pre>${requestScope.tradePostVO.content}</pre>
</div>

<c:if test="${sessionScope.member.id==requestScope.tradePostVO.memberVO.id || sessionScope.member.grade == 'admin'}">
	<div class="row">
		<div class="col-sm-11">
			<div align="right">
				<button name="button" class="btn btn-primary" onclick="updateTradePost()">글수정</button>
				<button name="button" class="btn btn-primary" onclick="deleteTradePost()">글삭제</button>
			</div>
		</div>
	</div>
</c:if>