<%@ include file="../includes/header.jsp"%>
<table class="table table-hover table-bordered">
<c:forEach items="${fQns}" var="fqns">
		<tr>
		   <td>Q. ${fqns.faqQuestion} </td>
		   </tr>
		   <tr>
		   <td>Ans. ${fqns.faqAnswer} </td>
		    </tr> 
	     </c:forEach>
	
</table>
<%@ include file="../includes/footer.jsp"%>