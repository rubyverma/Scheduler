<%@ include file="../includes/header.jsp"%>
<%
// Author - Shalin Banjara
// Usage - A page for client to add update and activate/deactivate official users
%>
<h1 align="center">
Administrator FAQ Update Section
</h1>
<form:form method="POST" action="../update" modelAttribute="faq">
		<form:input type ="hidden" path="faqId" value="${faqId}"/>
					<table rules="rows" cellpadding="10">
					<tr>
						<td><label>Category:- </label></td>
						<td>
							<form:select path="categoryId">
							<c:forEach items="${categories}" var="category">
							<form:option value ="${category.categoryId}">${category.categoryName}</form:option>
							</c:forEach>
							</form:select>
						</td>
					</tr>
					<tr>
						<td><label>Question:- </label></td>
						<td><form:textarea cols="50" required="required" path="faqQuestion"/></td>
					</tr>
					<tr>
						<td><label>Answer:- </label></td>
						<td><form:textarea cols="50" required="required" path="faqAnswer"/></td>
					</tr>
					</table>
				<a href="../../category/view" class="btn btn-default">Cancel</a>
				<input type="submit" value="Save" class="btn btn-primary" />
			</form:form>

<%@ include file="../includes/footer.jsp"%>