<%@ include file="../includes/header.jsp"%>
<h1>
	Book New Appointment
</h1>
<form:form method="POST" action="save" modelAttribute="appointment">
	<div id="date">
		<form:label path="appointmentDate">Appointment Date : </form:label>
		<form:input path="appointmentDate" type="date" id="appDate" />
	</div>
	<div id="campuses">
	<lablel>Campus : <lablel>
			<select name="Campus" id="campusCombo">
					<option>Select a campus</option>
				<c:forEach items="${campuses}" var="campus">
					<option value="${campus.campusId}">${campus.campusName}</option>
				</c:forEach>
			</select>
	</div>
	<div id="departmentComboDiv">
		<!--  this is where the ajax departmentCombo combobox is loaded  -->
	</div>
	
		<div id="timeslotComboDiv">
		<!--  this is where the ajax departmentCombo combobox is loaded  -->
	</div>

</form:form>

<%@ include file="../includes/footer.jsp"%>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script src="/Scheduler/resources/js/datetimepicker.js"></script>