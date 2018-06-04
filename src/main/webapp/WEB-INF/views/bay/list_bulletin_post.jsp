<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	function addPost(){
		location.href="${pageContext.request.contextPath}/bay/add_bulletin_post.do?boardTypeNo=${requestScope.boardTypeNo}";
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
				<table class="table table-hover">
					<thead>
						<tr class="cart_menu">							
							<td class="price">글 번호</td>
							<td class="description">제목</td>
							<td class="quantity">작성자</td>
							<td class="price">작성일</td>
							<td class="price">조회수</td>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="pv" items="${requestScope.alvo.list }">
								<tr>
								<td class="cart_price">${pv.bayPostNo}</td>
								<td class="cart_description">
									<c:choose>
									<c:when test="${sessionScope.member!=null }">
									<a href="detail_bay.do?bayPostNo=${pv.bayPostNo }">[${pv.subjectVO.subject}]&nbsp;${pv.title}</a>
									</c:when>
									<c:otherwise>
										[${pv.subjectVO.subject}]&nbsp;${pv.title}
									</c:otherwise>
									</c:choose>
									</td>
								<td class="cart_quantity">${pv.memberVO.id}</td>
				 				<td class="cart_price">${pv.regdate }</td>
				 				<td class="cart_price">${pv.hits }</td>
							</tr>
							</c:forEach>
						<c:forEach var="pvo" items="${requestScope.lvo.list}">
							<tr>
								<td class="cart_price">${pvo.bayPostNo}</td>
								<td class="cart_description">
									<c:choose>
									<c:when test="${sessionScope.member!=null }">
									<a href="detail_bay.do?bayPostNo=${pvo.bayPostNo }">[${pvo.subjectVO.subject}]&nbsp;${pvo.title}</a>
									</c:when>
									<c:otherwise>
										[${pvo.subjectVO.subject}]&nbsp;${pvo.title}
									</c:otherwise>
									</c:choose>
									</td>
								<td class="cart_quantity">${pvo.memberVO.id}</td>
				 				<td class="cart_price">${pvo.regdate }</td>
				 				<td class="cart_price">${pvo.hits }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="row">
					<div class="pull-right">
					<c:if test="${sessionScope.member!=null }">
						<button name="button" class="btn btn-primary" onclick="addPost()">글쓰기</button><br>
					</c:if>
					</div>
			</div>
		<c:set var="pb" value="${requestScope.lvo.pagingBean}"></c:set>
		<ul class="pagination">
			<li>
				<c:if test="${pb.previousPageGroup}">
					<a href="list_bulletin_post.do?pageNo=${pb.startPageOfPageGroup-1}&boardTypeNo=${requestScope.boardTypeNo}&pageNo=${pb.startPageOfPageGroup-1}">&laquo;</a>
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
				<a href="list_bulletin_post.do?pageNo=${pb.endPageOfPageGroup+1}&boardTypeNo=${requestScope.boardTypeNo}">&raquo;</a>
				</c:if>
			</li>
		</ul>
		</div>
</section> <!--/#cart_items-->