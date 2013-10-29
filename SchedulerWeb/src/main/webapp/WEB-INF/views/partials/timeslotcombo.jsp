<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form:label>Timeslot : </form:label>
<select name="timeSlotComboBox" class="abc" id="timeslotCombo">
	<option>Select any available timeslot</option>
	<c:forEach items="${availableTimeslots}" var="departmentTimeslotLinkage">
		<option value ="${departmentTimeslotLinkage.departmentTimeId}">${ departmentTimeslotLinkage.startTime } - ${ departmentTimeslotLinkage.stopTime }</option>
	</c:forEach>
</select>