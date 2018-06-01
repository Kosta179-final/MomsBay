<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<input type="hidden" name="id" id="memberVOId">
<input type="hidden" name="boardTypeNo" id="boardTypeNo" value="${requestScope.tradePostVO.boardTypeNo}">
</form>

<section id="cart_items">
	<div class="container-fluid text-center">
		<div class="table-responsive cart_info">
			<h3 class="active">상품 정보</h3>
			<table class="table">
				<tr>
					<td>제목</td><td>${requestScope.tradePostVO.title}</td>
				</tr>
				<tr>
					<td>작성자</td><td>${requestScope.tradePostVO.memberVO.name}</td>
				</tr>
				<tr>
					<td>가격</td><td>${requestScope.tradePostVO.price}</td>
				</tr>
			</table>
			<h3 class="active">신청자 정보</h3>
			<table class="table">
				<tr>
					<td>신청자</td><td>${requestScope.tradePostVO.tradeId}</td>
				</tr>
				<tr>
					<td>주소</td><td>${sessionScope.member.address} ${sessionScope.member.address2}</td>
				</tr>
				<tr>
					<td>전화번호</td><td>${sessionScope.member.tel}</td>
				</tr>
				<tr>
					<td>이메일</td><td>${sessionScope.member.email}</td>
				</tr>
				<tr>
					<td>현재 포인트</td><td>${nowPoint}</td>
				</tr>
				<tr>
					<td>거래 후 포인트</td><td>${nowPoint - requestScope.tradePostVO.price}</td>
				</tr>
			</table>
		</div>
	</div>
</section>
<div class="btn-group">
	<span><button type="button" id="applyTransaction" class="btn btn-primary">거래신청</button></span>
</div>