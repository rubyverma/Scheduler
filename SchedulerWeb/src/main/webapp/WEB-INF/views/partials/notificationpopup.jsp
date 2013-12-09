<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%--Author - Shalin Banjara --%>
<%--Usage - A popup for offical user to send a notification to a particular user in the appointment queue --%>
<form:form method="POST" action="${pageContext.request.contextPath}/generaluser/send/notification/" modelAttribute="notification">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h3 class="modal-title">Send Notification Message</h3>
				</div>
				<div class="modal-body">
					<i>This message will be sent to a ${firstName} ${lastName}.</i>
					<p>
					<div class="form-group">
						<label for="broadcastMessage">Message Title</label>
						<form:input class="form-control" path="notificationHeader"
							id="notificationHeader" placeholder="Enter Title" required="required" />
					</div>
					<div class="form-group">
						<label for="notificationDescription">Message Body</label>
						<form:textarea class="form-control" id="notificationDescription"
							path="notificationDescription" rows="3" required="required"
							placeholder="Enter a message to notify..."></form:textarea>
					</div>

				</div>
				<form:input type="hidden" name="userId"	path="userId" value="${userId}" />
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
					<input type="submit" value="Send Notification" class="btn btn-primary" />
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</form:form>