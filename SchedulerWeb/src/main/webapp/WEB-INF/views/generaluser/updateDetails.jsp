<%@ include file="../includes/header.jsp"%>

<!-- Author - Ruby Verma
  Usage - UI for editing and updating general user details -->
<title>Edit Details</title>
<h3>Edit Details</h3>
<c:if test="${!empty updated}">
   <div class="alert alert-success alert-dismissable">
   <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
   <strong>Updated</strong> successfully.</div>
</c:if>


<form:form class="form-horizontal" role="form" method="POST"
	action="/Scheduler/generaluser/update" modelAttribute="generaluser">
	<form:hidden path="userId" />

	<div class="form-group">
		<label for="inputEmail" class="col-sm-2 control-label">Email</label>
		<div class="col-sm-5">
			<form:input type="email" class="form-control" path="email" id="email"
				placeholder="email" required="required"></form:input>
		</div>
	</div>

	<div class="form-group">
		<label for="inputUsername" class="col-sm-2 control-label">Username</label>
		<div class="col-sm-5">
			<form:input class="form-control" path="username" id="username"
				placeholder="Username" required="required"></form:input>
		</div>
	</div>

	<div class="form-group">
		<label for="inputFirstName" class="col-sm-2 control-label">First
			Name</label>
		<div class="col-sm-5">
			<form:input class="form-control" path="firstName" id="firstName"
				placeholder="First Name" required="required"></form:input>
		</div>
	</div>

	<div class="form-group">
		<label for="inputLastName" class="col-sm-2 control-label">Last
			Name</label>
		<div class="col-sm-5">
			<form:input class="form-control" path="lastName" id="lastName"
				placeholder="Last Name" required="required"></form:input>
		</div>
	</div>

	<div class="form-group">
		<label for="inputAddress" class="col-sm-2 control-label">Address</label>
		<div class="col-sm-5">
			<form:input class="form-control" path="address" id="address"
				placeholder="Address" required="required"></form:input>
		</div>
	</div>

	<div class="form-group">
		<label for="inputGender" class="col-sm-2 control-label">Gender</label>
		<div class="col-sm-5">
			<form:select class="form-control" path="gender" id="gender">
				<option value="Male" 
				<c:if test="${generaluser.gender.equals(\"Male\")}">
			 	selected="selected"
			 </c:if>>Male</option>
				<option value="Female"
				<c:if test="${generaluser.gender.equals(\"Female\")}">
			 	selected="selected"
			 </c:if>>Female</option>
			</form:select>
		</div>
	</div>

	<div class="form-group">
		<label for="inputDob" class="col-sm-2 control-label">Date of
			Birth</label>
		<div class="col-sm-5">
			<form:input type="date" class="form-control" path="dob" id="dob"
				placeholder="DOB" required="required"></form:input>
		</div>
	</div>

	<div style="text-align: center;">
		<a href="/Scheduler/generaluser/dashboard" class="btn btn-danger">Cancel</a>
		 <input type="submit" name="Save" value="Save" class="btn btn-success" />
	</div>

<div>
<a href="/Scheduler/generaluser/editpassword/${userId}">Change Password</a>
</div>

</form:form>



<%@ include file="../includes/footer.jsp"%>