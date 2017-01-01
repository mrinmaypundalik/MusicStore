<%@include file="/WEB-INF/views/templates/header.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>Invalid Cart</h1>
				</div>
			</div>
		</section>
		<section class="container">

			<a class="btn btn-primary"
				href='<spring:url value="/product/productlist"/>'>OK</a>
		</section>
	</div>
</div>

<%@include file="/WEB-INF/views/templates/footer.jsp"%>