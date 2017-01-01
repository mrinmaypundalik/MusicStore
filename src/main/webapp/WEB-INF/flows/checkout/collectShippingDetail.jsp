<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/templates/header.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Customer</h1>

			<p class="lead">Customer details</p>
		</div>

		<div class="container">
			<form:form commandName="order" class="form-horizontal">

				<br>
				<h3>Shipping Address Info:</h3>
				<br>
				<div class="form-group">
					<label for="shippingAddressStreet">Street Address</label>
					<form:input path="cart.customer.shippingAddress.streetAddress"
						id="shippingAddressStreet" class="form-control" />
				</div>
				<div class="form-group">
					<label for="shippingAddressCity">City</label>
					<form:input path="cart.customer.shippingAddress.city"
						id="shippingAddressCity" class="form-control" />
				</div>
				<div class="form-group">
					<label for="shippingAddressState">State</label>
					<form:input path="cart.customer.shippingAddress.state"
						id="shippingAddressState" class="form-control" />
				</div>
				<div class="form-group">
					<label for="shippingAddressCountry">Country</label>
					<form:input path="cart.customer.shippingAddress.country"
						id="shippingAddressCountry" class="form-control" />
				</div>
				<div class="form-group">
					<label for="shippingAddressZipcode">Zipcode</label>
					<form:input path="cart.customer.shippingAddress.zipcode"
						id="shippingAddressZipcode" class="form-control" />
				</div>

				<input type="hidden" name="_flowExecutionKey" />
				<br>
				<button name="_eventId_backToCollectCustomerInfo"
					class="btn btn-default">Back</button>|
				<input type="submit" value="Next" class="btn btn-primary"
					name="_eventId_shippingDetailsCollected" />| 
				<button name="_eventId_cancel" class="btn btn-danger">Cancel</button>
			</form:form>
		</div>
	</div>
</div>

<%@include file="/WEB-INF/views/templates/footer.jsp"%>