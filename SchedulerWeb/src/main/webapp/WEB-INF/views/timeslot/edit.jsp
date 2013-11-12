<%@ include file="../includes/header.jsp"%>
<h3>Edit Timeslot</h3>
<hr />
<div>

<form class="col-sm-5" method="POST" action="${pageContext.request.contextPath}/timeslot/update">
	<p>
	<input type="hidden" name="timeslotId" value="${timeslot.timeslotId}" />
	<div class="form-group">
		<label>Starting Time</label> <input class="form-control"
			name="startTime" placeholder="Starting Time" type="time"
			required="required" value="${timeslot.startTime}" />
	</div>
	<div class="form-group">
		<label>Ending Time</label> <input class="form-control" name="stopTime"
			required="required" type="time" placeholder="Ending time" value="${timeslot.stopTime}" />
	</div>
	<div class="form-group">
		<label>Description</label> <input class="form-control"
			name="description" required="required"
			placeholder="Description" value="${timeslot.description}" />
	</div>


	<a href="../view" class="btn btn-default">Cancel</a>
	<input type="submit" value="Update Timeslot" class="btn btn-primary" />
	</p>
</form>
</div>
<%@ include file="../includes/footer.jsp"%>