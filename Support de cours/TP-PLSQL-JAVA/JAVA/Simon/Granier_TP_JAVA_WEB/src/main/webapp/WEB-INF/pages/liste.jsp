<%@ page import="fr.inetum.tp.entites.Stagiaire" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
Stagiaire user = (Stagiaire) request.getSession().getAttribute("user");
    if (user == null) {
        response.sendRedirect("login");
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
	<h1>Liste des stagiaires</h1>
	<a href="ajouter">Ajouter un Stagiaire</a>
	<table class="table table-striped">
		<thead>
			<tr>
				<td>Id</td>
				<td>Prenom</td>
				<td>email</td>
				<td>Mot de passe</td>
				<td>Voie</td>
				<td>Ville</td>
				<td>Date de naissance</td>
				<td>Rôle</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="s" items="${listeStagiaires }">
				<tr>
					<td>${s.id }</td>
					<td>${s.prenom }</td>
					<td>${s.email }</td>
					<td>${s.mdp }</td>
					<td>${s.ddn }</td>
					<td>${s.role }</td>
					<td><a href="liste?idsup=${s.id }">Supprimer</a></td>
					<td><a href="ajouter?id=${s.id }&prenom=${s.prenom}&mdp=${s.mdp}&email=${s.email}&ddn=${s.ddn}&adresse=${s.adresse.id}&role=${s.role}">Modifier</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>