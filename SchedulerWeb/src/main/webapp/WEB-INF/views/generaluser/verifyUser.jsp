<%@ include file="../includes/header.jsp"%>
    
    <c:choose>
    <c:when test='${result=="Thank you for verifying the email address" }'>
	<div class="alert alert-success">${result}</div>
	<p>Please go back to home page to <a href = "/Scheduler/login">login</a> using your user id and password</p>
	</c:when>
	<c:otherwise><div class="alert alert-danger">${result}</div>
	</c:otherwise>
	</c:choose>
<%@ include file="../includes/footer.jsp"%>
