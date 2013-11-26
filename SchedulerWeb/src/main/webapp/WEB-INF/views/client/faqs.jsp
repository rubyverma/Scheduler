<%@ include file="../includes/header.jsp"%>
Frequently Asked Questions and Answers Categories
<br>
<br>
<table class="table table-hover table-bordered">
<c:forEach items="${categories}" var="category">
		<tr>
		    
			<td><a href = "/client/viewfaqs/{categoryId}">${category}</a></td>
	
		</tr>
	</c:forEach>
</table>
<%@ include file="../includes/footer.jsp"%>