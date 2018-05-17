<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<div class="col-sm-8">
	<ul class="nav nav-tabs">
		<li class="active"><a data-toggle="tab" href="#home">총 내역</a></li>
		<li><a data-toggle="tab" href="#menu1">거래내역</a></li>
		<li><a data-toggle="tab" href="#menu2">충전내역</a></li>
		<li><a data-toggle="tab" href="#menu3">환전내역</a></li>
	</ul>
	</div>
	<div class="tab-content row text-left col-sm-8">
		<div id="home" class="tab-pane fade in active">
			<br>
			<table class="table">
				<thead>
					<tr>
						<th>No.</th>
						<th>거래 종류</th>
						<th>거래 포인트</th>
						<th>남은 포인트</th>
						<th>거래 날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${!empty pointHistory }">
							<c:forEach items="${pointHistory}" var="list" varStatus="cc">
								<tr>
									<td>${cc.count }</td>
									<td>${list.type}</td>
									<c:if test="${list.type eq '구매' || list.type eq '환전'}">
										<td>-${list.price}</td>
									</c:if>
									<c:if test="${list.type eq '판매' || list.type eq '충전'}">
										<td>+${list.price}</td>
									</c:if>
									<td>${list.point}</td>
									<td>${list.regdate}</td>
								</tr>
							</c:forEach>
						</c:when>
					</c:choose>
				</tbody>
			</table>
			<c:if test="${empty pointHistory}">
				<label> 포인트 내역이 없습니다. </label>
			</c:if>
		</div>

		<div id="menu1" class="tab-pane fade">
			<br>
			<table class="table">
				<thead>
					<tr>
						<th>No.</th>
						<th>거래 종류</th>
						<th>거래 포인트</th>
						<th>남은 포인트</th>
						<th>거래 날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${!empty pointHistory }">
							<c:forEach items="${pointHistory}" var="list" varStatus="cc">
								<c:if test="${list.type eq '구매' || list.type eq '판매'}">
									<tr>
										<td>${cc.count }</td>
										<td>${list.type}</td>
										<c:if test="${list.type eq '구매' }">
											<td>-${list.price}</td>
										</c:if>
										<c:if test="${list.type eq '판매'}">
											<td>+${list.price}</td>
										</c:if>
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
		</div>
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
		</div>
		<div id="menu3" class="tab-pane fade">
			<br>
			<table class="table">
				<thead>
					<tr>
						<th>No.</th>
						<th>환전 내역</th>
						<th>남은 포인트</th>
						<th>거래 날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${!empty pointHistory }">
							<c:forEach items="${pointHistory}" var="list" varStatus="cc">
								<c:if test="${list.type eq '환전' }">
									<tr>
										<td>${cc.count }</td>
										<td>-${list.price}</td>
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
		</div>
	</div>
</div>