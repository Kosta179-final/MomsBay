<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
$(document).ready(function(){
	/* 자동로그인 */
	var uId = getCookie("mbId");
	var uToken = getCookie("mbToken");
	
	if(uId!="" &&  uToken !=""){
		location.href="${pageContext.request.contextPath}/member/autoLogin.do?id="+uId+"&token="+uToken
	}
	
	$("#register").click(function(){
		location.href="${pageContext.request.contextPath}/member/register.do";
	});
	
	$("#rememberMeFlag").click(function(){
		if($("#rememberMe").val() == "false"){
			$("#rememberMe").val("true");
		}else
			$("#rememberMe").val("false");
	});
	
	$("#findPasswordBtn").click(function(){
		if($("#name").val()=="" ||$("#email").val()=="" ){
			alert("이름과 이메일을 입력해주세요");
			return false;
		}else{
			$("#findPasswordForm").submit();
		}
	});
});

function getCookie(cookieName) {
    cookieName = cookieName + '=';
    var cookieData = document.cookie;
    var start = cookieData.indexOf(cookieName);
    var cookieValue = '';
    if(start != -1){
        start += cookieName.length;
        var end = cookieData.indexOf(';', start);
        if(end == -1)end = cookieData.length;
        cookieValue = cookieData.substring(start, end);
    }
    return unescape(cookieValue);
}
</script>
<section id="form">
	<!--form-->
	
	<div class="container">
		<div class="row">
			<div class="col-sm-3 col-sm-offset-4">
				<div class="login-form">
				<form action="${pageContext.request.contextPath}/member/login.do" id="login_form" method="post">
					<!--login form-->
					<h2>로그인</h2>
						<input type="text" placeholder="id" name="id" required="required" autofocus="autofocus"/>
						<input type="password" placeholder="password" name="password" required="required"/>
						<Button type="submit" id="login" style="width: 100%">로그인</Button>
						<Button type="button"   id="register" style="width: 100%; background-color: #FE980F;">회원가입</Button>
						<input type="hidden" id="rememberMe" name="rememberMe" value="false">
							</form>
				</div>
				<!--/login form-->
				<div>
				<input type="button" class="btn btn-link"  id="findPassword"  data-toggle="modal" data-target="#passwordModal" value="비밀번호찾기">
				자동로그인&nbsp;<input type="checkbox"  id="rememberMeFlag">
				</div>
				</div>
			</div>
		</div>
		<!-- 비밀번호 찾기 모달-->
		<div class="modal fade" id="passwordModal" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">비밀번호 찾기</h4>
					</div>

					<div class="modal-body">
						<p>아이디와 이메일을  입력해 주세요.</p>
						<div>
						<form id="findPasswordForm" action="findPasswordByNameAndEmail.do" method="post">
						<input type="text" name="id" id="name"  class="form-control" placeholder="ID" style="width: 30%; margin: 0 auto;" required="required" > 
						<input type="email" name="email" id="email" class="form-control" placeholder="EMAIL" style="width: 30%; margin: 0 auto;" required="required"> 
						<input type="button" class="btn  btn-success form-control" id="findPasswordBtn" style="width: 30%; margin: 0 auto;" data-dismiss="modal" value="확인">
						</form>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default"  data-dismiss="modal">취소</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!--/form-->
