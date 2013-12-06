<%@ include file="../includes/header.jsp"%>
<h1>
	Register New Client
</h1>

<form:form method="POST" action="save" modelAttribute="client">
   <table>
    <tr>
        <td><form:label path="clientName">Full Name</form:label></td>
        <td><form:input path="clientName" required="required"/></td>
    </tr>
    <tr>
        <td><form:label path="userName">User Name</form:label></td>
        <td><form:input path="userName" required="required"/></td>
    </tr>
    <tr>
        <td><form:label path="password">Password</form:label></td>
        <td><form:input path="password" type="password" required="required"/></td>
    </tr>
    <tr>
        <td><form:label path="email">Email</form:label></td>
        <td><form:input path="email" required="required" type="email"/></td>
    </tr>
    <tr>
        <td><form:label path="address">Address</form:label></td>
        <td><form:input path="address" required="required"/></td>
    </tr>
    <tr>
        <td><form:label path="memo">Memo</form:label></td>
        <td><form:input path="memo" /></td>
    </tr>
    <tr>
        <td><form:label path="phone1">Phone 1</form:label></td>
        <td><form:input path="phone1" type="tel" required="required"/></td>
    </tr>
    <tr>
        <td><form:label path="phone2">Phone 2</form:label></td>
        <td><form:input path="phone2" /></td>
    </tr>
    <tr>
        <td><form:label path="phone3">Phone 3</form:label></td>
        <td><form:input path="phone3" /></td>
    </tr>
    <tr>
        <td><form:label path="contactPerson">Contact Person</form:label></td>
        <td><form:input path="contactPerson" required="required" /></td>
    </tr>
    <tr>
        <td><form:label path="website">Web site</form:label></td>
        <td><form:input path="website" type="url"/></td>
    </tr>
    <tr>
    <td><form:label path="logo">Logo</form:label></td>
    <td><form:input type="file" path="logo"/></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit" class="btn btn-primary" />
        </td>
    </tr>
</table>  
</form:form>
<a href="/Scheduler/generaluser/register">Signup as a Student</a>
<%@ include file="../includes/footer.jsp"%>