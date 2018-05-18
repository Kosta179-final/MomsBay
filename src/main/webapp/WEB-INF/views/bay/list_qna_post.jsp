<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	function addQnaPost(){
		location.href="add_qna_post.do?boardTypeNo=${requestScope.boardTypeNo}";
	}
</script>
<section id="cart_items">
		<div class="container">
			<div class="breadcrumbs">
				  <h3 class="active">질문게시판</h3>
				<ol class="breadcrumb">
					<li class="active">QnA게시판입니다</li>
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
						<c:forEach var="qvo" items="${requestScope.lvo.list}">
							<tr>
								<td class="cart_product">${qvo.bayPostNo}</td>
								<td class="cart_description">
								<c:choose>
									<c:when test="${sessionScope.member!=null }">
									<a href="detail_qna_post.do?bayPostNo=${qvo.bayPostNo}">${qvo.title}</a>
									</c:when>
									</c:choose>
									</td>
								<td class="cart_price">${qvo.memberVO.name}</td>
				 				<td class="cart_quantity">${qvo.regdate}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col-sm-11 off-set-1">
					<div align="right">
						<button name="button" class="btn btn-primary" onclick="addQnaPost()">글쓰기</button><br>
					</div>
			</div>
			<%-- 페이징빈 부분 --%>
				<div class="pagingInfo">
				<c:set var="pb" value="${requestScope.lvo.pagingBean}"></c:set>
				<ul class="pagination">
					<c:if test="${pb.previousPageGroup}">
						<li><a
							href="list_qna_post.do?pageNo=${pb.startPageOfPageGroup-1}&boardTypeNo=${requestScope.boardTypeNo}">&laquo;</a></li>
					</c:if>
					<c:forEach var="i" begin="${pb.startPageOfPageGroup}"
						end="${pb.endPageOfPageGroup}">
						<c:choose>
							<c:when test="${pb.nowPage!=i}">
								<li><a
									href="list_qna_post.do?pageNo=${i}&boardTypeNo=${requestScope.boardTypeNo}">${i}</a></li>
							</c:when>
							<c:otherwise>
								<li class="active"><a href="#this">${i}</a></li>
							</c:otherwise>
						</c:choose>
						&nbsp;
					</c:forEach>
					<c:if test="${pb.nextPageGroup}">
						<li><a
							href="list_qna_post.do?pageNo=${pb.endPageOfPageGroup+1}&boardTypeNo=${requestScope.boardTypeNo}">&raquo;</a>
						</li>
					</c:if>
				</ul>
			</div>
		</div>
			<%-- 페이징빈 부분 --%>
</section> <!--/#cart_items-->