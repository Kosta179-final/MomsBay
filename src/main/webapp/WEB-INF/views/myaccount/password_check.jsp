<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <div class="container">
      	<div class="col-sm-6 col-sm-offset-1">
      		<form action="findMemberByPasswordAndId.do" method="post">
      			<input type="hidden" name="id" value="${member.id}">
      			<h3><label>비밀번호를 입력해주세요</label></h3>
      			<input type="password" name="password"  required="required">
      			<input type="submit" value="확인" class="btn btn-success">
      		</form>
     </div>
</div>