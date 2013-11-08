<%@ include file="../includes/header.jsp"%>
<form:form method="POST" action="submit" modelAttribute="client">
   <table>
    <tr>
        <td><form:label path="userName">User Name</form:label></td>
        <td><form:input path="userName" name="userName" required="required"/></td>
    </tr>
    <tr>
        <td><form:label path="password">Password</form:label></td>
        <td><form:input path="password" type="password" name="password" required="required"/></td>
    </tr>
    </table>
    </form:form>
    
<%@ include file="../includes/footer.jsp"%>