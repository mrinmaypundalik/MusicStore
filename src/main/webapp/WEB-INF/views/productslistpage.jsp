<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/templates/header.jsp"%>

<script>
	$(document).ready(function() {
		var searchCondition = '${searchCondition}';
		$('.table').DataTable({
			"lengthMenu" : [ [ 5, 10, 15, -1 ], [ 5, 10, 15, "All" ] ],
			"oSearch" : {
				"sSearch" : searchCondition
			}
		});
	});
</script>
<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>All Products</h1>

			<p class="lead">Checkout all the awesome products available now!</p>
		</div>

		<c:set var="isLoggedIn" value="${false}" />
		<c:if test="${loggedin}">
			<c:set var="App" value="cartApp" />
			<c:set var="Cont" value="cartController" />
			<c:set var="Init" value="initCartId('${cartId}')" />
			<c:set var="isLoggedIn" value="${true}" />
		</c:if>
		<div ng-app="${App}">
			<div ng-controller="${Cont}" ng-init="${Init}">
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
							</a>&nbsp &nbsp<a ng-if="${isLoggedIn}" href="#"
								ng-click="addProduct('${product.productId}')"><span
									class="glyphicon glyphicon-shopping-cart"></span></a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/views/templates/footer.jsp"%>