<%@ include file="../includes/header.jsp"%>
<%
// Author - Shalin Banjara
// Usage - A page for client to add update and activate/deactivate official users
%>
<h1>
	Official Users
<span class ="pull-right">
  <a href="/Scheduler/department/new" class="btn btn-primary">Add Department</a>
 <button class="btn btn-primary" data-toggle="modal" data-target="#addOfficialUser">
  Add Official User
</button>
</span>
</h1>
<br>
<c:forEach items="${departments}" var="department">
	<c:if test = "${!empty department.officialUsers}">
	<div class="panel panel-primary">
	</c:if>
	<c:if test="${empty department.officialUsers}">
		<div class="panel panel-danger">
	</c:if>
	<div class ="panel-heading">
	     <b>${department.departmentName}</b>
	     <div class="pull-right silent">
	    <a href="/Scheduler/department/edit/${department.departmentId}" class="label label-warning">Update</a>
	    <a href="/Scheduler/department/delete/${department.departmentId}" class="label label-danger">Delete</a>
      </div>
	</div>
	<div class ="panel-body">
	<p><b>Department Description:</b></p>
		<div class ="panel-body"> 
			<p> ${department.departmentDescription}</p><br/>
			<c:forEach items="${department.slots}" var="slot">
			     <div class="row">
			        <b>${slot.workingDays}:- ${slot.startTime} - ${slot.stopTime} (${slot.capacity})</b>
  			   </div>
			</c:forEach>	
		</div>
	</div>
	<br>
	<table class = "table">
	<c:if test = "${!empty department.officialUsers}">
	<tr>
		<th>Id</th>
		<th>Role</th>
		<th>Official Name</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Email</th>
		<th>Date Joined</th>
		<th>Action</th>
	</tr>
	</c:if>
	<c:forEach items="${department.officialUsers}" var="user">
		<tr>
			<td>${user.officialId}</td>
			<td>${user.roleName}</td>
			<td>${user.officialName}</td>
			<td>${user.firstName}</td>
			<td>${user.lastName}</td>
			<td>${user.email}</td>
			<td>${user.dateJoined}</td>
			<td>
				<a href="../users/edit/${user.officialId}" class="label label-warning">Update</a> 
				<a href = "../users/delete/${user.officialId}" action="GET" class="label label-danger">Delete</a>
			</td>
		</tr>
	</c:forEach>
	</table>
</div>
</c:forEach>

<!-- Author - Shalin Banjara -->
<!-- Usage - Popup for sending a notification to a particular User -->
<div class="modal fade" id="addOfficialUser" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div id="addOfficialUserDiv">
		<form:form method="POST" action="../users/save" modelAttribute="officialUser">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h3 class="modal-title">Add a new Official User to the system</h3>
				</div>
				<div class="modal-body">
					<label>User Name:</label>
					<form:input type="text" path="officialName"/>
					<label>Password:</label>
					<form:input type="text" path="password"/>
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
					<form:input type="email" path="email"/>
					<label >Date Joined: </label>
					<form:input type="text" id="dateJoined"  required="required" readonly="readonly" path="dateJoined"/>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
					<input type="submit" value="Save" class="btn btn-primary" />
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</form:form>
	</div>

</div>

<%@ include file="../includes/footer.jsp"%>
<script src="/Scheduler/resources/js/calender.js"></script>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

