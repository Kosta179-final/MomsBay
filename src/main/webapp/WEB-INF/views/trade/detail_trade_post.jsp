<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	$(document).ready(function(){
		$("#cancelTransactionfromPublisher").click(function(){
			if(confirm("거래를 취소하시겠습니까?")){
				var tradeId = "${requestScope.tradePostVO.tradeId}";
				var memberVOId = "${sessionScope.member.id}";
				var url = "${pageContext.request.contextPath}";
				var tradePostNo = "${requestScope.tradePostVO.tradePostNo}";
				$("#trade").attr("action", url+"/trade/cancelTransaction.do");
				$("#tradeId").attr("value",tradeId);
				$("#memberVOId").attr("value",memberVOId);
				$("#tradePostNo").attr("value",tradePostNo);
				$("#trade").submit();
			}
		});
		
		$("#cancelTransactionFromApplicant").click(function(){
			if(confirm("거래를 취소하시겠습니까?")){
				var tradeId = "${sessionScope.member.id}";
				var memberVOId = "${requestScope.tradePostVO.memberVO.id}";
				var url = "${pageContext.request.contextPath}";
				var tradePostNo = "${requestScope.tradePostVO.tradePostNo}";
				$("#trade").attr("action", url+"/trade/cancelTransaction.do");
				$("#tradeId").attr("value",tradeId);
				$("#memberVOId").attr("value",memberVOId);
				$("#tradePostNo").attr("value",tradePostNo);
				$("#trade").submit();
			}
		});
		
		$("#applyTradeView").click(function(){
				var url = "${pageContext.request.contextPath}";
				var tradePostNo = "${requestScope.tradePostVO.tradePostNo}";
				$("#trade").attr("action", url+"/trade/applyTradeView.do");
				$("#tradePostNo").attr("value",tradePostNo);
				$("#trade").submit();
		});
		
		$("#updateTradePostView").click(function(){
			var url = "${pageContext.request.contextPath}";
			var tradePostNo = "${requestScope.tradePostVO.tradePostNo}";
			$("#trade").attr("action", url+"/trade/updateTradePostView.do");
			$("#tradePostNo").attr("value",tradePostNo);
			$("#trade").submit();
		});
		
		$("#deleteTradePost").click(function(){
			var url = "${pageContext.request.contextPath}";
			var tradePostNo = "${requestScope.tradePostVO.tradePostNo}";
			$("#trade").attr("action", url+"/trade/deleteTradePost.do");
			$("#tradePostNo").attr("value",tradePostNo);
			$("#trade").submit();
		});
		
		$("#updateDeliveryTradeHistory").click(function(){
			if(confirm("물품배송을 완료하였습니까?")){
				var url = "${pageContext.request.contextPath}";
				var tradePostNo = "${requestScope.tradePostVO.tradePostNo}";
				var memberVOId = "${requestScope.tradePostVO.memberVO.id}";
				$("#trade").attr("action", url+"/trade/updateDeliveryTradeHistory.do");
				$("#memberVOId").attr("value",memberVOId);
				$("#tradePostNo").attr("value",tradePostNo);
				$("#trade").submit();
			}
		});
		
		$("#completeTransaction").click(function(){
			var url = "${pageContext.request.contextPath}";
			var tradeId = "${requestScope.tradePostVO.tradeId}";
			var memberVOId = "${requestScope.tradePostVO.memberVO.id}";
			var tradePostNo = "${requestScope.tradePostVO.tradePostNo}";
			$("#trade").attr("action", url+"/trade/completeTransaction.do");
			$("#memberVOId").attr("value",memberVOId);
			$("#tradeId").attr("value",tradeId);
			$("#tradePostNo").attr("value",tradePostNo);
			$("#trade").submit();
		});
	});
</script>


<form action="" id="trade" method="post">
<input type="hidden" name="tradePostNo" id="tradePostNo">
<input type="hidden" name="tradeId" id="tradeId">
<input type="hidden" name="id" id="memberVOId">
<input type="hidden" name="boardTypeNo" id="boardTypeNo" value="${requestScope.tradePostVO.boardTypeNo}">
</form>

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
		<c:choose>
			<c:when test="${sessionScope.member.id==requestScope.tradePostVO.memberVO.id}">
				<c:choose>
					<c:when test="${requestScope.tradePostVO.tradeId eq NULL}">
						<div class="btn-group">
							<span><button type="button" class="btn btn-primary">${requestScope.tradePostVO.status}</button></span>
						</div>
					</c:when>
					<c:otherwise>
						<div class="btn-group">
							<c:choose>
								<c:when test="${requestScope.tradePostVO.status eq '거래완료'}">
									<span><button type="button" class="btn btn-primary">${requestScope.tradePostVO.status}</button></span>
								</c:when>
								<c:when test="${requestScope.historyStatus eq '물품배송'}">
									<span><button type="button" class="btn btn-primary">배송완료</button></span>
								</c:when>
								<c:otherwise>
									<span><button type="button" id="updateDeliveryTradeHistory" class="btn btn-primary">물품배송</button></span>
									<span><button type="button" id="cancelTransactionfromPublisher" class="btn btn-primary">거래취소</button></span>
								</c:otherwise>
							</c:choose>
						</div>
					</c:otherwise>
				</c:choose>
			</c:when>
			<c:otherwise>
				<c:choose>
					<c:when test="${requestScope.tradePostVO.tradeId eq NULL}">
						<div class="btn-group">
							<span><button type="button" id="applyTradeView" class="btn btn-primary">거래신청</button></span>
						</div>
					</c:when>
					<c:otherwise>
						<div class="btn-group">
						<c:choose>
							<c:when test="${requestScope.tradePostVO.status eq '거래완료'}">
								<span><button type="button" class="btn btn-primary">${requestScope.tradePostVO.status}</button></span>
							</c:when>
							<c:when test="${requestScope.historyStatus eq '물품배송'}">
								<span><button type="button" class="btn btn-primary" id="completeTransaction">거래완료</button></span>
							</c:when>
							<c:otherwise>
								<span><button type="button" class="btn btn-primary" id="cancelTransactionFromApplicant">거래취소</button></span>
							</c:otherwise>
						</c:choose>
						</div>
					</c:otherwise>
				</c:choose>
			</c:otherwise>
		</c:choose>
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
				<button name="button" class="btn btn-primary" id="updateTradePostView">글수정</button>
				<button name="button" class="btn btn-primary" id="deleteTradePost">글삭제</button>
			</div>
		</div>
	</div>
</c:if>


<!-- 
<div class="modal fade" id="passwordModal" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">판매자 평가</h4>
			</div>

			<div class="modal-body">
				<p>별점을 입력해 주세요.</p>
				<div>
					<form id="exgForm" action="exchangePoint.do">
						<input type="password" min="0" name="password" id="password"
							class="form-control" placeholder="password"
							style="width: 30%; margin: 0 auto;" required="required">
						<input type="button" class="btn btn-info form-control" id="exgBtn"
							style="width: 30%; margin: 0 auto;" data-dismiss="modal"
							value="확인">
					</form>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
			</div>
		</div>
	</div>
</div>

 -->






