<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<label>Department : </label>
<select name="departmentComboBox" class="abc" id="departmentCombo" onchange="onNickNameChange()">
	<option>Select a department</option>
	<c:forEach items="${departments}" var="department">
		<option value ="${department.departmentId}">${ department.departmentName }</option>
	</c:forEach>
</select>