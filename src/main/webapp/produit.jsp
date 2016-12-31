<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">

</head>
<body>

	<div class="container">

		<form:form method="POST" modelAttribute="produitForm"
			class="form-signin">
			<h2 class="form-signin-heading">Create your product</h2>


			<spring:bind path="libellePorduit">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label> libelle Produit </label>
					<form:input type="text" path="libellePorduit" class="form-control"
						placeholder="libelle Porduit" autofocus="true"></form:input>
					<form:errors path="libellePorduit"></form:errors>
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