<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="container">

		<form:form method="POST" modelAttribute="ingredientForm"
			class="form-signin">
			<h2 class="form-signin-heading">Create your ingredient</h2>


			<spring:bind path="libelleIngredient">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label> libelle Ingredient </label>
					<form:input type="text" path="libelleIngredient" class="form-control"
						placeholder="libelle Ingredient" autofocus="true"></form:input>
					<form:errors path="libelleIngredient"></form:errors>
				</div>
			</spring:bind>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
		</form:form>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>