<%@ include file="../includes/header.jsp"%>

<!-- Author - Ruby Verma
	Usage - UI for editing and updating a campus -->
<title>Edit Role</title>
<h3>Edit Role</h3>
<form:form class="form-horizontal" role="form" method="POST" action="../update" modelAttribute="role">
<form:input type="hidden" path="roleId" value="${Id}"/>
					<div class="form-group">
						<label for="inputName" class="col-sm-2 control-label">Role Name:</label>
						<div class="col-sm-10">
							<form:input class="form-control" path="roleName"
								id="roleName" placeholder="Enter Role" required="required"></form:input>
					</div>
					</div>
					<div class="form-group">
						<label for="inputPrivilege" class="col-sm-2 control-label">Privilege</label>
						<div class="col-sm-10">
							<form:input class="form-control" path="privilege"
								id="privilege" placeholder="Enter privilege" required="required"></form:input>
						</div>
					</div>
					<div class="form-group">
						<label for="inputdescription" class="col-sm-2 control-label">Description:</label>
						<div class="col-sm-10">
							<form:input class="form-control" path="description"
								id="description" placeholder="Enter privilege" required="required"></form:input>
						</div>
					</div>
			        <div class="modal-footer">
				       <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				       <input type="submit" class="btn btn-primary" value="Save" />
		 	        </div>
		       </form:form>

<%@ include file="../includes/footer.jsp"%>