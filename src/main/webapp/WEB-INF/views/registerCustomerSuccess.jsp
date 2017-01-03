<%@include file="/WEB-INF/views/templates/header.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>Registration Complete!</h1>

					<p>Welcome to the Family</p>
				</div>
			</div>
		</section>
		<section class="container">

			<a class="btn btn-primary" href='<spring:url value="/login"/>'>Log in
				to Continue</a>
		</section>
	</div>
</div>

<%@include file="/WEB-INF/views/templates/footer.jsp"%>