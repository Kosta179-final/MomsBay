<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="${pageContext.request.contextPath}/resources/js/star.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/star.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/image-magnify.css" rel="stylesheet">
<script src='${pageContext.request.contextPath}/resources/js/jquery.zoom.js'></script>
<script type="text/javascript">
	
	function dataForm(tradeId, memberVOId, url,	tradePostNo){
		$("#trade").attr("action", url);
		$("#tradeId").attr("value",tradeId);
		$("#memberVOId").attr("value",memberVOId);
		$("#tradePostNo").attr("value",tradePostNo);
		$("#trade").submit();
	}
	$(document).ready(function(){
		/*메세지 보내기*/
		$("#message_btn").click(function(){
			location.href='${pageContext.request.contextPath}/message/add_message_form.do?receiveId=${pvo.memberVO.id}';
		});
		
		$('.zoom').zoom();
		
		/* 목록으로 돌아가기 */
		$("#listBtn").click(function() {
			location.href="${pageContext.request.contextPath}/trade/list_trade_post.do?pageNo=${requestScope.pageNo}&boardTypeNo=${requestScope.boardTypeNo}&categoryNo=${requestScope.categoryNo}";
		});
		starRating();
	});//ready
</script>


<form action="" id="trade" method="post">
<input type="hidden" name="tradePostNo" id="tradePostNo">
<input type="hidden" name="tradeId" id="tradeId">
<input type="hidden" name="id" id="memberVOId">
<input type="hidden" name="boardTypeNo" id="boardTypeNo" value="${requestScope.tradePostVO.boardTypeNo}">
<input type="hidden" name="pageNo" id="pageNo" value="${requestScope.pageNo}">
<input type="hidden" name="rating" id="rating">
</form>

