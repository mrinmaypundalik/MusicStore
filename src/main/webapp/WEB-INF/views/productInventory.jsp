<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/templates/header.jsp"%>

<script>
	$(document).ready(function() {
		$('.table').DataTable({
			"lengthMenu" : [ [ 5, 10, 15, -1 ], [ 5, 10, 15, "All" ] ]
		});
	});
</script>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Products Inventory</h1>

			<p class="lead">Change your Inventory</p>
		</div>

		<table class="table table-striped table-hover">
			<thead class="thead-inverse">
				<tr>
					<th></th>
					<th>Product Name</th>
					<th>Category</th>
					<th>Condition</th>
					<th>Price</th>
					<th>Info</th>
				</tr>
			</thead>
			<c:forEach items="${products}" var="product">
				<tr>
					<td><img
						<%-- src="<c:url value="/resources/images/${product.productId}.jpg"/>" --%> src="${product.productImageUrl}"
						alt="image" style="width: 100px; height: 100px" /></td>
					<td>${product.productName}</td>
					<td>${product.productCategory}</td>
					<td>${product.productCondition}</td>
					<td>${product.productPrice}USD</td>
					<td><a
						href="<spring:url value="/product/viewProduct/${product.productId}"/>">
							<span class="glyphicon glyphicon-info-sign"></span>
					</a> <a
						href="<spring:url value="/admin/product/editProduct/${product.productId}"/>">
							<span class="glyphicon glyphicon-pencil"></span>
					</a> <a
						href="<spring:url value="/admin/product/deleteProduct/${product.productId}"/>">
							<span class="glyphicon glyphicon-trash"></span>
					</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href='<spring:url value="/admin/product/addProduct"/>'
			class="btn btn-primary">Add Product</a>
	</div>
</div>

<%@include file="/WEB-INF/views/templates/footer.jsp"%>