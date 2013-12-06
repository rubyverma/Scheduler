<%@page import="com.scheduler.models.Timeslot"%>
<%@page import="java.util.List"%>
<%@page import="com.scheduler.models.Department"%>
<%@ include file="../includes/header.jsp"%>

<!-- Author - Ruby Verma
	Usage - UI for editing and updating a department -->

<title>Add Department</title>
<h3>Add Department</h3>

<form:form class="form-horizontal" role="form" method="POST"
  action="/Scheduler/department/save" modelAttribute="department">
  <form:hidden path="departmentId" />
 
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
      <form:input maxlength="10" class="form-control" path="contactInfo" id="contactInfo"
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
		    <%
		      List<Timeslot> timeslots = (List<Timeslot>) request.getAttribute("timeslots");
		      Department d = (Department) request.getAttribute("department");
		      for (int index = 0; index < timeslots.size(); index++) {
			    	Timeslot sl = timeslots.get(index);
		 	    	out.print("<tr><td>");
		 	    	out.print(sl.getStartTime());
		 	    	out.print(" - ");
		 	    	out.print(sl.getStopTime());
		 	    	out.print("</td>");
		 	    	
		 	    	String key = sl.getTimeslotId() + ",1";
		 	    	String value = "0";
		 	    	if(d.getSlotsMap().containsKey(key)) {
		 	    		value = d.getSlotsMap().get(key);
		 	    	}
		 	    	out.print("<td>");
		 	    	out.print("<input type=\"number\" min=\"0\" class=\"form-control input-sm\" name='"+key+"' value='"+value+"' />");
		 	    	out.print("</td>");

            key = sl.getTimeslotId() + ",2";
            value = "0";
            if(d.getSlotsMap().containsKey(key)) {
              value = d.getSlotsMap().get(key);
            }
            out.print("<td>");
            out.print("<input type=\"number\" min=\"0\" class=\"form-control input-sm\" name='"+key+"' value='"+value+"' />");
            out.print("</td>");

            key = sl.getTimeslotId() + ",3";
            value = "0";
            if(d.getSlotsMap().containsKey(key)) {
              value = d.getSlotsMap().get(key);
            }
            out.print("<td>");
            out.print("<input type=\"number\" min=\"0\" class=\"form-control input-sm\" name='"+key+"' value='"+value+"' />");
            out.print("</td>");
            
            key = sl.getTimeslotId() + ",4";
            value = "0";
            if(d.getSlotsMap().containsKey(key)) {
              value = d.getSlotsMap().get(key);
            }
            out.print("<td>");
            out.print("<input type=\"number\" min=\"0\" class=\"form-control input-sm\" name='"+key+"' value='"+value+"' />");
            out.print("</td>");
            
            key = sl.getTimeslotId() + ",5";
            value = "0";
            if(d.getSlotsMap().containsKey(key)) {
              value = d.getSlotsMap().get(key);
            }
            out.print("<td>");
            out.print("<input type=\"number\" min=\"0\" class=\"form-control input-sm\" name='"+key+"' value='"+value+"' />");
            out.print("</td></tr>");
		      }
		     %>
		  </table>
  </div> 

   <div style="text-align: center;">
	   <a href="/Scheduler/official/users/view" class="btn btn-danger">Cancel</a>
       <input type="submit" name="Save" value="Save" class="btn btn-success"/>
	</div>
	
</form:form>
 	


<%@ include file="../includes/footer.jsp"%>

