<%@ include file="../includes/header.jsp"%>

<!-- Author - Ruby Verma
  Usage - UI for editing and updating general user details -->
<title>Change Password</title>
<h3>Change Password</h3>
<c:if test="${!empty updated}">
   <div class="alert alert-success alert-dismissable">
   <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
   <strong>Updated</strong> successfully.</div>
</c:if>


<c:if test="${!empty ue}">
   <div class="alert alert-danger alert-dismissable">
   <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
   <strong>Password does not match</strong></div>
</c:if>

<form:form class="form-horizontal" role="form" method="POST"
	action="/Scheduler/generaluser/savepassword" modelAttribute="generaluser">
	<form:hidden path="userId" />

	<div class="form-group">
		<label for="inputPassword" class="col-sm-2 control-label">New Password</label>
		<div class="col-sm-5">
			<form:input type="password" class="form-control" path="password" id="password"
			required="required"></form:input>
		</div>
	</div>

	<div class="form-group">
		<label for="inputRetypePassword" class="col-sm-2 control-label">Retype Password</label>
		<div class="col-sm-5">
			<form:input class="form-control" type="password" path="repassword" id="rePassword"
			 required="required"></form:input>
		</div>
	</div>

	<div style="text-align: center;">
		<a href="/Scheduler/generaluser/edit" class="btn btn-danger">Back</a> 
		<input type="submit"
			name="Save" value="Save" class="btn btn-success" />
	</div>

</form:form>



<%@ include file="../includes/footer.jsp"%>