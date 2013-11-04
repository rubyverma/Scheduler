<%@ include file="../includes/header.jsp"%>
<%
// Author - Shalin Banjara
// Usage - A page for general user to book a appointment
%>
<h1>
	Book New Appointment
</h1>
		<div>
		<label >Appointment Date : </label>
		<input type="text" id="datepicker"  required="required" readonly="readonly"/>
		</div>
		<br>
		<div>
		<label>Campus : </label>
			<select name="Campus" id="campusCombo">
					<option>Select a campus</option>
				<c:forEach items="${campuses}" var="campus">
					<option value="${campus.campusId}">${campus.campusName}</option>
				</c:forEach>
			</select>
	</div>
	<br>
	<div id="departmentComboDiv">
		<!--  this is where the ajax departmentCombo combobox is loaded  -->
	</div>
	<br>
	<div>
		<div id="timeslotComboDiv">
		<!--  this is where the ajax departmentCombo combobox is loaded  -->
	</div>
	<div>
	<span class="pull-right">
	<input type="button" name="Cancel" value="Cancel" class="btn btn-danger" onclick="location.reload()"/>
	</span>
	</div>
	</div>

<%@ include file="../includes/footer.jsp"%>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script src="/Scheduler/resources/js/datetimepicker.js"></script>