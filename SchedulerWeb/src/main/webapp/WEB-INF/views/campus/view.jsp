<%@ include file="../includes/header.jsp"%>

<!-- Author - Ruby Verma
	Usage - UI for editing and viewing all campus -->
<title>Campus</title>

<h3 class="pull-left silent">Campus</h3>
<button class="btn btn-default pull-right"
	data-toggle="modal" data-target="#myModal">
	<span class="glyphicon glyphicon-plus"></span> Add New Campus
</button>
<br>
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">Add Campus</h4>
			</div>
			<div class="modal-body">

				<form class="form-horizontal" role="form" method="POST"
					action="save" modelAttribute="campus">
					<div class="form-group">
						<label for="inputName" class="col-sm-2 control-label">Name</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" path="campusName"
								id="campusName" placeholder="Enter Campus" required="required" />

						</div>
					</div>
					<div class="form-group">
						<label for="inputAddress" class="col-sm-2 control-label">Address</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" path="campusAddress"
								id="campusAddress" placeholder="Enter Address"
								required="required" />
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<input type="button" class="btn btn-primary" id="btnSave"
							value="Save" />
					</div>
				</form>
			</div>
		</div>


		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>


<c:if test="${!empty campuses}">
	<c:if test="${!empty result}">
  	${result }
</c:if>

<br>
<br>
 
	<%
		//String exist = request.getParameter("deleted");
		//if (exist != null && exist.equals("1")) {
			//out.write("<div class=\"alert alert-warning alert-dismissable\"><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button><strong>Campus deleted</strong> successfully.</div>");

//		}
	%>


	<table class="table table-hover table-bordered">
		<tr>
			<th>Name</th>
			<th>Address</th>
			<th>Action</th>

		</tr>
		<c:forEach items="${campuses}" var="campus">
			<tr>
				<td>${campus.campusName}</td>
				<td>${campus.campusAddress}</td>
				<td><a href="edit/${campus.campusId}">edit</a> <a
					href="delete/${campus.campusId}">delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>

<%@ include file="../includes/footer.jsp"%>