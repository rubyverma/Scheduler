
<%@ include file="../includes/header.jsp"%>
<h1>Change Password</h1>
<form:form method="POST" action="../updatepassword"  modelAttribute="client" onsubmit="return validatepassword()">
	<input type="hidden"  id="setpassword" value = "${password}"/>
	<form:input type="hidden" path="clientId" value = "${clientId}"/>
   <table>
    <tr>
        <td><label>Current Password</label></td>
        <td><input type = "password" id = "currentPassword" required="required"/></td>
    </tr>
    <tr>
        <td><label>New Password</label></td>
        <td><input type = "password" id = "newPassword" required="required"/></td>
    </tr>
    <tr>
        <td><form:label path="password">Confirm New Password</form:label></td>
        <td><form:input id = "confirmPassword" path="password" required="required" type="password"/></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"  class="btn btn-primary" />
        </td>
    </tr>
</table>  
</form:form>

<%@ include file="../includes/footer.jsp"%>
<script src="/Scheduler/resources/js/passwordvalidation.js"></script>