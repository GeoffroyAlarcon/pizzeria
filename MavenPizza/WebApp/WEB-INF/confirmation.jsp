<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html;  charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

</head>
<body>
<h1> Voici la liste des pizza restantes</h1>
<c:forEach items="${ pizzas }" var="pizza" varStatus="status">
    <p>Nom de la pizza :  <c:out value="${ pizza.nom}" /> , origine :   <c:out value="${pizza.type }"></c:out> </p>
</c:forEach>
</body>
</html>