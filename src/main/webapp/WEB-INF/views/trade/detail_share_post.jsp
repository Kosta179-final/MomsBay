<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	/* 글 삭제  */
	$(document).ready(function() {
		$("#deleteBtn").click(function() {
			if(confirm("삭제하시겠습니까??")){
				$("#deleteForm").submit();
			}
		});
		
		$("#message_btn").click(function(){
			location.href='${pageContext.request.contextPath}/message/add_message_form.do?receiveId=${pvo.memberVO.id}';
		});
	});
	/* 글 수정 */
	function updateSharePost() {
		if(confirm("글수정 페이지로 이동 하시겠습니까?")==true){
			location.href="${pageContext.request.contextPath}/trade/update_share_post.do?noneTradePostNo=${requestScope.pvo.noneTradePostNo}"
		}else{
			return;			
		}
	}
	/* 거래 완료 하기 */
	function updateSharePostByStatus() {
		if(confirm("거래를 완료 하셨습니까?")==true){
			location.href="${pageContext.request.contextPath}/trade/updateSharePostByStatus.do?noneTradePostNo=${requestScope.pvo.noneTradePostNo}"
		}else{
			return;
		}
	}
	/* 거래 요청 하기 */
	function updateShareAndExchangeTrade() {
		if(confirm("거래를 요청 하시겠습니까?")==true){
			location.href=""
		}else{
			return;
		}
	}
</script>
<div class="product-details">
	<!--product-details-->
	<div class="col-sm-5">
		<div class="view-product">
			<c:choose>
				<c:when test="${ imgAddress eq 'noPhoto'}">
					<img src="${pageContext.request.contextPath}/resources/upload/images/default.png" >
				</c:when>
				<c:otherwise>
					<img src="${pageContext.request.contextPath}/resources/upload/postImg/${imgAddress }" >
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<c:if test="${requestScope.pvo.tradeStatusNo==3}">
		<div style="position: absolute;">
			<div style="position: relative; top: 45px; left: -7px;"><img src="${pageContext.request.contextPath}/resources/images/product-details/soldout11.png" style="width: 375px; height: 290px;"></img>
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
			<%-- 평점은 버전2 --%>
			<%--<div class="row" align="left">
				<div class="col-sm-5">
					<span>평점&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: </span>
				</div>
				<div class="col-sm-7">
					<span>* * * * *</span>
				</div>
			</div> --%>
			<div class="row" align="left">
				<div class="col-sm-12">
					<span>작성자&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${pvo.memberVO.id}</span>
						<c:if test="${sessionScope.member.id != requestScope.pvo.memberVO.id && !empty member}">
							<button id="message_btn" class="fa fa-envelope"></button>
						</c:if>
				</div>
			</div>
			<div class="row" align="left">
				<div class="col-sm-12">
					<span>상품 카테고리&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${category}</span>
				</div>
			</div>
			<div class="row" align="left">
				<div class="col-sm-3">
					<span>등록일시&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: </span>
				</div>
				<div class="col-sm-7">
					<span>${requestScope.pvo.regdate}</span>
				</div>
				<div class="col-sm-12"><br></div>
				<div class="col-sm-12"><br></div>
			</div>
			<c:if test="${!empty member}">
				<div class="row">
					<c:if test="${sessionScope.member.id==requestScope.pvo.memberVO.id}">
						<c:choose>
							<c:when test="${requestScope.pvo.tradeStatusNo==1}">
								<div class="col-sm-12">
									<button name="button" class="btn btn-info3" onclick="updateSharePostByStatus()">나눔/교환 완료하기</button>
								</div>
							</c:when>
						</c:choose>
					</c:if>
				</div>
			</c:if>
			<c:if test="${requestScope.pvo.tradeStatusNo==3}">
				<div></div>
			</c:if>
			<c:if test="${sessionScope.member.id!=requestScope.pvo.memberVO.id}">
				<c:if test="${requestScope.pvo.tradeStatusNo==1}">
					<button name="button" class="btn btn-info3" onclick="updateShareAndExchangeTrade()">거래 신청</button>
				</c:if>
			</c:if>
		</div>
	</div>
</div>
<div class="category-tab">	
	<h1 align="left">DETAIL INFO</h1><hr>
	<div style="text-align: left;">
		<p align="left">${requestScope.pvo.content}</p>
	</div>
</div><hr>
<div class="row">
	<img src="${pageContext.request.contextPath}/resources/upload/images/detailfooter.png" alt=""/>
</div><br><br>
<c:if test="${!empty member}">
	<div class="row">
		<div class="col-sm-11">
			<c:if test="${sessionScope.member.id==requestScope.pvo.memberVO.id || sessionScope.member.grade=='admin'}">
			<div align="center">
				<div class="row">
					<div class="col-sm-11" align="right">
						<button name="button" class="btn btn-info2" onclick="updateSharePost()">글수정</button>
					</div>
					<div class="col-sm-1">
						
						<form name="deleteForm" id="deleteForm" method="post" action="deleteSharePost.do">
							<button type="button" name="button" class="btn btn-info3" id="deleteBtn">글삭제</button>
							<input type="hidden" name="noneTradePostNo" value="${requestScope.pvo.noneTradePostNo}">
							<input type="hidden" name="boardTypeNo" value="${requestScope.pvo.boardTypeNo}"> 
						</form>
						
					</div>
				</div>
			</div>
			</c:if>
		</div>
	</div>
	<div class="row">
		<div class=col-sm-12><br><br><br><br>
		</div>
	</div>
</c:if>


