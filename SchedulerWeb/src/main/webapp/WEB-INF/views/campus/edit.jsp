<%@ include file="../includes/header.jsp"%>

<!-- Author - Ruby Verma
	Usage - UI for editing and updating a campus -->
<title>Edit Campus</title>
<h3>Edit Campus</h3>
<c:if test="${!empty exists}">
   ${exists}
</c:if>
<form:form class="form-horizontal" role="form" method="POST"
	action="/Scheduler/campus/update" modelAttribute="campus">
	<form:hidden path="campusId" />
	<div class="form-group">
		<label for="inputName" class="col-sm-2 control-label">Name</label>
		<div class="col-sm-5">
			<form:input class="form-control" path="campusName" id="campusName"
				placeholder="Enter Campus" required="required"></form:input>
		</div>
	</div>

	<div class="form-group">
		<label for="inputAddress" class="col-sm-2 control-label">Address</label>
		<div class="col-sm-5">
			<form:input class="form-control" path="campusAddress"
				id="campusAddress" placeholder="Enter Address" required="required"></form:input>
		</div>
	</div>
	<div style="text-align: center;">
		<a href="/Scheduler/campus/view" class="btn btn-default">Close</a> <input
			type="submit" class="btn btn-primary" value="Save" />
	</div>

<br>
	<div class="form-group">
		<%
			String exist = request.getParameter("exists");
				if (exist != null && exist.equals("1")) {
					out.write("<div class=\"alert alert-danger col-sm-7\">Campus already exists!</div>");
				}
		%>
	</div>
</form:form>



<%@ include file="../includes/footer.jsp"%>