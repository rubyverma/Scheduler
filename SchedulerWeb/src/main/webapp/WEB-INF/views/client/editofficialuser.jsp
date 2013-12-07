<%@ include file="../includes/header.jsp"%>
<%
// Author - Shalin Banjara
// Usage - A page for client to add update and activate/deactivate official users
%>
<form:form method="POST" action="../update" modelAttribute="officialUserEdit">
<h3> Edit a Official User </h3>
				<form:input type="hidden" path="officialId" value = "${Id}"/>
				<table>
					<tr>
					<td><label>User Name:</label></td>
					<td><form:input type="text" required="required" path="officialName"/></td>
					</tr>
					<tr>
					<td><label>Password:</label></td>
					<td><form:input type="password" required="required" path="password"/></td>
					</tr>
					<tr>
					<td><label>Role:</label></td>
					<td><form:select name="role" class="abc" id="role" path ="roleId">
						<c:forEach items="${roles}" var="role">
							<form:option value ="${role.roleId}">${ role.roleName}</form:option>
						</c:forEach>
					</form:select></td>
					</tr>
					<tr>
					<td><label>Department:</label></td>
					<td><form:select name="department" class="abc" id="department" path="departmentId">
						<c:forEach items="${departments}" var="department">
							<form:option value ="${department.departmentId}">${ department.departmentName }</form:option>
						</c:forEach>
					</form:select></td>
					</tr>
					<tr>
					<td><label>First Name:</label></td>
					<td><form:input type="text" required="required" path="firstName"/></td>
					</tr>
					<tr>
					<td><label>Last Name:</label></td>
					<td><form:input type="text" required="required" path="lastName"/></td>
					</tr>
					<tr>
					<td><label>Email:</label></td>
					<td><form:input type="email" required="required" path="email"/></td>
					</tr>
					<tr>
					<td><label >Date Joined: </label></td>
					<td><form:input type="text" id="dateJoined"  required="required" readonly="readonly" path="dateJoined"/></td>
					</tr>
					</table>
					<br />
					<c:choose>
						<c:when test="${user.role == 'CL'}">
							<a href = "../../../official/users/view" class="btn btn-default">Cancel</a>
						</c:when>
						<c:when test="${user.role == 'OU'}">
							<a href = "/Scheduler/official/dashboard" class="btn btn-default">Cancel</a>
						</c:when>
					</c:choose>&nbsp;
					<input type="submit" value="Update" class="btn btn-primary" />

	</form:form>
	
	<%@ include file="../includes/footer.jsp"%>
<script src="/Scheduler/resources/js/calender.js"></script>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>