<%@ include file="../includes/header.jsp"%>
<h1>Update Client Details</h1>

<form:form method="POST" action="/Scheduler/client/update" modelAttribute="client" class="form-horizontal" role="form">
	<form:input type = "hidden" path="clientId"/>
   <table>
    <tr>
        <td><form:label path="clientName">Full Name</form:label></td>
        <td><form:input path="clientName" required="required" class="form-control"/></td>
    </tr>
    <tr>
        <td><form:label path="userName">User Name</form:label></td>
        <td><form:input path="userName" required="required" class="form-control"/></td>
    </tr>
    <tr>
        <td><form:label path="email">Email</form:label></td>
        <td><form:input path="email" required="required" type="email" class="form-control"/></td>
    </tr>
    <tr>
        <td><form:label path="address">Address</form:label></td>
        <td><form:input path="address" required="required" class="form-control"/></td>
    </tr>
    <tr>
        <td><form:label path="memo">Memo</form:label></td>
        <td><form:input path="memo" class="form-control"/></td>
    </tr>
    <tr>
        <td><form:label path="phone1">Phone 1</form:label></td>
        <td><form:input path="phone1" type="tel" required="required" class="form-control"/></td>
    </tr>
    <tr>
        <td><form:label path="phone2">Phone 2</form:label></td>
        <td><form:input path="phone2" class="form-control" /></td>
    </tr>
    <tr>
        <td><form:label path="phone3">Phone 3</form:label></td>
        <td><form:input path="phone3" class="form-control" /></td>
    </tr>
    <tr>
        <td><form:label path="contactPerson">Contact Person</form:label></td>
        <td><form:input path="contactPerson" required="required" class="form-control" /></td>
    </tr>
    <tr>
        <td><form:label path="website">Web site</form:label></td>
        <td><form:input path="website" type="url" class="form-control" /></td>
    </tr>
    <tr>
    <td>
    	<form:input type= "hidden" path="logo"/>
    </td>
    <td></td>
    </tr>
    <tr>
        <td>
            
        </td>
         <td>
            <input type="submit" value="Update Profile" class="btn btn-primary" />
        </td>
    </tr>
</table>  
</form:form>

<%@ include file="../includes/footer.jsp"%>