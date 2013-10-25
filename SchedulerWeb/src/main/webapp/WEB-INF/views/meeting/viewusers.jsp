<%@ include file="../includes/header.jsp"%>
Status: ${ result }

<h3>Official Users From Database ${ started }</h3>
<c:if  test="${!empty users}">
<table class="table table-hover">
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Email</th>
    <th>&nbsp;</th>
</tr>
<c:forEach items="${users}" var="user">
    <tr>
        <td>${user.id}</td>
        <td>${user.firstname} ${ user.lastname }</td>
        <td>${user.email}</td>
        <td><a href="delete/${user.id}">delete</a></td>
    </tr>
</c:forEach>
</table>
</c:if>
<%@ include file="../includes/footer.jsp"%>