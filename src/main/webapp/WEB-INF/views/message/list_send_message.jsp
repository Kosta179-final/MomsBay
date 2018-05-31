<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section id="cart_items">
	<div class="breadcrumbs">
		  <h3 class="active">보낸 쪽지함</h3>
	</div>
	<div class="table-responsive cart_info">
		<table class="table table-hover">
			<thead>
				<tr class="cart_menu">
					<!-- 상태 표시 구현 -->
					<td class="price">글 번호</td>
					<td class="price">받는사람</td>
					<td class="description">제목</td>
					<td class="quantity">작성일</td>
					<td class="price">수신확인</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="pvo" items="${requestScope.lvo.list}">
					<tr>
						<td class="cart_price">${pvo.messageNo}</td>
						<td class="cart_price">${pvo.receiveMemberVO.id}</td>
						<td class="cart_description"><a href="detail_message.do?messageNo=${pvo.messageNo}&messageType=send&pageNo=${requestScope.lvo.pagingBean.nowPage}">${pvo.title}</a></td>
		 				<td class="cart_quantity">${pvo.regdate}</td>
		 				<td class="cart_price">
							<c:choose>
							<c:when test="${pvo.receiveFlag }">
								${pvo.receiveDate }
							</c:when>
							<c:otherwise>
								읽지않음
							</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
		<c:set var="pb" value="${requestScope.lvo.pagingBean}"></c:set>
		<ul class="pagination">
			<li>
				<c:if test="${pb.previousPageGroup}">
					<a href="getSendMessageList.do?id=${sessionScope.member.id}&pageNo=${pb.startPageOfPageGroup-1}">&laquo;</a>
				</c:if>
			</li>
			<c:forEach var="i" begin="${pb.startPageOfPageGroup}"
				end="${pb.endPageOfPageGroup}">
				<c:choose>
					<c:when test="${pb.nowPage!=i}">
						<li>
						<a href="getSendMessageList.do?id=${sessionScope.member.id}&pageNo=${i}">${i}</a>
						</li>
					</c:when>
					<c:otherwise>
						<li class="active"><a href="#this">${i}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<li>
				<c:if test="${pb.nextPageGroup}">
				<a href="getSendMessageList.do?id=${sessionScope.member.id}&pageNo=${pb.endPageOfPageGroup+1}">&raquo;</a>
				</c:if>
			</li>
		</ul>
</section> <!--/#cart_items-->