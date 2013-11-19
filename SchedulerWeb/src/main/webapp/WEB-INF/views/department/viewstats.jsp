<%@ include file="../includes/header.jsp"%>
<title>My Appointments</title>

<h3>Department Statistics</h3>
<c:if  test="${!empty departmentStatistics}">
<table class="table table-hover table-bordered">
<tr>
    <th>Department ID</th>
    <th>Department</th>
    <th>Finished Appointment</th>
    <th>Canceled Appointment</th>
    <th>Late Appointment</th>
    <th>Total Appointment</th>
</tr>
<c:forEach items="${departmentStatistics}" var="departmentStatistics">
    <tr>
        <td>${departmentStatistics.departmentId }</td>
        <td>${departmentStatistics.departmentName }</td>
        <td>${departmentStatistics.finishedAppointment }</td>
        <td>${departmentStatistics.canceledAppointment }</td>
        <td>${departmentStatistics.lateAppointment }</td>
        <td>${departmentStatistics.totalAppointment }</td>
    </tr>
</c:forEach>
</table>
</c:if>
<%@ include file="../includes/footer.jsp"%>