<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>
	<div class="container-fluid bg-dark text-white text-center">
		<h1>Authentification</h1>
		<form action="auth" method="post">
			<label for="nom"> Nom : </label> <input name="nom" type="text">
			<label for="Prenom"> Prenom : </label> <input name="prenom"
				type="text"> <input type="submit" value="envoyer">
		</form>
	</div>
	
</body>
</html>