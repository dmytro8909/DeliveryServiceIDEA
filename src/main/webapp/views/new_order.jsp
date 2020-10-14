<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import= "dao.DirectionDAO" %>
<% DirectionDAO dirDAO = new DirectionDAO(); %>
<% request.setAttribute("directionList",dirDAO.getAll()); %>
<html>
	<%@ include file="/views/jspf/head.jspf" %>
	<body class="text-center">
		<%@ include file="/views/jspf/header.jspf"%>
        <%@ include file="/views/jspf/do_order.jspf"%>
		<%@ include file="/views/jspf/footer.jspf"%>
	</body>
</html>