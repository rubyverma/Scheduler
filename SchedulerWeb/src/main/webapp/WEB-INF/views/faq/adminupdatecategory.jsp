<%@ include file="../includes/header.jsp"%>
<%
// Author - Shalin Banjara
// Usage - A page for client to add update and activate/deactivate official users
%>
<h1 align="center">
Administrator FAQ Category Update Section
</h1>
<form:form method="POST" action="../update" modelAttribute="category">
<form:input type="hidden" path="categoryId" value = "${categoryId}"/>
					<table rules="rows" cellpadding="10">
					<tr>
						<td><label>Category Name:- </label></td>
						<td><form:input required="required" path="categoryName"/></td>
					</tr>
					</table>
				<a href="../view" class="btn btn-default">Cancel</a>
				<input type="submit" value="Save" class="btn btn-primary" />
			</form:form>

<%@ include file="../includes/footer.jsp"%>