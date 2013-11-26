<div id="left_sidebar">
	<div class="panel panel-default">
		<div class="panel-heading">
			Logged in as <strong>${user.name}</strong>
		</div>
		<div class="panel-body">
			<img src="/Scheduler/resources/images/profile.jpg"
				class="img-rounded" width="230" />
		</div>
	</div>

	<div class="list-group">
		<c:choose>
			<c:when test="${user.role == 'CL'}">
				<a href="#" class="list-group-item active">Client Dashboard</a>
				<a href="#" class="list-group-item">Messages</a>
				<a href="#" class="list-group-item">Todays List</a>
				<a href="#" class="list-group-item">Settings</a>
			</c:when>
			<c:when test="${user.role == 'OU'}">
				<a href="#" class="list-group-item active">Official Dashboard</a>
				<a href="#" class="list-group-item">Messages</a>
				<a href="#" class="list-group-item">Todays List</a>
				<a href="#" class="list-group-item">Settings</a>
			</c:when>
			<c:otherwise>
				<a href="#" class="list-group-item active">Student Dashboard</a>
				<a href="#" class="list-group-item">Messages</a>
				<a href="#" class="list-group-item">Todays List</a>
				<a href="#" class="list-group-item">Settings</a>
			</c:otherwise>
		</c:choose>



	</div>
</div>