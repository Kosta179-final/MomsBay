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
				<table class="table table-hover">
					<thead>
						<tr class="cart_menu">
							<td class="price">글 번호</td>
							<td class="description">제목</td>
							<td class="quantity">작성자</td>
							<td class="price">작성일</td>
							<td class="hit">HIT</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="qvo" items="${requestScope.qlvo.list}">
							<tr>
								<td class="cart_price">${qvo.bayPostNo}</td>
								<td class="cart_description">
								<c:choose>
									<c:when test="${sessionScope.member!=null }">
									<a href="detail_qna_post.do?bayPostNo=${qvo.bayPostNo}">[${qvo.subjectVO.subject}] &nbsp;${qvo.title}</a>
									</c:when>
									<c:otherwise>
										[${qvo.subjectVO.subject}] &nbsp; ${qvo.title}
									</c:otherwise>
									</c:choose>
									</td>
								<td class="cart_quantity">${qvo.memberVO.name}</td>
				 				<td class="cart_price">${qvo.regdate}</td>
				 				<td class="hit">${qvo.hits }</td>
							</tr>
						</c:forEach>
						<c:forEach var="qv" items="${requestScope.lvo.list}">
							<tr>
								<td class="cart_price">${qv.bayPostNo}</td>
								<td class="cart_description">
									<c:choose>
									<c:when test="${sessionScope.member!=null }">
									<a href="detail_qna_post.do?bayPostNo=${qv.bayPostNo }">[${qv.subjectVO.subject}] &nbsp; ${qv.title}</a>
									</c:when>
									<c:otherwise>
										[${qv.subjectVO.subject}] &nbsp; ${qv.title}
									</c:otherwise>
									</c:choose>
									</td>
								<td class="cart_quantity">${qv.memberVO.name}</td>
				 				<td class="cart_price">${qv.regdate }</td>
				 				<td class="hit">${qv.hits }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			
			<div class="row">
					<div class="pull-right">
					<c:if test="${sessionScope.member!=null }">
						<button name="button" class="btn btn-primary" onclick="addQnaPost()">글쓰기</button><br>
					</c:if>
					</div>
			</div>
			<%-- 페이징빈 부분 --%>
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
								<li>
								<a href="list_qna_post.do?pageNo=${i}&boardTypeNo=${requestScope.boardTypeNo}">${i}</a>
								</li>
							</c:when>
							<c:otherwise>
								<li class="active"><a href="#this">${i}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<li>
					 <c:if test="${pb.nextPageGroup}">
						<a href="list_qna_post.do?pageNo=${pb.endPageOfPageGroup+1}&boardTypeNo=${requestScope.boardTypeNo}">&raquo;</a>
					 </c:if>
					</li>
				</ul>
			</div>
			<%-- 페이징빈 부분 --%>
</section> <!--/#cart_items-->