<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- tiles framework 선언부 -->
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    
	<title>
		<tiles:insertAttribute name="title" ignore="true"/>
	</title>
	
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	
	
</head>

<body>
	<div id="header">
		<tiles:insertAttribute name="header"/>
		<!-- Tiles header 영역 -->
	</div>

	<div class="container-fluid text-center">
		<div class="row content">
			<div id="main">
				<tiles:insertAttribute name="main"/>
				<!-- Tiles main 영역 -->
			</div>
		</div>
	</div>

	<div id="footer">
		<tiles:insertAttribute name="footer"/>
		<!-- Tiles footer 영역 -->
	</div>
	
</body>
</html>
