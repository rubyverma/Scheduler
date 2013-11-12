<%@ include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-xs-12 col-md-8">
		<h3>Timeslots</h3>
	</div>
	<div class="col-xs-6 col-md-4">
		<span class="pull-right"> <a data-toggle="modal"
			href="#myModal" class="">Add New Timeslot</a>
		</span>
	</div>
</div>
<c:if test="${!empty result}">
	<div class="alert alert-info alert-dismissable">
		<button type="button" class="close" data-dismiss="alert"
			aria-hidden="true">&times;</button>
		${result}
	</div>
</c:if>
<c:if test="${!empty timeslots}">
	<table class="table table-hover">
		<tr>
			<th>ID</th>
			<th>Description</th>
			<th>Start Time</th>
			<th>End Time</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${timeslots}" var="timeslot">
			<tr>
				<td>${timeslot.timeslotId}</td>
				<td>${timeslot.description}</td>
				<td>${timeslot.startTime}</td>
				<td>${timeslot.stopTime}</td>
				<td><a
					href="${pageContext.request.contextPath}/timeslot/edit/${timeslot.timeslotId }"
					id="editTimeslot">edit</a> 
					<a href="${pageContext.request.contextPath}/timeslot/delete/${timeslot.timeslotId }">delete</a>
				</td>
			</tr>
		</c:forEach>

	</table>
</c:if>


<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<form method="POST"
		action="${pageContext.request.contextPath}/timeslot/save">
		<input type="hidden" name="timeslotId" value="" />
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h3 class="modal-title">Add New Timeslot</h3>
				</div>
				<div class="modal-body">
					<i>The timeslot can be accessed and used by departments</i>
					<p>
					<div class="form-group">
						<label>Starting Time</label> <input class="form-control"
							name="startTime" placeholder="Starting Time" type="time"
							required="required" />
					</div>
					<div class="form-group">
						<label>Ending Time</label> <input class="form-control"
							name="stopTime" rows="3" required="required" type="time"
							placeholder="Ending time" />
					</div>
					<div class="form-group">
						<label>Description</label> <input class="form-control"
							name="description" rows="3" required="required"
							placeholder="Description" />
					</div>
					</p>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
					<input type="submit" value="Save Timeslot" class="btn btn-primary" />
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</form>
</div>

<%@ include file="../includes/footer.jsp"%>