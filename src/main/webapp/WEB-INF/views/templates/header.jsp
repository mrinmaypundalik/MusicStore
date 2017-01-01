<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=chrome">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="Music Mania">
<meta name="author" content="Mrinmay Pundalik">
<!--  <link rel="icon" href="../../favicon.ico"> -->

<title>Music Mania</title>

<!--AngularJS-->
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>

<!--AngularJS Custom Script-->
<script src="<c:url value="/resources/js/controller.js"/>" /></script>

<!--jQuery-->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.1.4.min.js"></script>

<!--Data Table jQuery-->
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>

<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">

<!-- Custom Music Mania CSS -->
<link href="<c:url value="/resources/css/custom.css"/>" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<c:url value="/resources/css/carousel.css"/>"
	rel="stylesheet">

<!-- BootStrap -->
<script src="<c:url value="/resources/js/bootstrap.min.js"/>" /></script>

<!-- Data Table jQuery CSS -->
<link
	href="https://cdn.datatables.net/1.10.10/css/jquery.dataTables.min.css"
	rel="stylesheet">

</head>
<!-- NAVBAR
================================================== -->
<body>
	<div class="navbar-wrapper">
		<div class="container">

			<nav class="navbar navbar-inverse navbar-static-top">
			<div class="comtainer container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="<c:url value="/"/>">Music Mania</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li><a href="<c:url value="/product/productlist"/>">Products</a></li>
						<li><a href="<c:url value="/about"/>">About</a></li>
					</ul>
					<ul class="nav navbar-nav pull-right">
						<c:if test="${pageContext.request.userPrincipal.name !=null}">
							<li><a>Welcome ${pageContext.request.userPrincipal.name}</a></li>
							<li class="pull-right"><a
								href='<c:url value="/j_spring_security_logout"/>'>Logout</a></li>
						</c:if>
						<c:if
							test="${pageContext.request.userPrincipal.name!='admin' && pageContext.request.userPrincipal.name!=null}">
							<li class="pull-right"><a
								href='<c:url value="/customer/cart"/>'>Cart</a></li>
						</c:if>
						<c:if test="${pageContext.request.userPrincipal.name=='admin' }">
							<li><a href='<c:url value="/admin"/>'>Admin</a></li>
						</c:if>
						<c:if test="${pageContext.request.userPrincipal.name ==null}">
							<li><a href='<c:url value="/login"/>'>Login</a></li>
							<li><a href='<c:url value="/register"/>'>Register</a></li>
						</c:if>
					</ul>
				</div>
			</div>
			</nav>
		</div>
	</div>