<div class="product-details">
	<!--product-details-->
	<div class="col-sm-5">
		<div class="zoom view-product">
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
			<div class="row" align="left">
				<span>
					<c:if test="${requestScope.tradePostVO.status eq '거래완료'}">
						<div class="label label-danger" align="right">거래완료</div>
					</c:if>
				</span>
				<div class="col-sm-12">
					<span style="font-size: 30px">${requestScope.tradePostVO.title}</span>
				</div><hr>
			</div>
			<div class="row">
				<div class=col-sm-12><br><br><hr></div>
			</div>
			<div class="row" align="left">
				<div class="col-sm-12">
					<span>희망가격&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:formatNumber value="${requestScope.tradePostVO.price}" pattern="#,###.##"/>원</span>
				</div>
			</div>
			<div class="row" align="left">
				<div class="col-sm-12">
					<span>작성자&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${requestScope.tradePostVO.memberVO.name}&nbsp;(${requestScope.tradePostVO.memberVO.id})</span>
						<c:if test="${sessionScope.member.id != requestScope.tradePostVO.memberVO.id && !empty member}">
							<button id="message_btn" class="fa fa-envelope"></button>
						</c:if>
				</div>
			</div>
			<div class="row" align="left">
				<div class="col-sm-3">
					<span>등록일시&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: </span>
				</div>
				<div class="col-sm-7">
					<span>${requestScope.tradePostVO.regdate}</span>
				</div>
				<div class="col-sm-12"><br></div>
				<div class="col-sm-12"><br></div>
			</div>
			<!-- 2차 버전<div class="row">
				<div class="col-sm-5">
					<span>평점 : </span>
				</div>
				<div class="col-sm-7">
					<span>* * * * *</span>
				</div>
			</div> -->
			
		</div>
		<!-- 삽니다 게시판 버튼 -->
		<c:if test="${requestScope.tradePostVO.boardTypeNo eq '1'}">
			<c:choose>
				<%-- 게시자(구매자)면 --%>
				<c:when test="${sessionScope.member.id==requestScope.tradePostVO.memberVO.id}">
					<c:choose>
						<%-- 신청이 없으면 --%>
						<c:when test="${requestScope.tradePostVO.tradeId eq NULL}">
							<div class="btn-group">
								<div class="label label-info">${requestScope.tradePostVO.status}</div>
							</div>
							<div class="btn-group">
								<span><button type="button" class="btn btn-primary"></button></span>
							</div>
						</c:when>
						<%-- 신청이 있으면 --%>
						<c:otherwise>
							<div class="btn-group">
							<c:choose>
								<c:when test="${requestScope.historyStatus eq '거래중'}">

									<span><button type="button" onclick="dataForm('${requestScope.tradePostVO.memberVO.id}','${requestScope.tradePostVO.tradeId}','${pageContext.request.contextPath}/trade/deposit.do','${requestScope.tradePostVO.tradePostNo}')" class="btn btn-info3">입금하기</button></span>
									<span><button type="button" onclick="dataForm('','','${pageContext.request.contextPath}/trade/cancelTransaction2.do','${requestScope.tradePostVO.tradePostNo}')" class="btn btn-info3">거래취소</button></span>
								</c:when>
								<c:when test="${requestScope.historyStatus eq '물품배송'}">
									<span><button type="button" class="btn btn-info3" data-toggle="modal" data-target="#myModal">거래완료</button></span>
								</c:when>
								<c:otherwise>
									<span><%-- 거래완료시 버튼은 사라지고 제목 위에 거래완료 라벨 생성된다. --%></span>
								</c:otherwise>
							</c:choose>
							</div>
						</c:otherwise>
					</c:choose>
				</c:when>
				
				<%-- 게시자(구매자)가 아니면 --%>
				<c:otherwise>
					<c:choose>
						<%-- 신청이 없으면 --%>
						<c:when test="${requestScope.tradePostVO.tradeId eq NULL}">
							<div class="btn-group">
								<span><button type="button" onclick="dataForm('','','${pageContext.request.contextPath}/trade/applySellView.do','${requestScope.tradePostVO.tradePostNo}')" class="btn btn-info3">거래신청</button></span>
							</div>
						</c:when>
						<%-- 신청이 있으면 --%>
						<c:otherwise>
							<c:choose>
								<%-- 신청자 본인이면 --%>
								<c:when test="${requestScope.tradePostVO.tradeId eq sessionScope.member.id}">
									<div class="btn-group">
										<c:choose>
											<c:when test="${requestScope.historyStatus eq '거래중'}">
												<span><button type="button" class="btn btn-info3">거래중</button></span>
											</c:when>
											<c:when test="${requestScope.historyStatus eq '입금완료'}">
												<span><button type="button" onclick="dataForm('','${requestScope.tradePostVO.memberVO.id}','${pageContext.request.contextPath}/trade/updateDeliveryTradeHistory.do','${requestScope.tradePostVO.tradePostNo}')" class="btn btn-info3">물품배송</button></span>
											</c:when>
											<c:otherwise>
												<span><%-- 신청자는 거래 완료된 게시물 상세페이지에 버튼 사라지고 제목에 거래완료 라벨 생성된다. --%></span>
											</c:otherwise>
										</c:choose>
									</div>
								</c:when>
								<%-- 신청자 본인이 아니면 --%>
								<c:otherwise>
									<c:choose>
										<c:when test="${requestScope.historyStatus eq '물품배송' or requestScope.historyStatus eq '입금완료'}">
											<span><button type="button" class="btn btn-info3" onclick="dataForm('${requestScope.tradePostVO.tradeId}','${requestScope.tradePostVO.memberVO.id}','${pageContext.request.contextPath}/trade/completeTransaction.do','${requestScope.tradePostVO.tradePostNo}')">거래중</button></span>
										</c:when>
										<c:otherwise>
											<span><%-- 비회원은 거래완료 된 상세페이지에서 버튼이 보이지 않는다. --%></span>
										</c:otherwise>
									</c:choose>
								</c:otherwise>						
							</c:choose>
						</c:otherwise>
					</c:choose>
				</c:otherwise>
			</c:choose>
		</c:if>

		<!-- 팝니다 게시판 버튼 -->
		<c:if test="${requestScope.tradePostVO.boardTypeNo eq '2'}">
		<c:choose>
			<%-- 게시자(판매자)면 --%>
			<c:when test="${sessionScope.member.id==requestScope.tradePostVO.memberVO.id}">
				<c:choose>
					<%-- 신청이 없으면 --%>
					<c:when test="${requestScope.tradePostVO.tradeId eq NULL}">
						<div class="btn-group">
							<div class="label label-info">${requestScope.tradePostVO.status}</div>
						</div>
					</c:when>
					<%-- 신청이 있으면 --%>
					<c:otherwise>
						<div class="btn-group">
							<c:choose>
								<c:when test="${requestScope.tradePostVO.status eq '거래완료'}">
									<span><%-- 거래 완료시 상세페이지 제목공간에 거래완료 라벨 생긴다. --%></span>
								</c:when>
								<c:when test="${requestScope.historyStatus eq '물품배송'}">
									<span><button type="button" class="btn btn-info3">배송완료</button></span>
								</c:when>
								<c:otherwise>
									<span><button type="button" onclick="dataForm('','${requestScope.tradePostVO.memberVO.id}','${pageContext.request.contextPath}/trade/updateDeliveryTradeHistory.do','${requestScope.tradePostVO.tradePostNo}')" class="btn btn-info3">물품배송</button></span>
								</c:otherwise>
							</c:choose>
						</div>
					</c:otherwise>
				</c:choose>
			</c:when>
			<%-- 신청자(구매자)면 --%>
			<c:otherwise>
				<c:choose>
					<%-- 신청이 없으면 --%>
					<c:when test="${requestScope.tradePostVO.tradeId eq NULL}">
						<div class="btn-group">
							<span><button type="button" onclick="dataForm('','','${pageContext.request.contextPath}/trade/applyBuyView.do','${requestScope.tradePostVO.tradePostNo}')" class="btn btn-info3">거래신청</button></span>
						</div>
					</c:when>
					<%-- 신청이 있으면 --%>
					<c:otherwise>
						<c:choose>
							<%-- 신청자 본인이면 --%>
							<c:when test="${requestScope.tradePostVO.tradeId eq sessionScope.member.id}">
								<div class="btn-group">
								<c:choose>
									<c:when test="${requestScope.tradePostVO.status eq '거래완료'}">
										<span><%-- 거래 완료시 상세페이지 제목공간에 거래완료 라벨 생긴다. --%></span>
									</c:when>
									<c:when test="${requestScope.historyStatus eq '물품배송'}">
										<span><button type="button" class="btn btn-info3" data-toggle="modal" data-target="#myModal">거래완료</button></span>
									</c:when>
									<c:otherwise>
										<span><button type="button" class="btn btn-info3">거래중</button></span>
									</c:otherwise>
								</c:choose>
								</div>
							</c:when>
							<%-- 신청자 본인이 아니면 --%>
							<c:otherwise>
								<div class="btn-group">
								<c:choose>
									<c:when test="${requestScope.tradePostVO.status eq '물품배송'}">
										<%--<span><button type="button" class="btn btn-info3" id="completeTransaction">거래중</button></span> --%>
									</c:when>
									<c:when test="${requestScope.tradePostVO.status eq '거래완료'}">
										<%-- <span><button type="button" class="btn btn-info3" id="completeTransaction">거래중</button></span> --%>
									</c:when>
									<c:when test="${requestScope.tradePostVO.status eq '거래중'}">
										<%-- 거래중입니다. --%>
									</c:when>
									<c:otherwise>
										<span><button type="button" class="btn btn-info3">${requestScope.tradePostVO.status}</button></span>
									</c:otherwise>
								</c:choose>
								</div>
							</c:otherwise>
						</c:choose>
					</c:otherwise>
				</c:choose>
			</c:otherwise>
		</c:choose>
		</c:if>
	</div>
