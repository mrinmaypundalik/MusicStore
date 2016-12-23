<%@include file="/WEB-INF/views/templates/header.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>Cart</h1>

					<p>All the items in your shopping cart.</p>
				</div>
			</div>
		</section>
		<section class="container" ng-app="cartApp">
			<div ng-controller="cartController" ng-init="initCartId('${cartId}')">
				<div>
					<a class="btn btn-danger pull-left" href="#" ng-click="clearCart()"><span
						class="glyphicon glyphicon-remove-sign"></span>Clear Cart</a>
				</div>
				<table class="table table-hover">
					<tr>
						<th>Product</th>
						<th>Product Name</th>
						<th>Unit Price</th>
						<th>Quantity</th>
						<th>Total Price</th>
						<th>Action</th>
					</tr>
					<tr ng-repeat="item in cart.cartItems">
						<td><img
							src="<c:url value="/resources/images/{{item.product.productId}}.jpg"/>"
							alt="image" style="width: 100px; height: 100px" /></td>
						<td>{{item.product.productName}}</td>
						<td>{{item.product.productPrice}}</td>
						<td>{{item.quantity}}</td>
						<td>{{item.totalPrice}}</td>
						<td><a href="#" label="label label-danger"
							ng-click="removeFromCart(item.product.productId)"><span
								class="glyphicon glyphicon-remove"></span>Remove</a></td>
					</tr>
					<tr>
						<th></th>
						<th></th>
						<th></th>
						<th>Grand Total</th>
						<th>{{cart.grandTotal}}</th>
						<th></th>
					</tr>
				</table>
				<a class="btn btn-primary" href='<spring:url value="/"/>'>Continue
					Shopping</a>
			</div>
		</section>
	</div>
</div>

<%@include file="/WEB-INF/views/templates/footer.jsp"%>