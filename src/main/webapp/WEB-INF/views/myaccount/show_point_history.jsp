<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
function showPointHistory(){
	var flag= dates.compare($("#startDate").val(), $("#endDate").val());
	alert(flag);
}
</script>
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
			<label>거래 날짜로 조회</label><br>
			<input type="date" name="startDate" id="startDate">~
			<input type="date" name="endDate"  id="endDate">
			<input type="button" value="조회" onclick="showPointHistory()">
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
						<c:when test="${!empty pointHistory.list }">
							<c:forEach items="${pointHistory.list}" var="list" varStatus="cc">
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
			<div class="pagingInfo">
			<c:set var="pb" value="${pointHistory.pagingBean}"></c:set>
			<ul class="pagination">
				<c:if test="${pb.previousPageGroup}">
					<li><a
						href="getPointHistoryById.do?pageNo=${pb.startPageOfPageGroup-1}&id=${member.id}">&laquo;</a></li>
				</c:if>
				<c:forEach var="i" begin="${pb.startPageOfPageGroup}"
					end="${pb.endPageOfPageGroup}">
					<c:choose>
						<c:when test="${pb.nowPage!=i}">
							<li><a
								href="getPointHistoryById.do?pageNo=${i}">${i}</a></li>
						</c:when>
						<c:otherwise>
							<li class="active"><a href="javascript:;">${i}</a></li>
						</c:otherwise>
					</c:choose>
					&nbsp;
				</c:forEach>
				<c:if test="${pb.nextPageGroup}">
					<li><a
						href="getPointHistoryById.do?pageNo=${pb.endPageOfPageGroup+1}&id=${member.id}">&raquo;</a>
					</li>
				</c:if>
			</ul>
		</div>
		</div>
<!-- 여기까지 전체 내역 -->
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
						<c:when test="${!empty pointHistory.list }">
							<c:forEach items="${pointHistory.list}" var="list" varStatus="cc">
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
						<c:when test="${!empty pointHistory.list }">
							<c:forEach items="${pointHistory.list}" var="list" varStatus="cc">
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
						<c:when test="${!empty pointHistory.list}">
							<c:forEach items="${pointHistory.list}" var="list" varStatus="cc">
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
			<c:if test="${empty pointHistory.list}">
				<label> 포인트 내역이 없습니다. </label>
			</c:if>
		</div>
	</div>
</div>