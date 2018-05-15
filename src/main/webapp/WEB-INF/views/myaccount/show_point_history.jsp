<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	function openCity(evt, cityName) {
		var i, tabcontent, tablinks;
		tabcontent = document.getElementsByClassName("tabcontent");
		for (i = 0; i < tabcontent.length; i++) {
			tabcontent[i].style.display = "none";
		}
		tablinks = document.getElementsByClassName("tablinks");
		for (i = 0; i < tablinks.length; i++) {
			tablinks[i].className = tablinks[i].className
					.replace(" active", "");
		}
		document.getElementById(cityName).style.display = "block";
		evt.currentTarget.className += " active";
	}

	$(document).ready(function() {
		openCity(event, 'total');
	});
</script>
<style>

/* Style the tab */
.tab {
	overflow: hidden;
	border: 1px solid #ccc;
	background-color: #f1f1f1;
}

/* Style the buttons inside the tab */
.tab button {
	background-color: inherit;
	float: left;
	border: none;
	outline: none;
	cursor: pointer;
	padding: 14px 16px;
	transition: 0.3s;
	font-size: 17px;
}

/* Change background color of buttons on hover */
.tab button:hover {
	background-color: #ddd;
}

/* Create an active/current tablink class */
.tab button.active {
	background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
	display: none;
	padding: 6px 12px;
	border: 1px solid #ccc;
	border-top: none;
}
</style>



<div class="tab">
	<button class="tablinks" onclick="openCity(event, 'total')">총
		내역</button>
	<button class="tablinks" onclick="openCity(event, 'trade')">거래
		내역</button>
	<button class="tablinks" onclick="openCity(event, 'charge')">충전
		내역</button>
	<button class="tablinks" onclick="openCity(event, 'exchage')">환전
		내역</button>
</div>

<div id="total" class="tabcontent">
	<div class="container">
		<div class="row text-left">
			<div class="col-sm-8 ">
				<h2>총 내역</h2>
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
									<tr class="active">
										<td>${cc.count }</td>
										<td>${list.type}</td>
										<c:if test="${list.type eq '구매' || list.type eq '환전'}">
											<td>-${list.price}</td>
										</c:if>
										<c:if test="${list.type eq '판매' || list.type eq '충전'}">
											<td>+${list.price}</td>
										</c:if>
										<td></td>
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
		</div>
	</div>
</div>

<div id="trade" class="tabcontent">
	<div class="container">
		<div class="row text-left">
			<div class="col-sm-8 ">
				<h2>거래 내역</h2>
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
										<tr class="active">
											<td>${cc.count }</td>
											<td>${list.type}</td>
											<c:if test="${list.type eq '구매' }">
												<td>-${list.price}</td>
											</c:if>
											<c:if test="${list.type eq '판매'}">
												<td>+${list.price}</td>
											</c:if>
											<td></td>
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
</div>

<div id="charge" class="tabcontent">
	<div class="container">
		<div class="row text-left">
			<div class="col-sm-8 ">
				<h2>충전 내역</h2>
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
										<tr class="active">
											<td>${cc.count }</td>
											<td>+${list.price}</td>
											<td></td>
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
</div>

<div id="exchage" class="tabcontent">
	<div class="container">
		<div class="row text-left">
			<div class="col-sm-8 ">
				<h2>환전 내역</h2>
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
										<tr class="active">
											<td>${cc.count }</td>
											<td>-${list.price}</td>
											<td></td>
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
</div>
