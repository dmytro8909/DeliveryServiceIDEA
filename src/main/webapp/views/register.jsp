<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
					<form name="registerForm" method="POST" action="controller"
						  class="needs-validation" novalidate>
						<input type="hidden" name="command" value="register" />
						<div class="form-group">
							<input type="text" class="form-control" 
								   id="validationName" name="name" 
								   placeholder="First name" required>
							<div class="valid-feedback">
        						Looks good!
      						</div>
      						<div class="invalid-feedback">
        						Please enter a name.
      						</div>
						</div>			
						<div class="form-group">
							<input type="text" class="form-control"
								   id="validationLastName" name="lastName" 
								   placeholder="Last name" required>
							<div class="valid-feedback">
        						Looks good!
      						</div>
      						<div class="invalid-feedback">
        						Please enter a last name.
      						</div>	   
						</div>		
						<div class="form-group">	
							<input type="text" class="form-control" 
								   id="validationLogin" name="login"	
								   placeholder="Login" required>
							<div class="valid-feedback">
        						Looks good!
      						</div>
      						<div class="invalid-feedback">
        						Please enter a login.
      						</div>
						</div>		
						<div class="form-group">	
							<input type="password" class="form-control"
								   id="validationPassword" name="password" 
								   placeholder="Password" required>
							<div class="valid-feedback">
        						Looks good!
      						</div>
      						<div class="invalid-feedback">
        						Please enter a password.
      						</div>
						</div>	
						<br/>
						<button type="submit"
							    class="btn btn-lg btn-dark btn-block">
							    Registration</button>		
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