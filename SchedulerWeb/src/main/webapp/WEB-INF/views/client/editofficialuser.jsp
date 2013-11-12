<%@ include file="../includes/header.jsp"%>
<%
// Author - Shalin Banjara
// Usage - A page for client to add update and activate/deactivate official users
%>
<form:form method="POST" action="../update" modelAttribute="officialUserEdit">
<h3> Edit a Official User </h3>
				<div class="modal-body">
				<form:input type="hidden" path="officialId" value = "${Id}"/>
					<label>User Name:</label>
					<form:input type="text" required="required" path="officialName"/>
					<label>Password:</label>
					<form:input type="text" required="required" path="password"/>
					<br><br>
					<label>Role:</label>
					<form:select name="role" class="abc" id="role" path ="roleId">
						<c:forEach items="${roles}" var="role">
							<form:option value ="${role.roleId}">${ role.roleName}</form:option>
						</c:forEach>
					</form:select>
					<label>Department:</label>
					<form:select name="department" class="abc" id="department" path="departmentId">
						<c:forEach items="${departments}" var="department">
							<form:option value ="${department.departmentId}">${ department.departmentName }</form:option>
						</c:forEach>
					</form:select>
					<br><br>
					<label>First Name:</label>
					<form:input type="text" required="required" path="firstName"/>
					<label>Last Name:</label>
					<form:input type="text" required="required" path="lastName"/>
					<br><br>
					<label>Email:</label>
					<form:input type="email" required="required" path="email"/>
					<label >Date Joined: </label>
					<form:input type="text" id="dateJoined"  required="required" readonly="readonly" path="dateJoined"/>
					<br><br>
					<a href = "../../../official/users/view" class="btn btn-primary">Cancel</a>
					<input type="submit" value="Update" class="btn btn-primary" />

	</form:form>
	
	<%@ include file="../includes/footer.jsp"%>
<script src="/Scheduler/resources/js/calender.js"></script>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>