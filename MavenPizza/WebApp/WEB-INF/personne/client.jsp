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
<h1> Bienvenue Cher  ${ sessionScope.perso.prenom}, ${ sessionScope.perso.nom} !</h1>
<h2>  que souhaitez vous mangez ? </h2>
<c:forEach items="${ pizzas }" var="pizza" varStatus="nom">
    <p>Nom de la pizza <c:out value="${ pizza.nom}" /> </p>
</c:forEach>

<form method="POST" action="pizza/supp">
		<div>Veuillez ajouter le nom de la pizza que vous souhaitez commandez</div>
		<div>
			<label for="nom">nom</label> <input type="text" id="nom" name="nom" /> 
		</div>
		<input type="submit" value="Supprimer" />
	</form>

</body>
</html>