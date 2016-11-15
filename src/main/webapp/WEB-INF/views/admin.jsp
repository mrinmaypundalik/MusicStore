<%@include file="/WEB-INF/views/templates/header.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Admin Page</h1>

			<p class="lead">This is the admin page</p>
		</div>
		<a href="<spring:url value="/admin/productInventory"/>"
			class="btn btn-primary">Products Inventory</a>
</div>
</div>

<%@include file="/WEB-INF/views/templates/footer.jsp"%>