<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="<spring:url value="css/app.css" />" rel="stylesheet"
	type="text/css">
<title>registration</title>
</head>
<body class="security-app">	
	<div class="lc-block">
		<h1>Welcome Registration page !>>>>>>>>>>>></h1>
		<h1>Logged In user : ${LoggedInUser}</h1>
		<h1>Roles are : ${Roles}</h1>		
	</div>
</body>
</html>
