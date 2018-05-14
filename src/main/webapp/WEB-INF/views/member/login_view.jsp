<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
$(document).ready(function(){
	$("#register").click(function(){
		location.href="${pageContext.request.contextPath}/home.do"
	});
});
</script>
<section id="form">
	<!--form-->
	<div class="container">
		<div class="row">
			<div class="col-sm-3 col-sm-offset-4">
				<div class="login-form">
					<!--login form-->
					<h2>로그인</h2>
					<form action="${pageContext.request.contextPath}/member/login.do" id="login_form" method="post">
						<input type="text" placeholder="id" name="id" required="required"/>
						<input type="password" placeholder="password" name="password" required="required"/>
						<Button type="submit" value="로그인" id="login" style="width: 100%">로그인</Button>
						<Button type="button"  value="회원가입" id="register" style="width: 100%; background-color: #FE980F;">회원가입</Button>
					</form>
				</div>
				<!--/login form-->
			</div>
		</div>
	</div>
</section>
<!--/form-->
