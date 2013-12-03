<%@ include file="../includes/header.jsp"%>
<%
	// Author - Shalin Banjara
	// Usage - A page for client to add update and activate/deactivate official users
%>
<div class="row">
	<div class="col-xs-12 col-md-8">
		<h3>Administrator FAQ Section</h3>
	</div>
	<div class="col-xs-6 col-md-4">
		<span class="pull-right">
			<div class="btn-group">
				<button class="btn btn-default" data-toggle="modal"
					data-target="#addCategory"><i class="glyphicon glyphicon-plus"></i> Add Category</button>
				<button class="btn btn-default" data-toggle="modal"
					data-target="#addFaq"><i class="glyphicon glyphicon-plus"></i> Add FAQ</button>
			</div>
		</span>
	</div>
</div>
<hr />
<c:if test="${!empty result}">
	<c:if test="${infotype == 'S'}">
		<div class="alert alert-success alert-dismissable">
			<button type="button" class="close" data-dismiss="alert"
				aria-hidden="true">&times;</button>
			${result}
		</div>
	</c:if>
	<c:if test="${infotype == 'F'}">
		<div class="alert alert-danger alert-dismissable">
			<button type="button" class="close" data-dismiss="alert"
				aria-hidden="true">&times;</button>
			${result}
		</div>
	</c:if>
</c:if>
<c:forEach items="${categories}" var="category">
	<c:if test="${!empty category.faqs}">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<b>${category.categoryName}</b>
				<div class="pull-right silent">
					<a href="/Scheduler/category/edit/${category.categoryId}"
						class="label label-warning">Update</a> <a
						href="/Scheduler/category/delete/${category.categoryId}"
						class="label label-danger">Delete</a>
				</div>
			</div>
			<div class="panel-body">
				<c:forEach items="${category.faqs}" var="faq">
					<div class="panel panel-success">
						<div class="panel-heading">
							<b>Question:- ${faq.faqQuestion}</b>
							<div class="pull-right silent">
								<a href="/Scheduler/faq/edit/${faq.faqId}"
									class="label label-warning">Update</a>
							</div>
							<div class="pull-right silent">
								<a href="/Scheduler/faq/delete/${faq.faqId}"
									class="label label-danger">Delete</a>
							</div>
						</div>
						<div class="panel-body">
							<table>
								<tr>
									<td>Answer:-</td>
									<td class="pull-left slient">${faq.faqAnswer}</td>
								</tr>
							</table>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</c:if>
	<c:if test="${empty category.faqs}">
		<div class="panel panel-danger">
			<div class="panel-heading">
				<b>${category.categoryName}</b>
				<div class="pull-right silent">
					<a href="/Scheduler/category/edit/${category.categoryId}"
						class="label label-warning">Update</a> <a
						href="/Scheduler/category/delete/${category.categoryId}"
						class="label label-danger">Delete</a>
				</div>
			</div>
			<div class="panel-body">Please delete this category as it is
				not being used.</div>
		</div>
	</c:if>
</c:forEach>

<div class="modal fade" id="addCategory" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h2>Add Faq</h2>
			</div>
			<form:form method="POST" action="save" modelAttribute="category">
				<div class="modal-body">
					<table rules="rows" cellpadding="10">
						<tr>
							<td><label>Category Name:- </label></td>
							<td><form:input required="required" path="categoryName" /></td>
						</tr>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
					<input type="submit" value="Save" class="btn btn-primary" />
				</div>
			</form:form>
		</div>
	</div>
</div>

<div class="modal fade" id="addFaq" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h2>Add Faq</h2>
			</div>
			<form:form method="POST" action="../faq/save" modelAttribute="faq">
				<div class="modal-body">
					<table rules="rows" cellpadding="10">
						<tr>
							<td><label>Category:- </label></td>
							<td><form:select path="categoryId">
									<c:forEach items="${categories}" var="category">
										<form:option value="${category.categoryId}">${category.categoryName}</form:option>
									</c:forEach>
								</form:select></td>
						</tr>
						<tr>
							<td><label>Question:- </label></td>
							<td><form:textarea cols="50" required="required"
									path="faqQuestion" /></td>
						</tr>
						<tr>
							<td><label>Answer:- </label></td>
							<td><form:textarea cols="50" required="required"
									path="faqAnswer" /></td>
						</tr>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
					<input type="submit" value="Save" class="btn btn-primary" />
				</div>
			</form:form>
		</div>
	</div>
</div>


<%@ include file="../includes/footer.jsp"%>