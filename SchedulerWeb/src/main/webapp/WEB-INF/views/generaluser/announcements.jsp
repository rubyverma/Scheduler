<%@ include file="../includes/header.jsp"%>
<title>Announcements</title>

<h3>Announcements</h3>

<c:if test="${!empty announcements}">
	<c:if test="${!empty result}">
  	${result }
</c:if>
	<table class="table table-hover table-bordered">
		<tr>
			<th>Date</th>
			<th>Title</th>
			<th>Descriprion</th>
		</tr>

		<c:forEach items="${announcements}" var="announcement">
			<tr>
				<td>${announcement.announcementDate }</td>
				<td>${announcement.announcementHeader }</td>
				<td>${announcement.announcementDescription }</td>
			</tr>
		</c:forEach>
	</table>
</c:if>

<%@ include file="../includes/footer.jsp"%>