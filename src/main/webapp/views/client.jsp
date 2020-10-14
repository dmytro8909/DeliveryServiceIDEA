<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "dao.OrderDAO" %>
<% OrderDAO orderDAO = new OrderDAO(); %>
<% request.setAttribute("ordersList",orderDAO.getAll()); %>
<!DOCTYPE html>
<html>
	<%@ include file="/views/jspf/head.jspf" %>
	<body class="text-center">
		<%@ include file="/views/jspf/header.jspf"%>
		<div class="container-fluid">
			<div class="row">
				<div class="col">
					<h3>Your orders, ${user.name}</h3>
					<table class="table">
					    <thead>
					        <tr>
					            <th scope="col">ID</th>
					            <th scope="col">Date</th>
					            <th scope="col">Description</th>
					            <th scope="col">Cost</th>
					            <th scope="col">Review</th>
					        </tr>
					    </thead>
					    <tbody>
					    	<c:forEach items="${ordersList}" var="orders">
					            <tr>
					                <td>${orders.id}</td>
                                    <td>${orders.shippingDate}</td>
                                    <td>${orders.description}</td>
                                    <td>${orders.cost}</td>
                                    <td><a class="btn btn-dark"
                                           href="controller?command=showOrder"
                                           role="button">Login</a>
                                    </td>
					            </tr>
                        	</c:forEach>
					    </tbody>
					</table>
				</div>
			</div>
		</div>
		<%@ include file="/views/jspf/footer.jspf"%>
	</body>
</html>