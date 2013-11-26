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
					<li class="active"><a href="#">Sign In</a></li>
					<li><a href="client/register">Sign Up</a></li>
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
			<div>
				<div class="row">
					<div class="col-md-4">
						<div class="panel panel-info">
							<div class="panel-heading">I'm a client</div>
							<div class="panel-body">
								Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do
								eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
								enim ad minim veniam, quis nostrud exercitation ullamco laboris
								nisi ut aliquip ex ea commodo consequat. 
								<br/><br/>
								<a href="client/login"
									class="btn btn-primary">Login as a Client</a>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="panel panel-info">
							<div class="panel-heading">I'm an official user</div>
							<div class="panel-body">
								Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do
								eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
								enim ad minim veniam, quis nostrud exercitation ullamco laboris
								nisi ut aliquip ex ea commodo consequat. 
								<br/><br/>
								<a href="official/login" class="btn btn-primary">Login as a Official User</a>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="panel panel-info">
							<div class="panel-heading">I'm a student</div>
							<div class="panel-body">
								Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do
								eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
								enim ad minim veniam, quis nostrud exercitation ullamco laboris
								nisi ut aliquip ex ea commodo consequat. 
								<br/><br/>
								<a href="generaluser/login" class="btn btn-primary">Login as a Student</a>
							</div>
						</div>
					</div>
				</div> </div>
				<h4>New to Scheduler?</h4>
<div class="panel panel-info">
	<div class="panel-body">Lorem ipsum dolor sit amet, consectetur
		adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore
		magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation
		ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute
		irure dolor in reprehenderit in voluptate velit esse cillum dolore eu
		fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident,
		sunt in culpa qui officia deserunt mollit anim id est laborum</div>
</div>
<h4>Know it more!</h4>
<div class="row">
	<div class="col-md-7">
		<div class="panel panel-info">
			<div class="panel-heading">Key Features</div>
			<div class="panel-body">
				<ul>
					<li>Able to Feature1</li>
					<li>Capable of Feature2</li>

				</ul>
				<p>
					For more features or queries contact us at <a
						href="mailto:contact@schedulerapp.com">contact@schedulerapp.com</a>
				</p>
			</div>
		</div>
	</div>
	<div class="col-md-5">
		<div class="panel panel-info">
			<div class="panel-heading">Need Support?</div>
			<div class="panel-body">
				<p>Please contact our customer support center at +1 1800-XXX-XXXX or
				drop in an email at <a href="mailto:contact@schedulerapp.com">contact@schedulerapp.com</a>
				</p>
				<p>
					Please <a href="#">click here</a> to see the team behind <strong>Scheduler
						App</strong>
				</p>
			</div>
		</div>
	
</div>
<%@ include file="../includes/footer.jsp"%>