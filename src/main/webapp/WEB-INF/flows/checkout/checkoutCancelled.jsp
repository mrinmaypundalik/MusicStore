<%@include file="/WEB-INF/views/templates/header.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1 class="alert alert-danger">Checkout Cancelled</h1>

					<p>Your checkout process has been successfully cancelled</p>
				</div>
			</div>
		</section>
		<section class="container">

			<a class="btn btn-primary" href='<spring:url value="/"/>'>Let's
				Shop</a>
		</section>
	</div>
</div>

<%@include file="/WEB-INF/views/templates/footer.jsp"%>