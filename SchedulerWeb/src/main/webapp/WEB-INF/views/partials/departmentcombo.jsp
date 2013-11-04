<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--Author - Shalin Banjara --%>
<%--Usage - A combo box with a list of departments for a selected campus --%>
<label>Department : </label>
<select name="departmentComboBox" class="abc" id="departmentCombo" onchange="onNickNameChange()">
	<option>Select a department</option>
	<c:forEach items="${departments}" var="department">
		<option value ="${department.departmentId}">${ department.departmentName }</option>
	</c:forEach>
</select>