</div>

<div class="category-tab">
	<h1 align="left">DETAIL INFO</h1><hr>
	<div style="text-align: left;">
		<p align="left">${requestScope.tradePostVO.content}</p>
	</div>
</div><hr>
<c:if test="${requestScope.tradePostVO.suggestContent ne NULL}">
	<p>판매자 상품 정보</p>
		<div class="category-tab">
			<pre>${requestScope.tradePostVO.suggestContent}</pre>
		</div>
</c:if>
<div class="row">
	<img src="${pageContext.request.contextPath}/resources/upload/images/detailfooter.png" alt=""/>
</div><br><br>

<div class="row">
	<div class="col-sm-12"><br><br></div>
</div>
<c:choose>
	<c:when test="${sessionScope.member.id==requestScope.tradePostVO.memberVO.id || sessionScope.member.grade == 'admin'}">
	<div class="row">
		<div class="col-sm-12">
			<div align="center">
				<div class="row">
					<div class="col-sm-5" style="padding-right: 6px;">
						<button name="button" class="btn btn-info2 pull-right" onclick="dataForm('','','${pageContext.request.contextPath}/trade/updateTradePostView.do','${requestScope.tradePostVO.tradePostNo}')">글수정</button>
					</div>
					<div class="col-sm-1" style="padding-left: 0px; padding-right: 0px;">
						<button name="button" class="btn btn-info3 pull-left" onclick="dataForm('','','${pageContext.request.contextPath}/trade/deleteTradePost.do','${requestScope.tradePostVO.tradePostNo}')">글삭제</button>
					</div>
					<div class="col-sm-6" style="padding-left: 3px;">
						<button type="button" name="button" class="btn btn-info6 pull-left" id="listBtn">목록으로</button>
						<input type="hidden" name="boardTypeNo" value="${requestScope.tradePostVO.boardTypeNo}"> 
						<input type="hidden" name="categoryNo" value="${requestScope.tradePostVO.categoryNo}">
						<input type="hidden" name="pageNo" value="${requestScope.pageNo}">
					</div>
				</div>
			</div>
		</div>
	</div>
		<div class="row">
			<div class=col-sm-12><br><br><br><br>
		</div>
	</div>
	</c:when>
	<c:otherwise>
		<div class="row">
			<div class="col-sm-12" style="padding-left: 3px;">
				<button type="button" name="button" class="btn btn-info6" id="listBtn">목록으로</button>
				<input type="hidden" name="boardTypeNo" value="${requestScope.tradePostVO.boardTypeNo}"> 
				<input type="hidden" name="categoryNo" value="${requestScope.tradePostVO.categoryNo}">
				<input type="hidden" name="pageNo" value="${requestScope.pageNo}">
			</div>
		</div>	
		<div class="row">
			<div class=col-sm-12><br><br><br><br></div>
		</div>
	</c:otherwise>
</c:choose>

<!--  modal -->
<div class="modal fade" id="myModal" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->

		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">구매 평가</h4>
			</div>
			<div class="modal-body">
				<span class="star-input"> <span class="input"> <input
						type="radio" name="star-input" value="1" id="p1"> <label
						for="p1">1</label> <input type="radio" name="star-input" value="2"
						id="p2"> <label for="p2">2</label> <input type="radio"
						name="star-input" value="3" id="p3"> <label for="p3">3</label>
						<input type="radio" name="star-input" value="4" id="p4"> <label
						for="p4">4</label> <input type="radio" name="star-input" value="5"
						id="p5"> <label for="p5">5</label>
				</span><output for="star-input">
						<b>0</b>점
					</output>
				</span>

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" onclick="dataForm('${requestScope.tradePostVO.tradeId}','${requestScope.tradePostVO.memberVO.id}','${pageContext.request.contextPath}/trade/completeTransaction.do','${requestScope.tradePostVO.tradePostNo}')">완료</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
			</div>
		</div>
	</div>
</div>
