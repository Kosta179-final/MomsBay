<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	function addSharePost(){
		location.href="add_share_post.do?boardTypeNo=${requestScope.boardTypeNo}&categoryNo=${requestScope.categoryNo}";
	}
</script>
<div class="features_items">
	<div class="row">	
	<!--features_items-->
	<h2 class="title text-center">게시글 목록</h2>
	
	
	<c:forEach items="${requestScope.svo.list}" var="pvo">
		<%-- 나눔 게시글 목록 --%>
		<div class="col-sm-4">
			<div class="product-image-wrapper">
				<div class="single-products">
					<div class="productinfo text-center">
						<img src="${pageContext.request.contextPath}/resources/upload/images/stroller.jpg" alt=""/>
						<h2>${pvo.title}</h2>
						<p>등록일 : ${pvo.regdate}</p>
						<p>작성자 : ${pvo.memberVO.id}</p>
					</div>
				</div>
				<div class="choose">
					<ul class="nav nav-pills nav-justified">
						<li><a class="btn btn-primary" href="detail_share_post.do?noneTradePostNo=${pvo.noneTradePostNo}">
							<i class="fa fa-plus-square"></i>상세보기</a>
						</li>
					</ul>
				</div>
			</div>
		</div>	
		</c:forEach>
	</div>
	
	<%-- 글쓰기 버튼 --%>
	<div class="row">
		<div class="col-sm-11">
			<div align="right">
				<button name="button" class="btn btn-primary" onclick="addSharePost()">글쓰기</button><br>
			</div>
		</div>
	</div>
	<div class="row" style="width: 50">
	
	<%-- 페이징 처리 --%>
	<div class="pagingInfo">
		<c:set var="pb" value="${requestScope.svo.pagingBean}"></c:set>
			<ul class="pagination">
				<c:if test="${pb.previousPageGroup}">
					<li><a href="list_share_post.do?pageNo=${pb.startPageOfPageGroup-1}&boardTypeNo=${requestScope.boardTypeNo}&categoryNo=${requestScope.categoryNo}">&laquo;</a></li>
				</c:if>
				<c:forEach var="i" begin="${pb.startPageOfPageGroup}" end="${pb.endPageOfPageGroup}">
					<c:choose>
						<c:when test="${pb.nowPage!=i}">
							<li><a href="list_share_post.do?pageNo=${i}&boardTypeNo=${requestScope.boardTypeNo}&categoryNo=${requestScope.categoryNo}">${i}</a></li>
						</c:when>
						<c:otherwise>
							<li class="active"><a href="#this">${i}</a></li>
						</c:otherwise>
					</c:choose>
						&nbsp;
				</c:forEach>
				<c:if test="${pb.nextPageGroup}">
					<li><a href="list_share_post.do?pageNo=${pb.endPageOfPageGroup+1}&boardTypeNo=${requestScope.boardTypeNo}&categoryNo=${requestScope.categoryNo}">&raquo;</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</div>
