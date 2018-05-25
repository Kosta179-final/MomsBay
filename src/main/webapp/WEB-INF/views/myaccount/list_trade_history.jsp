<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<ul class="nav nav-tabs">
		<li class="active"><a data-toggle="tab" href="#home">구매내역</a></li>
		<li><a data-toggle="tab" href="#menu1">판매내역</a></li>
	</ul>

	<div class="tab-content row text-left col-sm-8">
		<div id="home" class="tab-pane fade in active">
			<br>
			<table class="table">
				<thead>
					<tr>
						<th>No.</th>
						<th>거래상태</th>
						<th>구매자</th>
						<th>게시글제목</th>
						<th>가격</th>
						<th>거래종류</th>
						<th>거래시간</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${!empty tradeHistoryVO }">
						<c:forEach items="${tradeHistoryVO}" var="list" varStatus="cc">
							<tr>
								<td>${cc.count}</td>
								<td>${list.status}</td>
								<td>${list.tradePostVO.tradeId}</td>
								<td>${list.tradePostVO.title}</td>
								<td>${list.tradePostVO.price}</td>
								<td>${list.tradePostVO.tradeType}</td>
								<td>${list.regdate}</td>
								<td><button class="btn btn-primary">
									<c:if test="${list.status eq '거래중'}">
										거래완료
									</c:if>
								</button>
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
			<c:if test="${empty tradeHistoryVO}">
				<label> 거래 내역이 없습니다. </label>
			</c:if>
		</div>

		<div id="menu1" class="tab-pane fade">
			<br>
			<table class="table">
				<thead>
					<tr>
						<th>No.</th>
						<th>거래상태</th>
						<th>판매자</th>
						<th>게시글제목</th>
						<th>거래시간</th>
					</tr>
				</thead>
				<tbody>
					<%-- <c:if test="${!empty pointHistory }">
						<c:forEach items="${pointHistory}" var="list" varStatus="cc">
						</c:forEach>
					</c:if> --%>
							<tr>
								<td>1</td>
								<td>배송하기</td>
								<td>아이유</td>
								<td>유모차팜</td>
								<td>2018.05.18</td>
							</tr>

				</tbody>
			</table>
			<c:if test="${empty tradeHistoryVO}">
				<label> 거래 내역이 없습니다. </label>
			</c:if>
		<%-- </div>
		<div id="menu2" class="tab-pane fade">
			<br>
			<table class="table">
				<thead>
					<tr>
						<th>No.</th>
						<th>충전 내역</th>
						<th>남은 포인트</th>
						<th>거래 날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${!empty pointHistory }">
							<c:forEach items="${pointHistory}" var="list" varStatus="cc">
								<c:if test="${list.type eq '충전' }">
									<tr>
										<td>${cc.count }</td>
										<td>+${list.price}</td>
										<td>${list.point}</td>
										<td>${list.regdate}</td>
									</tr>
								</c:if>
							</c:forEach>
						</c:when>
					</c:choose>
				</tbody>
			</table>
			<c:if test="${empty pointHistory}">
				<label> 포인트 내역이 없습니다. </label>
			</c:if>
		</div> --%>
	</div>
</div>
</div>

