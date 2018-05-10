<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section id="cart_items">
		<div class="container">
			<div class="breadcrumbs">
				  <h3 class="active">자유게시판</h3>
				<ol class="breadcrumb">
					<li class="active">일상적인 이야기를 나눌 수 있는 자유게시판입니다</li>
				</ol>
			</div>
		<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="cart_product">글 번호</td>
							<td class="description">제목</td>
							<td class="price">작성자</td>
							<td class="quantity">작성일</td>
							<td class="total">조회수</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach begin="1" end="10">
							<tr>
								<td class="cart_product">1</td>
								<td class="cart_description">제목1입니다</td>
								<td class="cart_price">아이유</td>
				 				<td class="cart_quantity">2018.5.6</td>
								<td class="cart_total">10</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="pagingInfo">
				<c:set var="pb" value="${requestScope.lvo.pagingBean}"></c:set>
				<ul class="pagination">
					<c:if test="${pb.previousPageGroup}">
						<li><a
							href="#">&laquo;</a></li>
					</c:if>
					<c:forEach var="i" begin="${pb.startPageOfPageGroup}"
						end="${pb.endPageOfPageGroup}">
						<c:choose>
							<c:when test="${pb.nowPage!=i}">
								<li><a
									href="#">${i}</a></li>
							</c:when>
							<c:otherwise>
								<li class="active"><a href="#">${i}</a></li>
							</c:otherwise>
						</c:choose>
						&nbsp;
						</c:forEach>
							<c:if test="${pb.nextPageGroup}">
						<li><a
							href="#">&raquo;</a></li>
						</c:if>
					</ul>
				</div>
		</div>
	</section> <!--/#cart_items-->