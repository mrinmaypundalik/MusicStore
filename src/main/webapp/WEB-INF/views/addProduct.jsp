<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/templates/header.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Add Products to Inventory</h1>

			<p class="lead">Enter product information</p>
		</div>

		<div class="container">
			<form:form
				action="${pageContext.request.contextPath}/admin/product/addProduct"
				method="POST" commandName="product" enctype="multipart/form-data">
				<div class="form-group">
					<label for="name">Product Name</label>
					<form:errors path="productName" cssStyle="color:red" />
					<form:input path="productName" id="name" class="form-control" />
				</div>
				<div class="form-group">
					<label for="category">Category</label> <label
						class="checkbox-inline"> <form:radiobutton
							path="productCategory" id="category" value="Instrument" />Instrument
					</label> <label class="checkbox-inline"> <form:radiobutton
							path="productCategory" id="category" value="Record" />Record
					</label> <label class="checkbox-inline"> <form:radiobutton
							path="productCategory" id="category" value="Accessory" />Accessory
					</label>
				</div>
				<div class="form-group">
					<label for="Description">Description</label>
					<form:textarea path="productDescription" id="Description"
						class="form-control" />
				</div>
				<div class="form-group">
					<label for="Price">Price</label>
					<form:errors path="productPrice" cssStyle="color:red" />
					<form:input path="productPrice" id="Price" class="form-control" />
				</div>
				<div class="form-group">
					<label for="Condition">Condition</label> <label
						class="checkbox-inline"> <form:radiobutton
							path="productCondition" id="Condition" value="New" />New
					</label> <label class="checkbox-inline"> <form:radiobutton
							path="productCondition" id="Condition" value="Used" />Used
					</label>
				</div>
				<div class="form-group">
					<label for="Status">Status</label> <label class="checkbox-inline">
						<form:radiobutton path="productStatus" id="Status" value="Active" />Active
					</label> <label class="checkbox-inline"> <form:radiobutton
							path="productStatus" id="Status" value="Inactive" />Inactive
					</label>
				</div>
				<div class="form-group">
					<label for="InStock">In Stock</label>
					<form:errors path="productPrice" cssStyle="color:red" />
					<form:input path="unitInStock" id="InStock" class="form-control" />
				</div>
				<div class="form-group">
					<label for="Manufacturer">Manufacturer</label>
					<form:input path="productManufacturer" id="Manufacturer"
						class="form-control" />
				</div>

				<%-- <div class="form-group">
					<label for="productImage" class="control-label">Upload
						Image</label>
					<form:input path="productImage" type="file"
						class="form:input-large" id="productImage" />
				</div> --%>

				<div class="form-group">
					<label for="productImageUrl" class="control-label">Image
						URL</label>
					<form:input path="productImageUrl" class="form-control"
						id="productImageUrl" />
				</div>

				<br />
				<br />

				<form:button type="submit" value="Add" class="btn btn-primary">Submit</form:button>
				<a href='<c:url value="/admin/product/productInventory"/>'
					class="btn btn-default">Cancel</a>
			</form:form>
		</div>
	</div>
</div>

<%@include file="/WEB-INF/views/templates/footer.jsp"%>