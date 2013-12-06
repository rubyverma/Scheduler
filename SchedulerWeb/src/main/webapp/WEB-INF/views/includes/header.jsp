<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="../../assets/ico/favicon.png">

<title>Scheduler Web Application</title>

<!-- Bootstrap core CSS -->
<link href="/Scheduler/resources/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="/Scheduler/resources/css/bootstrap-theme.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/Scheduler/resources/css/theme.css" rel="stylesheet">
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<link rel="stylesheet" href="/resources/demos/style.css" />

</head>

<body>

	<!-- Fixed navbar -->
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/Scheduler">Scheduler</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<c:choose>
						<c:when test="${user.role == 'CL'}">
							<li class="active"><a href="/Scheduler/client/dashboard">Home</a></li>
						</c:when>
						<c:when test="${user.role == 'OU'}">
							<li class="active"><a href="/Scheduler/official/dashboard">Home</a></li>
						</c:when>
						<c:when test="${user.role == 'GU'}">
							<li class="active"><a href="/Scheduler/generaluser/dashboard">Home</a></li>
						</c:when>
						<c:when test="${user.role != ''}">
							<li class="active"><a href="/Scheduler/">Home</a></li>
						</c:when>
						<c:otherwise>
							<li class="active"><a href="/Scheduler/login">Home</a></li>
						</c:otherwise>
					</c:choose>

					<li><a href="#about">About</a></li>
					<li><a href="#contact">Contact</a></li>
					<c:if test="${!empty user.id}">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">${user.name} <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li class="dropdown-header">Your Account</li>
							<li><a href="#">My Profile</a></li>
							<li><a href="#">Account Settings</a></li>
							<li><a href="#">Something else here</a></li>
							<li class="divider"></li>
							<li><a href="/Scheduler/logout">Logout</a></li>
						</ul></li>
						</c:if>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>

	<div class="container theme-showcase">
		<c:if test="${!empty error}">
			<p>
			<h4>The following error occured:</h4> 
				${ error }
			</p>
		</c:if>
		<div class="row">
			<div class="col-md-3">
				<!--  TODO: show only if user is logged in -->
				<c:if test="${!empty user.id}">
					<%@ include file="left_sidebar.jsp"%>
				</c:if>
			</div>
			<div class="col-md-9">