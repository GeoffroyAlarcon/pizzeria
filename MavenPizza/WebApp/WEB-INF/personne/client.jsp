<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:url var="deconnexion" value="/deconnexion"></c:url>
<a href="${ deconnexion }">Cliquer ici pour se déconnecter.</a>

<h1> Bienvenue Cher  ${ sessionScope.perso.prenom}, ${ sessionScope.perso.nom} !</h1>
<h2>  que souhaitez vous mangez ? </h2>
<c:forEach items="${ affichePizza }" var="pizza" varStatus="status">
    <p>Nom de la pizza <c:out value="${ pizza.nom}" /> </p>
</c:forEach>

<form method="POST" action="delete">
		<div>Quelle Pizza avez vous commandez ?</div>
		<div>
			<label for="nom">nom</label> <input type="text" id="nom" name="nom" /> 
		</div>
		<input type="submit" value="choisir" />
	</form>

</body>
</html>