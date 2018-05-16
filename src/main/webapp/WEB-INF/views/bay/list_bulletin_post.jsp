<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	function addPost(){
		location.href="add_bulletin_post.do?boardTypeNo=${requestScope.boardTypeNo}";
	}
</script>

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
						</tr>
					</thead>
					<tbody>
						<c:forEach var="pvo" items="${requestScope.lvo.list}">
							<tr>
								<td class="cart_product">${pvo.bayPostNo}</td>
								<td class="cart_description">
									<c:choose>
									<c:when test="${sessionScope.member!=null }">
									<a href="detail_bay.do?bayPostNo=${pvo.bayPostNo }">${pvo.title}</a>
									</c:when>
									</c:choose>
									</td>
								<td class="cart_price">${pvo.name}</td>
				 				<td class="cart_quantity">${pvo.regdate }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col-sm-11 off-set-1">
					<div align="right">
						<button name="button" class="btn btn-primary" onclick="addPost()">글쓰기</button><br>
					</div>
			</div>
			<div class="pagingInfo">
				<c:set var="pb" value="${requestScope.lvo.pagingBean}"></c:set>
				<ul class="pagination">
					<c:if test="${pb.previousPageGroup}">
						<li><a
							href="list_bulletin_post.do?pageNo=${pb.startPageOfPageGroup-1}&type=${requestScope.type}">&laquo;</a></li>
					</c:if>
					<c:forEach var="i" begin="${pb.startPageOfPageGroup}"
						end="${pb.endPageOfPageGroup}">
						<c:choose>
							<c:when test="${pb.nowPage!=i}">
								<li><a
									href="list_bulletin_post.do?pageNo=${i}&type=${requestScope.type}">${i}</a></li>
							</c:when>
							<c:otherwise>
								<li class="active"><a href="#this">${i}</a></li>
							</c:otherwise>
						</c:choose>
						&nbsp;
					</c:forEach>
					<c:if test="${pb.nextPageGroup}">
						<li><a
							href="list_bulletin_post.do?pageNo=${pb.endPageOfPageGroup+1}&type=${requestScope.type}">&raquo;</a>
						</li>
					</c:if>
				</ul>
			</div>
		</div>
</section> <!--/#cart_items-->