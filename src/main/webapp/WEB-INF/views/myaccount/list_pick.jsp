<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	function deleteMemberPick(tradePostNo){
		location.href="deleteMemberPick.do?tradePostNo="+tradePostNo;
	}
	function detail(tradePostNo){
		var url = "${pageContext.request.contextPath}";
		location.href=url+"/trade/detail_trade_post.do?tradePostNo="+tradePostNo+"";
	}
</script>




<div class="container">
	<ul class="nav nav-tabs">
		<li class="active"><a data-toggle="tab" href="#home">찜 목록</a></li>
		<!-- <li><a data-toggle="tab" href="#menu1">거래내역</a></li>
		<li><a data-toggle="tab" href="#menu2">충전내역</a></li>
		<li><a data-toggle="tab" href="#menu3">환전내역</a></li> -->
	</ul>

	<div class="tab-content row text-left col-sm-8">
		<div id="home" class="tab-pane fade in active">
			<br>
			<table class="table">
				<thead>
					<tr>
						<th>No.</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>찜 수</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${!empty listVO }">
							<c:forEach items="${listVO.list}" var="list" varStatus="cc">
								<tr onclick="detail(${list.tradePostNo})">
									<td>${cc.count }</td>
									<td>${list.title}</td>
									<td>${list.memberVO.name}</td>
									<td>${list.regdate}</td>
									<td>${list.pickCount}</td>
									<td><a href="deleteMemberPick.do?tradePostNo=${list.tradePostNo}" class="btn btn-primary" onclick="deleteMemberPick(${list.tradePostNo})">삭제</a></td>
								</tr>
							</c:forEach>
						</c:when>
					</c:choose>
				</tbody>
			</table>
			<c:if test="${empty listVO.list}">
				<label> 찜 목록이 없습니다. </label>
			</c:if>
		</div>
		<div class="row col-sm-offset-5">
			<div class="pagingInfo">
				<c:set var="pb" value="${requestScope.listVO.pagingBean}"></c:set>
				<ul class="pagination">
					<c:if test="${pb.previousPageGroup}">
						<li><a
							href="findPickListById.do?nowPage=${pb.startPageOfPageGroup-1}">&laquo;</a></li>
					</c:if>
					<c:forEach var="i" begin="${pb.startPageOfPageGroup}"
						end="${pb.endPageOfPageGroup}">
						<c:choose>
							<c:when test="${pb.nowPage!=i}">
								<li><a
									href="findPickListById.do?nowPage=${i}">${i}</a></li>
							</c:when>
							<c:otherwise>
								<li class="active"><a href="javascript:;">${i}</a></li>
							</c:otherwise>
						</c:choose>
						&nbsp;
					</c:forEach>
					<c:if test="${pb.nextPageGroup}">
						<li><a
							href="findPickListById.do?nowPage=${pb.endPageOfPageGroup+1}">&raquo;</a>
						</li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
</div>

