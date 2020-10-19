<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<%@ include file="/views/jspf/head.jspf" %>
	<body class="text-center">
		<%@ include file="/views/jspf/header.jspf"%>
		<div class="container-fluid">
			<div class="row">
				<div class="col"></div>
				<div class="col"></div>
				<div class="col">
					<form class="needs-validation" novalidate 
					      name="loginForm" method="POST" action="controller">
						<input type="hidden" name="command" value="login" />
						<div class="form-group">
    						<input type="text" name="login" id="validationLogin" 
    							   class="form-control" placeholder="Login" required>
    					    <div class="valid-feedback">
        						Looks good!
      						</div>
      						<div class="invalid-feedback">
        						Please enter a login.
      						</div>
						</div>
						<div class="form-group">
						    <input type="password" name="password" id="validationPassword"
						           class="form-control" placeholder="Password" required>
						    <div class="valid-feedback">
        						Looks good!
      						</div>
      						<div class="invalid-feedback">
        						Please enter a password.
      						</div>
						</div>
						<br/>
							${loginerror}
							${wrongAction}
							${nullPage}
						<br/>
						    <button type="submit" 
						            class="btn btn-lg btn-dark btn-block">
						            Log in</button>
					</form>
					<script>
					(function() {
					  'use strict';
					  window.addEventListener('load', function() {
					    var forms = 
						    document.getElementsByClassName('needs-validation');
					    var validation = 
						    Array.prototype.filter.call(forms, function(form) {
					      form.addEventListener('submit', function(event) {
					        if (form.checkValidity() === false) {
					          event.preventDefault();
					          event.stopPropagation();
					        }
					        form.classList.add('was-validated');
					      }, false);
					    });
					  }, false);
					})();
					</script>
				</div>
				<div class="col"></div>
				<div class="col"></div>
			</div>
		</div>
		<%@ include file="/views/jspf/footer.jspf"%>
	</body>
</html>