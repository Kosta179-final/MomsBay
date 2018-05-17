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

.scrollBind{
	
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
$(document).ready(function(){
		$("#sortable1, #sortable2").sortable({
			connectWith : ".connectedSortable",
			stop: function( event, ui ) {
				var id=ui.item[0].innerHTML;
				$.ajax({
					type:"get",
					dataType:"json",
					url:"updateMemberStatus.do",
					data: "id="+id,
					success:function(data){
						if(data.status=='toBlackList'){
							alert(id+'님을 블랙리스트에 추가 했습니다.');
						}else{
							alert(id+'님 등급을 회원으로 변경 했습니다.');
						}
						}
					});
			},
		}).disableSelection();
	});
	

</script>

<div class="col-sm-8 ">
	<h3 class=" row text-left">&nbsp;회원 등급 관리</h3>
	<p class=" row text-left">드래그 앤 드롭으로 회원등급을 변경해 보세요!</p>
	<hr>
	<div>
		<ul id="sortable1" class="connectedSortable " title="member" >
		<li class="ui-widget-header" >일반회원 리스트</li>
			<c:forEach items="${memberList}" var="ml">
				<li class="ui-state-default member" value="${ml }" >${ml}</li>
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
</div>