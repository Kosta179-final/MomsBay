<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section id="cart_items">
	<div class="breadcrumbs">
		  <h3 class="active">받은 쪽지함</h3>
	</div>
	<div class="table-responsive cart_info">
		<table class="table table-hover">
			<thead>
				<tr class="cart_menu">
					<!-- 상태 표시 구현 -->
					<td class="price">글 번호</td>
					<td class="price">읽음/안읽음</td>
					<td class="description">제목</td>
					<td class="price">작성자</td>
					<td class="quantity">작성일</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="pvo" items="${requestScope.lvo.list}">
					<tr>
						<td class="cart_price">${pvo.messageNo}</td>
						<td class="cart_price">
							<c:choose>
							<c:when test="${pvo.status }">
								<a class="glyphicon glyphicon-inbox"></a>
							</c:when>
							<c:otherwise>
								<a class="glyphicon glyphicon-envelope"></a>
							</c:otherwise>
							</c:choose>
						</td>
						<td class="cart_description">${pvo.title}</td>
						<td class="cart_price">${pvo.memberVO.id}</td>
		 				<td class="cart_quantity">${pvo.regdate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
		<c:set var="pb" value="${requestScope.lvo.pagingBean}"></c:set>
		<ul class="pagination">
			<li>
				<c:if test="${pb.previousPageGroup}">
					<a href="list_bulletin_post.do?pageNo=${pb.startPageOfPageGroup-1}&boardTypeNo=${requestScope.boardTypeNo}">&laquo;</a>
				</c:if>
			</li>
			<c:forEach var="i" begin="${pb.startPageOfPageGroup}"
				end="${pb.endPageOfPageGroup}">
				<c:choose>
					<c:when test="${pb.nowPage!=i}">
						<li>
						<a href="list_bulletin_post.do?pageNo=${i}&boardTypeNo=${requestScope.boardTypeNo}">${i}</a>
						</li>
					</c:when>
					<c:otherwise>
						<li class="active"><a href="#this">${i}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<li>
				<c:if test="${pb.nextPageGroup}">
				<a href="getReceiveMessageList.do?receiveId=${sessionScope.member.id}&pageNo=${pb.endPageOfPageGroup+1}&boardTypeNo=${requestScope.boardTypeNo}">&raquo;</a>
				</c:if>
			</li>
		</ul>
</section> <!--/#cart_items-->