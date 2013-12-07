<%@ include file="../includes/header.jsp"%>
<title>My Appointments</title>

<h3>My Appointments</h3>
<c:if  test="${!empty appointments}">
<c:if test = "${!empty result}">
  	${result }
</c:if>

<table class="table table-hover table-bordered">
<tr>
    <th>Date</th>
    <th>Department</th>
    <th>Purpose of Visit</th>
    <th>Meeting Notes</th>
    <th>Meeting Finished</th>
    <th>Expected Meeting Time</th>
    <th>Actions</th>
</tr>
<c:forEach items="${appointments}" var="appointment">
    <tr>
        <td>${appointment.appointmentDate }</td>
        <td>${appointment.departmentName }</td>
        <td>${appointment.purposeOfVisit }</td>
         <td>
         <c:if test = "${appointment.meetingFinished.equals('Y')}">
  			 ${appointment.meetingNotes}
		</c:if>
          <c:if test = "${appointment.meetingNotes == null || appointment.meetingNotes.equals('')}">
  			none
		</c:if>
		</td>
       <td>
        <c:if test = "${appointment.meetingFinished.equals('Y')}">
  			<span class="label label-success">Yes</span>
		</c:if>
		<c:if test = "${appointment.meetingFinished.equals('N')}">
  			<span class="label label-danger">No</span>
		</c:if>
		<c:if test = "${appointment.meetingFinished.equals('C')}">
  			<span class="label label-default">Cancelled</span>
		</c:if>
		<c:if test = "${appointment.meetingFinished.equals('L')}">
  			<span class="label label-warning">Late</span>
		</c:if>
		</td>
		<td>${appointment.expectedTime}</td>
		<td>
		<c:if test = "${appointment.meetingFinished.equals('N')}">
  			<a href="cancel/${appointment.appointmentId }">cancel</a>
		</c:if>
		</td>
    </tr>
</c:forEach>
</table>
</c:if>
<%@ include file="../includes/footer.jsp"%>