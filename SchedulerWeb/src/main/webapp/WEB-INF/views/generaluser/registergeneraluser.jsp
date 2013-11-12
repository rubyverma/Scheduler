<%@ include file="../includes/header.jsp"%>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
 <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css" />
<script>
$(function() {
$( "#datepicker" ).datepicker();
});
</script>
<h1>
	Register New User
</h1>

<form:form method="POST" action="save" modelAttribute="generaluser">
   <table>
    <tr>
        <td><form:label path="firstName">First Name</form:label></td>
        <td><form:input path="firstName" required="required"/></td>
    </tr>
    <tr>
        <td><form:label path="lastName">Last Name</form:label></td>
        <td><form:input path="lastName" required="required"/></td>
    </tr>
    <tr>
        <td><form:label path="username">User Name</form:label></td>
        <td><form:input path="username" required="required"/></td>
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
        <td><form:label path="dob">DOB</form:label></td>
        <td><form:input type="text" id="datepicker" path="dob" value="1986-12-12" required="required" readonly="readonly"/></td>
        
    </tr>
    <tr>
        <td><form:label path="gender">Gender</form:label></td>
        <td><form:radiobutton name="sex"  path="gender" value="Male"/>Male
        <form:radiobutton name="sex"  path="gender" value="Female"/>Female</td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit" class="btn btn-primary" />
        </td>
    </tr>
</table>  
</form:form>

<%@ include file="../includes/footer.jsp"%>