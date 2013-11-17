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
    <label for="inputName" class="col-sm-2 control-label">Select Timeslot</label>
    <div class="col-sm-5">
      <form:select class="form-control" path="timeslotId" id="timeslotId">
        <c:forEach items="${timeslots}" var="s">
         <option value="${s.timeslotId}"
			 <c:if test="${(s.timeslotId == slot.timeslotId)}">
			 	selected="selected"
			 </c:if>         
         >${s.startTime} - ${s.stopTime}</option>
        </c:forEach>
      </form:select>
    </div>
  </div>

  <div class="form-group">
    <label for="inputName" class="col-sm-2 control-label">Select Days</label>
    <div class="col-sm-5">
      <form:checkbox path="days" value="1"/>&nbsp;Monday<br/> 
      <form:checkbox path="days" value="2"/>&nbsp;Tuesday<br/>
      <form:checkbox path="days" value="3"/>&nbsp;Wednesday<br/>
      <form:checkbox path="days" value="4"/>&nbsp;Thursday<br/>
      <form:checkbox path="days" value="5"/>&nbsp;Friday<br/>
    </div>
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