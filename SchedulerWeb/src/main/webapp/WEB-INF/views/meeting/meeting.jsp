<%@ include file="../includes/header.jsp"%>
<c:if  test="${started == 'true'}">
	<div class="alert alert-success">Meeting Started on <b><%= new java.util.Date()%></b> ...</div>
</c:if>
<c:if  test="${!empty appointment}">
	<p>
		<div>Appointment Id: <b>${appointment.appointmentId}</b></div>
		<div>Purpose of Visit: <b>${appointment.purposeOfVisit}</b></div>
	</p>
</c:if>

<p>Student Name: hello <b>Sanket Patel</b></p>
<form:form action="../finish" method="post" role="form" modelAttribute="appointment">
<table>
<tr>
	<td>Meeting Notes</td>
</tr>
<tr>
	<td><form:textarea class="form-control" id="meetingNotes" path="meetingNotes" rows="3"/></td>
</tr>
<tr>
	<td><input type="submit" class="btn btn-default" value="Finish"></td>
</tr>
</table>
</form:form>
<%@ include file="../includes/footer.jsp" %>