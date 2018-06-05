<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
	function detail(tradePostNo){
		var url = "${pageContext.request.contextPath}";
		location.href=url+"/trade/detail_trade_post.do?tradePostNo="+tradePostNo+"";
	}
	$(document).ready(function() {
		$("#sell").click(function() {
			var url = "${pageContext.request.contextPath}";
			location.href=url+"/myaccount/findTradeHistoryListById.do?&type=판매";
		})
	});
</script>



<div class="container">
	<ul class="nav nav-tabs">
		<li ><a id="sell" href="#home">판매내역</a></li>
		<li class="active"><a href="javascript:;">구매내역</a></li>
	</ul>
	
	<div class="row text-left col-sm-8">
		<div>
			<br>
			<table class="table">
				<thead>
					<tr>
						<th>No.</th>
						<th>거래상태</th>
						<th>판매자</th>
						<th>게시글제목</th>
						<th>가격</th>
						<th>거래종류</th>
						<th>거래시간</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${!empty listVO2.list}">
						<c:forEach items="${listVO2.list}" var="list" varStatus="cc">
							<tr onclick="detail(${list.tradePostVO.tradePostNo})">
								<td>${cc.count}.</td>
								<td>${list.status}</td>
								<td>${list.tradePostVO.tradeId}</td>
								<td>${list.tradePostVO.title}</td>
								<td><fmt:formatNumber value="${list.tradePostVO.price}" pattern="#,###.##"/></td>
								<td>${list.tradePostVO.tradeType}</td>
								<td>${list.regdate}</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
					<c:if test="${empty listVO2.list}">
						<label> 거래 내역이 없습니다. </label>
					</c:if>
			<div class="row">
				<%-- pagingBean --%>
				<div class="row col-sm-offset-5">
					<div class="pagingInfo">
						<c:set var="pb" value="${requestScope.listVO2.pagingBean}"></c:set>
						<ul class="pagination">
							<c:if test="${pb.previousPageGroup}">
								<li><a
									href="findTradeHistoryListById.do?nowPage=${pb.startPageOfPageGroup-1}&type=구매">&laquo;</a></li>
							</c:if>
							<c:forEach var="i" begin="${pb.startPageOfPageGroup}"
								end="${pb.endPageOfPageGroup}">
								<c:choose>
									<c:when test="${pb.nowPage!=i}">
										<li><a
											href="findTradeHistoryListById.do?nowPage=${i}&type=구매">${i}</a></li>
									</c:when>
									<c:otherwise>
										<li class="active"><a href="javascript:;">${i}</a></li>
									</c:otherwise>
								</c:choose>
								&nbsp;
							</c:forEach>
							<c:if test="${pb.nextPageGroup}">
								<li><a
									href="findTradeHistoryListById.do?nowPage=${pb.endPageOfPageGroup+1}&type=구매">&raquo;</a>
								</li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

