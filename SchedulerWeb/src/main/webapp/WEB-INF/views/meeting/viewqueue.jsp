<%@ include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-xs-12 col-md-8">
		<h3>Today's Scheduled Appointments</h3>
	</div>
	<div class="col-xs-6 col-md-4">
		<span class="pull-right"> 
		<c:if test="${!empty appointmentList}">
				<a data-toggle="modal" href="#myModal" class="btn btn-primary">Broadcast
					Message</a>
			</c:if>
		</span>

	</div>
</div>
<form:form action="/Scheduler/official/meeting/start" method="post"
	role="form">
	<h3>Lists of Appointment From Database</h3>
	<p><%=new java.util.Date()%></p>

	<c:if test="${!empty appointmentList}">
		<table class="table table-hover">
			<tr>
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Purpose of Visit</th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${appointmentList}" var="listofAppointment">
				<tr>
					<td>${listofAppointment.appointmentId}</td>
					<td>${listofAppointment.firstName}</td>
					<td>${listofAppointment.lastName}</td>
					<td>${listofAppointment.purposeOfVisit}</td>
					<td>
						<div class="col-xs-6 col-md-4">
							<span class="pull-right"> <a data-toggle="modal"
								href="#notificationModal" class="btn btn-info"
								onclick="sendNotification(${listofAppointment.userId},'${listofAppointment.firstName}','${listofAppointment.lastName}')">Send
									Notification</a>
							</span>
						</div>
					</td>
				</tr>
			</c:forEach>

		</table>
		<div>
			<input type="submit" class="btn btn-default" value="Start Meeting"></input>
		</div>
	</c:if>
</form:form>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<form:form method="POST" action="/Scheduler/official/meeting/broadcast"
		modelAttribute="announcement">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h3 class="modal-title">Broadcast Message</h3>
				</div>
				<div class="modal-body">
					<i>This message will be send to all students in the current
						queue</i>
					<p>
					<div class="form-group">
						<label for="broadcastMessage">Message Title</label>
						<form:input class="form-control" path="announcementHeader"
							id="broadcastMessageHeader" placeholder="Enter Title"
							required="required" />
					</div>
					<div class="form-group">
						<label for="broadcastMessage">Message Body</label>
						<form:textarea class="form-control" id="broadcastMessageDesc"
							path="announcementDescription" rows="3" required="required"
							placeholder="Enter a message to broadcast..."></form:textarea>
					</div>
					</p>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
					<input type="submit" value="Broadcast Message"
						class="btn btn-primary" />
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</form:form>
</div>
<!-- /.modal -->
<!-- Author - Shalin Banjara -->
<!-- Usage - Popup for sending a notification to a particular User -->
<div class="modal fade" id="notificationModal" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div id="notificationPopupDiv">
		<!--  this is where the ajax notification popup is loaded  -->
	</div>
</div>

<%@ include file="../includes/footer.jsp"%>
<script src="/Scheduler/resources/js/notification.js"></script>