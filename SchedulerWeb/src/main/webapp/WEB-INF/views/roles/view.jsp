<%@ include file="../includes/header.jsp"%>

<!-- Author - Ruby Verma
	Usage - UI for editing and viewing all campus -->
<title>Roles</title>

<h3 class="pull-left silent">Roles</h3>
<button class="btn btn-primary pull-right btn-sm silent"
	data-toggle="modal" data-target="#addRoles">
	Add <span class="glyphicon glyphicon-plus"></span>
</button>
<br>
<!-- Modal -->
<div class="modal fade" id="addRoles" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">Add Role</h4>
			</div>
			<div class="modal-body">

				<form:form class="form-horizontal" role="form" method="POST" action="save" modelAttribute="newRole">
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
		</div>
		</div>


		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<c:if test="${!empty roles}">
	<c:if test="${!empty result}">
  	${result }
</c:if>

	<table class="table table-hover table-bordered">
		<tr>
			<th>Role Name</th>
			<th>Privilege</th>
			<th>Description</th>
			<th>Actions</th>
		</tr>
		<c:forEach items="${roles}" var="role">
			<tr>
				<td>${role.roleName}</td>
				<td>${role.privilege}</td>
				<td>${role.description}</td>
				<td><a href="edit/${role.roleId}">edit</a> | <a href="delete/${role.roleId}">delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</c:if>
<%@ include file="../includes/footer.jsp"%>