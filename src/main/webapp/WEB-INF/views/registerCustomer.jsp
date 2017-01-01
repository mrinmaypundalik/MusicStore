<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/templates/header.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Customer Registration</h1>

			<p class="lead">Enter your details</p>
		</div>

		<div class="container">
			<form:form action="${pageContext.request.contextPath}/register"
				method="POST" commandName="customer">

				<h3>Basic Info:</h3>
				<span class="errorMessage" style="color: red">${customerExists}</span>
				<br>
				<div class="form-group">
					<label for="firstName">First Name </label>
					<form:errors path="customerFirstName" class="errorMessage"
						style="color: red" />
					<form:input path="customerFirstName" id="firstName"
						class="form-control" />
				</div>
				<div class="form-group">
					<label for="LastName">Last Name </label>
					<form:errors path="customerLastName" class="errorMessage"
						style="color: red" />
					<form:input path="customerLastName" id="LastName"
						class="form-control" />
				</div>
				<label for="username">Username </label>
				<form:errors path="username" class="errorMessage" style="color: red" />
				<div class="form-group">
					<form:input path="username" id="username" class="form-control" />
				</div>
				<label for="password">Password </label>
				<form:errors path="password" class="errorMessage" style="color: red" />
				<div class="form-group">
					<form:password path="password" id="pasword" class="form-control" />
				</div>
				<div class="form-group">
					<label for="email">Email </label>
					<form:errors path="customerEmail" class="errorMessage"
						style="color: red" />
					<form:input path="customerEmail" id="email" class="form-control" />
				</div>
				<div class="form-group">
					<label for="phone">Phone Number</label>
					<form:input path="customerContact" id="phone" class="form-control" />
				</div>
				<br>
				<h3>Billing Address Info:</h3>
				<br>
				<div class="form-group">
					<label for="billingAddressStreet">Street Address</label>
					<form:input path="billingAddress.streetAddress"
						id="billingAddressStreet" class="form-control" />
				</div>
				<div class="form-group">
					<label for="billingAddressCity">City</label>
					<form:input path="billingAddress.city" id="billingAddressCity"
						class="form-control" />
				</div>
				<div class="form-group">
					<label for="billingAddressState">State</label>
					<form:input path="billingAddress.state" id="billingAddressState"
						class="form-control" />
				</div>
				<div class="form-group">
					<label for="billingAddressCountry">Country</label>
					<form:input path="billingAddress.country"
						id="billingAddressCountry" class="form-control" />
				</div>
				<div class="form-group">
					<label for="billingAddressZipcode">Zipcode</label>
					<form:input path="billingAddress.zipcode"
						id="billingAddressZipcode" class="form-control" />
				</div>
				<br>
				<h3>Shipping Address Info:</h3>
				<br>
				<div class="form-group">
					<label for="shippingAddressStreet">Street Address</label>
					<form:input path="shippingAddress.streetAddress"
						id="shippingAddressStreet" class="form-control" />
				</div>
				<div class="form-group">
					<label for="shippingAddressCity">City</label>
					<form:input path="shippingAddress.city" id="shippingAddressCity"
						class="form-control" />
				</div>
				<div class="form-group">
					<label for="shippingAddressState">State</label>
					<form:input path="shippingAddress.state" id="shippingAddressState"
						class="form-control" />
				</div>
				<div class="form-group">
					<label for="shippingAddressCountry">Country</label>
					<form:input path="shippingAddress.country"
						id="shippingAddressCountry" class="form-control" />
				</div>
				<div class="form-group">
					<label for="shippingAddressZipcode">Zipcode</label>
					<form:input path="shippingAddress.zipcode"
						id="shippingAddressZipcode" class="form-control" />
				</div>
				<br>
				<br>
				<form:button type="submit" value="Add" class="btn btn-primary">Register</form:button> | 
				<a href='<c:url value="/admin/product/productInventory"/>'
					class="btn btn-default">Cancel</a>
			</form:form>
		</div>
	</div>
</div>

<%@include file="/WEB-INF/views/templates/footer.jsp"%>