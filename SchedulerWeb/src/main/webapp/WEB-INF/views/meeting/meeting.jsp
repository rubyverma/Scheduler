<%@ include file="../includes/header.jsp"%>
<c:if  test="${started == 'true'}">
    <div class="alert alert-success">Meeting Started on <b><%= new java.util.Date()%></b> ...</div>
</c:if>
<p>Student Name: hello <b>Sanket Patel</b></p>
<form:form action="finish" method="post" modelAttribute="appointment">
<table>
<tr>
	<td>Meeting Notes</td>
</tr>
<tr>
	<td><form:textarea class="form-control" id="meetingNotes" path="meetingNotes" rows="3"/></td>
</tr>
<tr>
	<td><input type="submit" class="btn btn-default">Finish</td>
</tr>
</table>
</form:form>
<%@ include file="../includes/footer.jsp" %>