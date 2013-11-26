<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link href="/Scheduler/resources/css/bootstrap.css" rel="stylesheet">
</head>
<body>
	<br />
	<div class="container">
		<div class="alert alert-danger">
			<h1 id="banner">Unauthorized Access!</h1>
			<c:if test="${not empty error}">
				<div style="color: red">
					You dont have permission to view this content<br />
				</div>
			</c:if>
			<br />
			<p><a href="/Scheduler/login">Go back</a></p>
		</div>
	</div>
</body>
</html>