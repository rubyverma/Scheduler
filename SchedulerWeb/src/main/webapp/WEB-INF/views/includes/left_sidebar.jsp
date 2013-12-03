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
				<a href="/Scheduler/client/dashboard" class="list-group-item active">Dashboard</a>
				<a href="/Scheduler/client/viewstats" class="list-group-item">View Statistics</a>
				<a href="/Scheduler/campus/view" class="list-group-item">View Campuses</a>
				<a href="/Scheduler/official/users/view" class="list-group-item">View Department and Officials</a>
				<a href="/Scheduler/department/new" class="list-group-item">Create Department</a>
				<a href="/Scheduler/roles/view" class="list-group-item">View Roles</a>
				<a href="/Scheduler/timeslot/view" class="list-group-item">View Timeslots</a>
				<a href="/Scheduler/client/edit" class="list-group-item">Edit Profile</a>
			</c:when>
			<c:when test="${user.role == 'OU'}">
				<a href="/Scheduler/official/dashboard" class="list-group-item active">Dashboard</a>
				<a href="/Scheduler/official/meeting/viewqueue" class="list-group-item">View Queue</a>
				<a href="/Scheduler/category/view" class="list-group-item">Create Category and FAQ</a>
				<a href="/Scheduler/category/view" class="list-group-item">View FAQ</a>
				<a href="/Scheduler/official/users/edit/${user.id}" class="list-group-item">Edit Profile</a>
				<a href="/Scheduler/official/editpassword/${user.id}" class="list-group-item">Change Password</a>
			</c:when>
			<c:otherwise>
				<a href="/Scheduler/generaluser/dashboard" class="list-group-item active">Dashboard</a>
				<a href="/Scheduler/appointment/new" class="list-group-item">Create new appointment</a>
				<a href="/Scheduler/appointment/view" class="list-group-item">View Appointments</a>
				<a href="/Scheduler/generaluser/announcements" class="list-group-item">Announcements</a>
				<a href="/Scheduler/generaluser/notifications" class="list-group-item">Notifications</a>
				<a href="/Scheduler/generaluser/edit" class="list-group-item">Edit Profile</a>
				<a href="/Scheduler/generaluser/editpassword/${user.id}" class="list-group-item">Change Password</a>
			</c:otherwise>
		</c:choose>



	</div>
</div>