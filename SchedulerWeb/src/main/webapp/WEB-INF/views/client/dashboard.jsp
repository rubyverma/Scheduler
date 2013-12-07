<%@ include file="../includes/header.jsp"%>
<p class="lead">Welcome ${user.name}</p>
<hr />
<div class="row">
	<div class="col-md-4">
		<div class="panel panel-info">
			<div class="panel-heading">Total Appointments</div>
			<div class="panel-body">
				<h3>${appointmentCount} Appointments</h3>
			</div>
		</div>
	</div>
	<div class="col-md-4">
		<div class="panel panel-info">
			<div class="panel-heading">Total Campuses</div>
			<div class="panel-body">
				<h3>${campusCount} Campuses</h3>
			</div>
		</div>
	</div>
	<div class="col-md-4">
		<div class="panel panel-info">
			<div class="panel-heading">Total Departments</div>
			<div class="panel-body">
				<h3>${departmentCount} Departments</h3>
			</div>
		</div>
	</div>
</div>
<h4>New to Scheduler?</h4>
<div class="panel panel-info">
	<div class="panel-body">Scheduler Application tries to overcome the existing scenario of scheduling appointments, 
by allocating tokens to users via internet and estimating the time of appointment. Alert will 
be given to the users android device, which will save time in waiting in front of the office to 
see the official. Also the app will provide necessary information about other services 
provided by the institution, which may keep the users from scheduling appointments at all.</div>
</div>
<h4>Know it more!</h4>
<div class="row">
	<div class="col-md-7">
		<div class="panel panel-info">
			<div class="panel-heading">Key Features</div>
			<div class="panel-body">
				<ul>
					<li>Able to Feature1</li>
					<li>Capable of Feature2</li>
					<li>Fully Feature3 enabled</li>
					<li>Try out new Feature4</li>

				</ul>
				<p>
					For more features or queries contact us at <a
						href="mailto:contact@schedulerapp.com">contact@schedulerapp.com</a>
				</p>
			</div>
		</div>
	</div>
	<div class="col-md-5">
		<div class="panel panel-info">
			<div class="panel-heading">Need Support?</div>
			<div class="panel-body">
				<p>Please contact our customer support center at +1 1800-XXX-XXXX or
				drop in an email at <a href="mailto:contact@schedulerapp.com">contact@schedulerapp.com</a>
				</p>
				<p>
					Please <a href="#">click here</a> to see the team behind <strong>Scheduler
						App</strong>
				</p>
			</div>
		</div>
	</div>
</div>
<%@ include file="../includes/footer.jsp"%>