<%@ include file="../includes/header.jsp"%>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css" />
<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>
<h1>Register New User</h1>
</br>
<form:form class="form-horizontal" role="form" method="POST"
	action="save" modelAttribute="generaluser">

	<div class="form-group">
		<label for="firstName" class="col-sm-2 control-label">First
			Name</label>
		<div class="col-sm-5">
			<form:input path="firstName" class="form-control" required="required" />
		</div>
	</div>
	<div class="form-group">
		<label for="lastName" class="col-sm-2 control-label">Last Name</label>
		<div class="col-sm-5">
			<form:input path="lastName" class="form-control" required="required" />
		</div>
	</div>
	<div class="form-group">
		<label for="username" class="col-sm-2 control-label">User Name</label>
		<div class="col-sm-5">
			<form:input path="username" class="form-control" required="required" />
		</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">Password</label>
		<div class="col-sm-5">
			<form:input path="password" type="password" class="form-control"
				required="required" />
		</div>
	</div>
	<div class="form-group">
		<label for="email" class="col-sm-2 control-label">Email</label>
		<div class="col-sm-5">
			<form:input path="email" type="email" class="form-control"
				required="required" />
		</div>
	</div>
	<div class="form-group">
		<label for="address" class="col-sm-2 control-label">Address</label>
		<div class="col-sm-5">
			<form:input path="address" class="form-control" required="required" />
		</div>
	</div>
	<div class="form-group">
		<label for="dob" class="col-sm-2 control-label">DOB</label>
		<div class="col-sm-5">
			<form:input type="date" class="form-control" id="datepicker"
				path="dob" value="1986-12-12" required="required"
				readonly="readonly" />
		</div>
	</div>
	
	<div class="form-group">
		<label for="gender" class="col-sm-2 control-label">Gender</label>
		<div class="col-sm-5">
			<input type="radio" path="gender" value="Male"/>&nbsp Male 
			<input type="radio" path="gender" value="Female"/>&nbsp Female
		</div>
	</div>
	<div class="form-group">
		<label for="clientId" class="col-sm-2 control-label">Client</label>
		<div class="col-sm-5">
			<select name="clientId" id="clientCombo" class="form-control" >
					<c:forEach items="${client}" var="client">
						<option value="${client.clientId}">${client.clientName}</option>
					</c:forEach>
			</select>
		</div>
	</div>
	<div class="form-group">
	<label for="dob" class="col-sm-2 control-label"></label>
	<div class="col-sm-5">
			<input type="submit" value="Submit"	class="btn btn-primary" />
			</div>
	</div>
</form:form>
<a href="/Scheduler/client/register">Signup as a Client</a>
<%@ include file="../includes/footer.jsp"%>