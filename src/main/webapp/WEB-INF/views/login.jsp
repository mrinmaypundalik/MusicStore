<%@include file="/WEB-INF/views/templates/header.jsp"%>

<div class="container-wrapper">
	<div class="login-container">
		<div id="login-box">
			<h2>Enter Username and Password</h2>

			<c:if test="${not empty logoutMessage}">
				<div class="errorMessage" style="color: blue">${logoutMessage}</div>
			</c:if>

			<form action='<spring:url value="/j_spring_security_check"/>'
				name="loginForm" method="post">
				<div class="form-group">
					<c:if test="${not empty errorMessage}">
						<div class="errorMessage" style="color: red">${errorMessage}</div>
					</c:if>
					<label for="username">Username:</label> <input type="text"
						id="username" name="username" class="form-control" />
				</div>
				<div class="form-group">
					<label for="password">Password:</label> <input type="password"
						name="password" id="password" class="form-control" />
				</div>

				<input type="submit" value="Submit" class="btn btn-primary" /> <input
					type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form>
		</div>
	</div>
</div>

<%@include file="/WEB-INF/views/templates/footer.jsp"%>