<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%--Author - Shalin Banjara --%>
<%--Usage - A combo box with a list of available timeslots for a selected department --%>
<form:form method="POST" action="save" modelAttribute="appointment"  onsubmit="return validate()">
<label> Timeslot :</label>
<form:select name="departmentTimeId" path = "departmentTimeId" id ="departmentTimeId">
	<form:option value="-1">Select any available timeslot</form:option>
	<c:forEach items="${availableTimeslots}" var="departmentTimeslotLinkage">
		<form:option value ="${departmentTimeslotLinkage.departmentTimeId}">${departmentTimeslotLinkage.departmentTimeId} - ${ departmentTimeslotLinkage.startTime } - ${ departmentTimeslotLinkage.stopTime }</form:option>	
		<c:set var="date" value="${departmentTimeslotLinkage.appointmentDate}"/>
	</c:forEach>
</form:select>
<br>
<br>
<div>
<label>Purpose of Meeting : </label>
<form:input type="text" id="purposeOfVisit"
							path="purposeOfVisit" required="required"
							placeholder="Purpose for meeting"/>
</div>
<form:input type="hidden" name="appointmentDate"	path="appointmentDate" value="${date}" />
<span class="pull-right">
	<input type="submit" value="Submit" class="btn btn-success"/>
	</span>
	</form:form>
<span ></span>