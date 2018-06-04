<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<script type="text/javascript">
	$(document).ready(function(){
		$("#applyTransaction").click(function(){
			var boardTypeNo = "${requestScope.tradePostVO.boardTypeNo}";
			if(confirm("거래를 신청하시겠습니까?")){
				var tradeId = "${sessionScope.member.id}";
				var memberVOId = "${requestScope.tradePostVO.memberVO.id}";
				var url = "${pageContext.request.contextPath}";
				var tradePostNo = "${requestScope.tradePostVO.tradePostNo}";
				$("#trade").attr("action", url+"/trade/applyTransaction.do");
				$("#tradeId").attr("value",tradeId);
				$("#memberVOId").attr("value",memberVOId);
				$("#tradePostNo").attr("value",tradePostNo);
				$("#trade").submit();
			}
		});
	});
</script>

<form action="" id="trade" method="post">
<input type="hidden" name="tradePostNo" id="tradePostNo">
<input type="hidden" name="tradeId" id="tradeId">
<input type="hidden" name="memberVO.id" id="memberVOId">
<input type="hidden" name="boardTypeNo" id="boardTypeNo" value="${requestScope.tradePostVO.boardTypeNo}">
</form>

<section id="cart_items">
	<div class="container-fluid text-center">
			<div class="left-sidebar">
				<h2 class="active"><strong style="color: grey;">상품 정보</strong></h2>
			</div>
			<table class="table table-borderless">
				<tr>
					<th align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					제목</th><td>${requestScope.tradePostVO.title}</td>
				</tr>
				<tr>
					<th align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					작성자</th><td>${requestScope.tradePostVO.memberVO.name}</td>
				</tr>
				<tr>
					<th align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					가격</th><td><fmt:formatNumber value="${requestScope.tradePostVO.price}" pattern="#,###.##"/>원</td>
				</tr>
			</table><br>
			<div class="left-sidebar">
				<h2 class="active"><strong style="color: grey;">신청자 정보</strong></h2>
			</div>
			<table class="table table-borderless">
				<tr>
					<th align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					신청자</th><td>${requestScope.tradePostVO.tradeId}</td>
				</tr>
				<tr>
					<th align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					주소</th><td>${sessionScope.member.address} ${sessionScope.member.address2}</td>
				</tr>
				<tr>
					<th align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					전화번호</th><td>${sessionScope.member.tel}</td>
				</tr>
				<tr>
					<th align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					이메일</th><td>${sessionScope.member.email}</td>
				</tr>
				<tr>
					<th align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					현재 포인트</th><td><fmt:formatNumber value="${nowPoint}" pattern="#,###.##"/>&nbsp;&nbsp;point</td>
				</tr>
				<tr>
					<th align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					거래 후 포인트</th><td><fmt:formatNumber value="${nowPoint - requestScope.tradePostVO.price}" pattern="#,###.##"/>&nbsp;&nbsp;point</td>
				</tr>
			</table>
	</div>
</section>
<div class="btn-group">
	<span><button type="button" id="applyTransaction" class="btn btn-info3">거래신청</button></span>
</div>