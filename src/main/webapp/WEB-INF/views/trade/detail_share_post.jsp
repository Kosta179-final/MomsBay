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
	function updateSharePostByStatus() {
		confirm("거래를 완료 하셨습니까?")
		location.href="${pageContext.request.contextPath}/trade/updateSharePostByStatus.do?noneTradePostNo=${requestScope.pvo.noneTradePostNo}"
	}
	function updateShareAndExchangeTrade() {
		confirm("거래를 요청 하시겠습니까?")
		location.href=""
	}
</script>
<div class="product-details">
	<!--product-details-->
	<div class="col-sm-5">
		<div class="view-product">
			<img src="${pageContext.request.contextPath}/resources/upload/images/default.png"
				alt="" />
		</div>
	</div>
	<c:if test="${requestScope.pvo.tradeStatusNo==7}">
		<div style="position: absolute;">
			<div style="position: relative; top: 45px; left: 30px;"><img src="${pageContext.request.contextPath}/resources/images/product-details/soldout7.png" style="width: 300px; height: 290px;"></img>
			</div>
		</div>
	</c:if>
	<div class="col-sm-7">
		<div class="product-information">
			<!--/product-information-->
			<div class="row" align="left">
				<div class="col-sm-12">
					<span style="font-size: 30px">${requestScope.pvo.title}</span>
				</div><hr>
			</div>
			<div class="row">
				<div class=col-sm-12><br><br><hr></div>
			</div>
			<div class="row" align="left">
				<div class="col-sm-5">
					<span>평점&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: </span>
				</div>
				<div class="col-sm-7">
					<span>* * * * *</span>
				</div>
			</div>
			<div class="row" align="left">
				<div class="col-sm-5">
					<span>상품 카테고리&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: </span>
				</div>
				<div class="col-sm-7">
					<span>${requestScope.pvo.categoryNo}</span>
				</div>
			</div>
			<div class="row" align="left">
				<div class="col-sm-5">
					<span>등록일시&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: </span>
				</div>
				<div class="col-sm-7">
					<span>${requestScope.pvo.regdate}</span>
				</div>
			</div>
			<c:if test="${!empty member}">
				<div class="row">
					<c:if test="${sessionScope.member.id==requestScope.pvo.memberVO.id}">
						<c:choose>
							<c:when test="${requestScope.pvo.tradeStatusNo==1}">
								<div class="col-sm-12">
									<button name="button" class="btn btn-primary" onclick="updateSharePostByStatus()">나눔/교환 완료하기</button>
								</div>
							</c:when>
						</c:choose>
					</c:if>
				</div>
			</c:if>
			<c:if test="${requestScope.pvo.tradeStatusNo==7}">
				<div style="background-color: Tomato;">거래완료</div>
			</c:if>
			<c:if test="${sessionScope.member.id!=requestScope.pvo.memberVO.id}">
				<c:if test="${requestScope.pvo.tradeStatusNo==1}">
					<button name="button" class="btn btn-primary" onclick="updateShareAndExchangeTrade()">거래 신청</button>
				</c:if>
			</c:if>
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


