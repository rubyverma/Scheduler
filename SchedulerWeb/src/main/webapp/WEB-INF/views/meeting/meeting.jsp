<%@ include file="../includes/header.jsp"%>
<c:if test="${started == 'true'}">
	<div class="alert alert-success">
		Meeting Started on <b><%=new java.util.Date()%></b> ...
	</div>
</c:if>
<c:if test="${!empty appointment}">
	<p>
	<div>
		Appointment Id: <b>${appointment.appointmentId}</b>
	</div>
	<div>
		Purpose of Visit: <b>${appointment.purposeOfVisit}</b>
	</div>
	</p>
</c:if>

<p>
	Student Name: hello <b>Sanket Patel</b>
</p>
<form:form action="../finish" method="post" role="form"
	modelAttribute="appointment">
	<input type="hidden" name="appointmentId" value="${appointment.appointmentId}" />
	<div class="form-group">
		<label>Meeting Notes</label>
		<div>
		<form:textarea class="form-control" id="meetingNotes"
			path="meetingNotes" rows="3" placeholder="Meeting Notes"></form:textarea>
			</div>
			<div>
			<input type="submit" class="btn btn-default" value="Finish"></input>
			</div>
	</div>
</form:form>
<%@ include file="../includes/footer.jsp"%>