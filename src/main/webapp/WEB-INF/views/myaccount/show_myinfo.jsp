<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
	function modifyInfo() {
		location.href = "password_check.do";
	}
</script>
<div class="container">
	<div class="row text-left">
		<div class="col-sm-6 col-sm-offset-1" style="padding-bottom: 20px;">
			<table class="table table-hover">
				<thead>
					<tr>
						<th><b style="font-size: 25px;">내 정보</b> <br></th>
					</tr>			
					<tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 170px;"><b  style="font-size: 15px;">아이디</b></td><td>&nbsp;${member.id }</td>
					</tr>
					<tr>
						<td style="width: 170px;"><b  style="font-size: 15px;">현재 포인트</b></td><td>&nbsp;<fmt:formatNumber value="${currentPoint}" pattern="#,###.##"/></td>
					</tr>
					<tr>
						<td style="width: 170px;"><b  style="font-size: 15px;">이메일</b></td><td>&nbsp;${member.email }</td>
					</tr>
					<tr>
						<td style="width: 170px;"><b  style="font-size: 15px;">연락처</b></td><td>&nbsp;${member.tel }</td>
					</tr>
					<tr>
						<td style="width: 170px;"><b  style="font-size: 15px;">주소</b></td><td>&nbsp;${member.address }</td>
					</tr>
					<tr>
						<td style="width: 170px;"><b  style="font-size: 15px;">상세주소</b></td><td>&nbsp;${member.address2 }</td>
					</tr>
				</tbody>
			</table>
		<input type="button" class="btn btn-success" value="내 정보 수정" style="margin-top: 5px; text-align: right;" onclick="modifyInfo()">
			<!--/registerform-->
			<hr>
			<b style="font-size: 25px;">자녀 정보</b>
			<div id="append_field" class="text-left"></div>
			<c:if test="${member.children_no ne '0'}">
				<c:forEach items="${member.list}" var="children">
					<div class="append_div">
						<form style="padding-bottom: 2px">
							<input type="hidden" value="${member.id }"><br>
							<table class="table table-hover">
								<tr>
									<td><b  style="font-size: 15px;">성별</b></td>
									<td>
										<c:if test="${children.gender eq 'male'}">
											<span>남아</span>
										</c:if>
										<c:if test="${children.gender eq 'female'}">
											<span>여아</span>
										</c:if>
									</td>
									<td><b  style="font-size: 15px;">생년월일</b></td>
									<td>${children.birth}</td>
								</tr>
							</table>
							<!--  <input type="button" class="btn btn-warning rmv" value="삭제하기"  name="childDelBtn"> -->
						</form>
					</div>
				</c:forEach>
			</c:if>
			<hr>
			<!-- <input type="button" class="btn btn-info" onclick="append_div()" value="추가하기" > -->
		</div>
	</div>
</div>
