<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import= "dao.DirectionDAO" %>
<%@ page import= "dao.RatesDAO" %>
<% DirectionDAO dirDAO = new DirectionDAO(); %>
<% request.setAttribute("directionList",dirDAO.getAll()); %>
<% RatesDAO rateDAO = new RatesDAO(); %>
<% request.setAttribute("rateUpTo2",rateDAO.getRateByName("up_to_2")); %>
<% request.setAttribute("over2",rateDAO.getRateByName("over_2")); %>
<% request.setAttribute("otherwise",rateDAO.getRateByName("otherwise")); %>
<html>
	<%@ include file="/views/jspf/head.jspf" %>
	<body class="text-center">
		<%@ include file="/views/jspf/header.jspf"%>
		<c:if test="${not empty user}">
            <c:choose>
                <c:when test="${userRole == 'manager'}">
                    <%@ include file="/views/jspf/manager_main.jspf"%>
                </c:when>
                <c:when test="${userRole == 'user'}">
                    <%@ include file="/views/jspf/client_main.jspf"%>
                </c:when>
            </c:choose>
		</c:if>
		<c:if test="${empty user}">
			 <%@ include file="/views/jspf/main_not_register.jspf"%>
		</c:if>
		<%@ include file="/views/jspf/footer.jspf"%>
	</body>
</html>
