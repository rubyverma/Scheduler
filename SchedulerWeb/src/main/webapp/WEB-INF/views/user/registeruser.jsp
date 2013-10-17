<%@ include file="../includes/header.jsp"%>
<h1>
	Register New User
</h1>

<form:form method="POST" action="save" modelAttribute="user">
   <table>
    <tr>
        <td><form:label path="firstname">First Name</form:label></td>
        <td><form:input path="firstname" /></td>
    </tr>
    <tr>
        <td><form:label path="lastname">Last Name</form:label></td>
        <td><form:input path="lastname" /></td>
    </tr>
    <tr>
        <td><form:label path="email">Email</form:label></td>
        <td><form:input path="email" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit" class="btn btn-primary" />
        </td>
    </tr>
</table>  
</form:form>

<%@ include file="../includes/footer.jsp"%>