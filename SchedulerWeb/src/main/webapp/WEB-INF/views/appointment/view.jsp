<%@ include file="../includes/header.jsp"%>
Status: ${ result }

<h3>Appointments From Database</h3>
<c:if  test="${!empty appointments}">
<table class="table table-hover">
<tr>
    <th>ID</th>
    <th>Start Time</th>
    <th>End Time</th>
    <th>Meeting Notes</th>
    <th>&nbsp;</th>
</tr>
<c:forEach items="${appointments}" var="appointment">
    <tr>
        <td>${appointment.appointmentId}</td>
        <td>${appointment.startTime}</td>
        <td>${appointment.endTime}</td>
        <td>${appointment.meetingNotes}</td>
    </tr>
</c:forEach>
</table>
</c:if>
<%@ include file="../includes/footer.jsp"%>