<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<style>
#sortable1, #sortable2 {
	border: 1px solid #eee;
	width: 200px;
	min-height: 400px;
	list-style-type: none;
	margin: 0;
	padding: 5px 0 0 0;
	float: left;
	margin-right: 5px;
	overflow: scroll;
}

#sortable1 li, #sortable2 li {
	margin: 0 5px 5px 5px;
	padding: 5px;
	font-size: 1em;
	width: 180px;
}

.scrollBind {
	
}

/* width */
::-webkit-scrollbar {
	width: 10px;
}

/* Track */
::-webkit-scrollbar-track {
	background: #f1f1f1;
}

/* Handle */
::-webkit-scrollbar-thumb {
	background: #888;
}

/* Handle on hover */
::-webkit-scrollbar-thumb:hover {
	background: #555;
}
</style>

<script type="text/javascript">
	$(document).ready(
			function() {
				$("#sortable1, #sortable2").sortable({
					connectWith : ".connectedSortable",
					stop : function(event, ui) {
						var id = ui.item[0].innerHTML;
						$.ajax({
							type : "get",
							dataType : "json",
							url : "updateMemberStatus.do",
							data : "id=" + id,
							success : function(data) {
								if (data.status == 'toBlackList') {
									alert(id + '님을 블랙리스트에 추가 했습니다.');
								} else {
									alert(id + '님 등급을 회원으로 변경 했습니다.');
								}
							}
						});
					},
				}).disableSelection();

				$("#memberId").autocomplete(
						{
							source : "searchMemberById.do?",
							minLength : 2,
							select : function(event, ui) {
								$("#memberListBtn").css("display", "none");   
								$("#blackListBtn").css("display", "none"); 
								$.ajax({
									type : "get",
									dataType : "json",
									url : "findMemberById.do",
									data : "id=" + ui.item.value,
									success : function(data) {
										$("#Result").html(
												"아이디:" + data.id + "<br>"
														+ "회원명:" + data.name
														+ "<br>" + "회원등급:"
														+ data.grade + "<br>"
														+ "이메일:" + data.email
														+ "<br>" + "현재 보유 포인트:"
														+ data.point + "<br>"
														+ "평점:" + data.rating
														+ "<br>" + "전화번호:"
														+ data.tel + "<br>");
										if(data.grade == 'member'){
											$("#blackListBtn").css("display", "block");   
										}else if(data.grade=='blacklist'){
											$("#memberListBtn").css("display", "block");   
										}else{
											alert("관리자는 등급변경이 불가능합니다.");
										}
									}
								});
							}
						});
				
				$(".change").click(function(){
					var con= confirm("정말 변경하겠습니까?");
					if(con){
						 $("#changeGrade").submit(); 
					}else{
						return false;
					}					
				});
			});
</script>

<div class="container">
	<div class="col-sm-8">
		<h3 class=" row text-left">&nbsp;회원 등급 관리</h3>
		<ul class="nav nav-tabs">
			<li class="active"><a data-toggle="tab" href="#dragAndDrop">드래그
					앤 드롭</a></li>
			<li><a data-toggle="tab" href="#searchById">아이디로 검색</a></li>
		</ul>
	</div>
	<div class="tab-content row text-left col-sm-8 ">
		<div id="dragAndDrop" class="tab-pane fade in active" style="width: 900px; height: 500px; margin-top: 10px;">
			<p>드래그 앤 드롭으로 회원등급을 변경해 보세요!</p>
			<ul id="sortable1" class="connectedSortable " title="member">
				<li class="ui-widget-header">일반회원 리스트</li>
				<c:forEach items="${memberList}" var="ml">
					<li class="ui-state-default member" value="${ml }">${ml}</li>
				</c:forEach>
			</ul>
			<div class="col-sm-2"></div>
			<ul id="sortable2" class="connectedSortable" title="blacklist">
				<li class="ui-widget-header">블랙리스트</li>
				<c:forEach items="${blackList}" var="bl">
					<li class="ui-state-default blackList" value="${bl }">${bl}</li>
				</c:forEach>
			</ul>
		</div>
		<div id="searchById" class=" tab-pane fade" style="width: 900px; height: 500px; margin-top: 10px; margin-left: 20px; ">
			<p>회원검색으로 등급을 변경해 보세요!</p>
			<div class="ui-widget" style="margin-top: 2em; font-family: Arial">
			<form id="changeGrade" action="updateMemberStatusOnSubmit.do" method="post">
				<label for="memberId">ID&nbsp;</label> <input id="memberId" name="id" style=" border:1px solid black;"><br>		
			</form>
				<label>회원 현황</label><div id="Result" style="height: 200px; width: 300px; overflow: auto; border:1px solid black; padding: 10px;"></div>
				<br>
			<input type="button" value="블랙리스트에 추가"  class="btn btn-warning change" style=" display:none;" id="blackListBtn">
			<input type="button" value="일반 멤버로 변경"  class="btn btn-warning change" style=" display:none;" id="memberListBtn">
			</div>
		</div>
	</div>
</div>