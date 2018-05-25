<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- tiles framework 선언부 -->
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

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

	<div class="container text-center">
		<div class="row content">
			<div id="main">
				<div class="col-sm-3">
					<tiles:insertAttribute name="left" />
					<!-- Tiles header 영역 -->
				</div>
				<div class="col-sm-9 padding-right">
					<tiles:insertAttribute name="main" />
					<!-- Tiles header 영역 -->
				</div>
			</div>
		</div>
	</div>

	<div id="footer">
		<tiles:insertAttribute name="footer"/>
		<!-- Tiles footer 영역 -->
	</div>
	
</body>
</html>
