<%@ include file="../includes/header.jsp"%>
<form:form>
	<h3>Lists of Appointment From Database</h3>
	<c:if test="${!empty appointmentList}">
		<table class="table table-hover">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Purpose of Visit</th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${appointmentList}" var="listofAppointment">
				<tr>
					<td>${listofAppointment.appointmentId}</td>
					<td>${listofAppointment.firstName}${ listofAppointment.lastName}</td>
					<td>${listofAppointment.purposeOfVisit}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</form:form>


<%@ include file="../includes/footer.jsp"%>