<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">

<title>Signin to SchedulerApp</title>

<!-- Bootstrap core CSS -->
<link href="/Scheduler/resources/css/bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="signin.css" rel="stylesheet">
</head>

<body>

	<div class="container">
		<div class="row col-md-4">
			<br />
			<p>
			<h2>Please Sign In</h2>
			</p>

			<form role="form" name="f"
				action="<c:url value='j_spring_security_check'/>" method="post">
				<div class="form-group">
					<label for="useremail">Email address</label> <input type="email"
						class="form-control" name="j_username" required autofocus
						placeholder="Enter email">
				</div>
				<div class="form-group">
					<label for="password">Password</label> <input type="password"
						class="form-control" name="j_password" required
						placeholder="Password">
				</div>
				<button type="submit" class="btn btn-primary">Sign In</button>
			</form>
		</div>
	</div>
	<!-- /container -->

</body>
</html>
