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

				<h3>Basic Info:</h3>
				<br>
				<div class="form-group">
					<label for="firstName">First Name</label>
					<form:input path="cart.customer.customerFirstName" id="firstName"
						class="form-control" />
				</div>
				<div class="form-group">
					<label for="LastName">Last Name</label>
					<form:input path="cart.customer.customerLastName" id="LastName"
						class="form-control" />
				</div>
				<div class="form-group">
					<label for="email">Email</label>
					<form:input path="cart.customer.customerEmail" id="email" class="form-control" />
				</div>
				<div class="form-group">
					<label for="phone">Phone Number</label>
					<form:input path="cart.customer.customerContact" id="phone"
						class="form-control" />
				</div>
				<br>
				<h3>Billing Address Info:</h3>
				<br>
				<div class="form-group">
					<label for="billingAddressStreet">Street Address</label>
					<form:input path="cart.customer.billingAddress.streetAddress"
						id="billingAddressStreet" class="form-control" />
				</div>
				<div class="form-group">
					<label for="billingAddressCity">City</label>
					<form:input path="cart.customer.billingAddress.city"
						id="billingAddressCity" class="form-control" />
				</div>
				<div class="form-group">
					<label for="billingAddressState">State</label>
					<form:input path="cart.customer.billingAddress.state"
						id="billingAddressState" class="form-control" />
				</div>
				<div class="form-group">
					<label for="billingAddressCountry">Country</label>
					<form:input path="cart.customer.billingAddress.country"
						id="billingAddressCountry" class="form-control" />
				</div>
				<div class="form-group">
					<label for="billingAddressZipcode">Zipcode</label>
					<form:input path="cart.customer.billingAddress.zipcode"
						id="billingAddressZipcode" class="form-control" />
				</div>

				<input type="hidden" name="_flowExecutionKey" />
				<br>
				<input type="submit" value="Next" class="btn btn-primary"
					name="_eventId_customerInfoCollected" />| 
				<button name="_eventId_cancel" class="btn btn-danger">Cancel</button>
			</form:form>
		</div>
	</div>
</div>

<%@include file="/WEB-INF/views/templates/footer.jsp"%>