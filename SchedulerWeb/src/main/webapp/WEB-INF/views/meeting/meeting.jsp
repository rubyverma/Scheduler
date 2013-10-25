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

<%@ include file="../includes/footer.jsp"%>