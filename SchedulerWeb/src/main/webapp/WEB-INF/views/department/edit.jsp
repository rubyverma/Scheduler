<%@ include file="../includes/header.jsp"%>

<title>Add Department</title>
<h3>Add Department</h3>

<form:form class="form-horizontal" role="form" method="POST"
  action="/Scheduler/department/save" modelAttribute="department">
  <form:hidden path="departmentId" />
  <form:hidden path="departmentTimeId" />
  
    
  <div class="form-group">
    <label for="inputName" class="col-sm-2 control-label">Select Campus</label>
    <div class="col-sm-5">
	    <form:select class="form-control" path="campusId" id="campusId">
			<c:forEach items="${campuses}" var="campus">
			 <option value="${campus.campusId}"
			 <c:if test="${(campus.campusId == department.campusId)}">
			 	selected="selected"
			 </c:if>			 
			 >${campus.campusName}
			 </option>
			</c:forEach>
		</form:select>
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputName" class="col-sm-2 control-label">Department Name</label>
    <div class="col-sm-5">
      <form:input class="form-control" path="departmentName" id="departmentName"
        placeholder="Name" required="required"></form:input>
    </div>
  </div>

  <div class="form-group">
    <label for="inputAddress" class="col-sm-2 control-label">Department Hod</label>
    <div class="col-sm-5">
      <form:input class="form-control" path="departmentHod"
        id="departmentHod" placeholder="HOD" required="required"></form:input>
    </div>
  </div>

  <div class="form-group">
    <label for="inputContact" class="col-sm-2 control-label">Contact
      Info</label>
    <div class="col-sm-5">
      <form:input class="form-control" path="contactInfo" id="contactInfo"
        placeholder="Contact" required="required"></form:input>
    </div>
  </div>

  <div class="form-group">
    <label for="inputDescription" class="col-sm-2 control-label">Description</label>
    <div class="col-sm-5">
      <form:input class="form-control" path="departmentDescription"
        id="departmentDescription" placeholder="Description"
        required="required"></form:input>
    </div>
  </div>

  <div class="form-group">
    <label for="inputName" class="col-sm-2 control-label">Select Days</label>
    <br/><br/>
		 <table class="table">
		    <tr>
		      <td>Slots/Days</td>
		      <td>Monday</td>
		      <td>Tuesday</td>
		      <td>Wednesday</td>
		      <td>Thursday</td>
		      <td>Friday</td>
		    <tr>
		    <c:forEach items="${timeslots}" var="s">
		      <tr>
		        <td>${s.startTime} - ${s.stopTime}</td>
		        <td><form:checkbox path="days" value="${s.timeslotId},1"/></td>
		        <td><form:checkbox path="days" value="${s.timeslotId},2"/></td>
		        <td><form:checkbox path="days" value="${s.timeslotId},3"/></td>
		        <td><form:checkbox path="days" value="${s.timeslotId},4"/></td>
		        <td><form:checkbox path="days" value="${s.timeslotId},5"/></td>
		      </tr>
		    </c:forEach>
		  </table>
  </div> 

  <div class="form-group">
    <label for="inputName" class="col-sm-2 control-label">Capacity</label>
    <div class="col-sm-5">
      <form:input class="form-control" path="capacity" id="capacity"
        placeholder="Name" required="required"></form:input>
    </div>
  </div>
    
   <div style="text-align: center;">
	   <a href="/Scheduler/official/users/view" class="btn btn-danger">Cancel</a>
       <input type="submit" name="Save" value="Save" class="btn btn-success"/>
	</div>
	
</form:form>
 	


<%@ include file="../includes/footer.jsp"%>
