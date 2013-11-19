<%@ include file="../includes/header.jsp"%>

<h3>Edit Password</h3>

<c:if test="${!empty message}">
   <div class="alert alert-info alert-dismissable">
   <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
   ${message}</div>
</c:if>

<div class="col-md-4">
	<form:form role="form" action="/Scheduler/official/savepassword"
		method="post" modelAttribute="officialUser">
		<form:hidden path="officialId" />
		<div class="form-group">
			<label for="password">New Password</label>
			<form:input type="password" class="form-control" id="password"
				path="password" required="required" placeholder="Enter new password"></form:input>
		</div>
		<div class="form-group">
			<label for="repassword">Confirm Password</label> 
			<form:input
				type="password" class="form-control" id="repassword"
				path="repassword" required="required" placeholder="Retype Password"></form:input>
		</div>
		<button type="submit" class="btn btn-primary">Change Password</button>
	</form:form>
</div>

<%@ include file="../includes/footer.jsp"%>