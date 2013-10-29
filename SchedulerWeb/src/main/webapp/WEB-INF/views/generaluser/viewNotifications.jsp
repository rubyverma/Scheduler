<%@ include file="../includes/header.jsp"%>
<title>My Notifications</title>

<h3>My Notifications</h3>

<table class="table table-hover table-bordered">
	<tr>
		<th>Date</th>
		<th>Notification Title</th>
		<th>Notification Description</th>
	</tr>
	<c:forEach items="${notifications}" var="notification">
		<tr>
			<td>${notification.notificationDate }</td>
			<td>${notification.notificationHeader }</td>
			<td>${notification.notificationDescription  }</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="../includes/footer.jsp"%>