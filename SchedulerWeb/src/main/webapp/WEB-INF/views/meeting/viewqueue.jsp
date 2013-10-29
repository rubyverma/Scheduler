<%@ include file="../includes/header.jsp"%>
<form:form action="../meeting/start" method="post" role="form">
	<h3>Lists of Appointment From Database</h3>
	<p><%=new java.util.Date()%></p>
	<c:if test="${!empty appointmentList}">
		<table class="table table-hover">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Purpose of Visit</th>
			</tr>
			<c:forEach items="${appointmentList}" var="listofAppointment">
				<tr>
					<td>${listofAppointment.appointmentId}</td>
					<td>${listofAppointment.firstName}${ listofAppointment.lastName}</td>
					<td>${listofAppointment.purposeOfVisit}</td>
				</tr>
			</c:forEach>
			
		</table>
		<div>
			<input type="submit" class="btn btn-default" value="Start Meeting"></input>
			</div>
	</c:if>
</form:form>


<%@ include file="../includes/footer.jsp"%>