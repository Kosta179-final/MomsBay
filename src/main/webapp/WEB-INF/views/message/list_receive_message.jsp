<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
$(document).ready(function(){
    if (performance.navigation.type != 1) {
      location.reload();
    }
});
</script>
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
						<td class="cart_description"><a href="detail_message.do?messageNo=${pvo.messageNo}&messageType=receive&pageNo=${requestScope.lvo.pagingBean.nowPage}">${pvo.title}</a></td>
						<td class="cart_price">${pvo.memberVO.id}</td>
		 				<td class="cart_quantity">${pvo.regdate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<c:if test="${empty requestScope.lvo.list}">
			게시글이 존재하지 않습니다.
		</c:if>
	</div>
		<c:set var="pb" value="${requestScope.lvo.pagingBean}"></c:set>
		<ul class="pagination">
			<li>
				<c:if test="${pb.previousPageGroup}">
					<a href="getReceiveMessageList.do?id=${sessionScope.member.id}&pageNo=${pb.startPageOfPageGroup-1}">&laquo;</a>
				</c:if>
			</li>
			<c:forEach var="i" begin="${pb.startPageOfPageGroup}"
				end="${pb.endPageOfPageGroup}">
				<c:choose>
					<c:when test="${pb.nowPage!=i}">
						<li>
						<a href="getReceiveMessageList.do?id=${sessionScope.member.id}&pageNo=${i}">${i}</a>
						</li>
					</c:when>
					<c:otherwise>
						<li class="active"><a href="#this">${i}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<li>
				<c:if test="${pb.nextPageGroup}">
				<a href="getReceiveMessageList.do?id=${sessionScope.member.id}&pageNo=${pb.endPageOfPageGroup+1}">&raquo;</a>
				</c:if>
			</li>
		</ul>
</section> <!--/#cart_items-->