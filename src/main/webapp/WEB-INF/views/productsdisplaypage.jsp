<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/templates/header.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Product Detail</h1>

			<p class="lead">Here is the detail information of the product!</p>
		</div>

		<div class="container" ng-app="cartApp">
			<div class="row">
				<div class="col-md-5">
					<img
						<%-- src="<c:url value="/resources/images/${product.productId}.jpg"/>" --%> src="${product.productImageUrl}"
						alt="image" style="width: 100%; height: 100%; text-align: center" />
				</div>

				<div class="col-md-5">
					<h3>${product.productName}</h3>
					<p>${product.productDescription}</p>
					<p>
						<strong>Manufacturer</strong> : ${product.productManufacturer}
					</p>
					<p>
						<strong>Category</strong> : ${product.productCategory}
					</p>
					<p>
						<strong>Condition</strong> : ${product.productCondition}
					</p>
					<h4>${product.productPrice}USD</h4>
					<br>
					<c:set var="role" scope="page" value="${param.role}"></c:set>
					<c:set var="url" scope="page" value="/product/productlist"></c:set>
					<c:if test="${role='admin' }">
						<c:set var="url" scope="page"
							value="/admin/product/productInventory"></c:set>
					</c:if>

					<p ng-controller="cartController">
						<a class="btn btn-warning btn-large" href="#"
							ng-click="addProduct('${product.productId}')"><span
							class="glyphicon glyphicon-shopping-cart"></span>Add to Cart</a> <a
							class="btn btn-default" href="<c:url value="${url}"/>">Back</a> <a
							href="<c:url value="/customer/cart"/>" class="btn btn-default"><span
							class="glyphicon glyphicon-hand-right"></span>View Cart</a>
					</p>

				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/views/templates/footer.jsp"%>