
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
<h1> Content de vous revoir  ${ sessionScope.perso.prenom}, ${ sessionScope.perso.nom} !</h1>
<h2> Que souhaitez vous faire comme pizza ce soir ? </h2>


<form method="POST" action="add">
		<div>Veuillez ajouter le nom de la pizza que vous faire ?</div>
		<div>
			<label for="nom">nom</label> <input type="text" id="nom" name="nom" /> 
		</div>			<label for="type">origine</label> <input type="text" id="type" name="type" /> 
		
		<input type="submit" value="Ajouter" />
	</form>


</body>
</html>