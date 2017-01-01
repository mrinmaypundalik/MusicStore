<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/templates/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Customer Management Page!</h1>

            <p class="lead">This is the Customer Management Page!</p>
        </div>

        <table class="table table-striped table-hover text-center">
            <thead class="thead-inverse">
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Phone Number</th>
                <th>Username</th>
                <th>Enabled</th>
            </tr>
            </thead>
            <c:forEach items="${customers}" var="customer">
                <tr>
                    <td>${customer.customerFirstName} ${customer.customerLastName}</td>
                    <td>${customer.customerEmail}</td>
                    <td>${customer.customerContact}</td>
                    <td>${customer.username}</td>
                    <td>${customer.enabled}</td>
                </tr>
            </c:forEach>
        </table>
        </div>
        </div>

<%@include file="/WEB-INF/views/templates/footer.jsp"%>