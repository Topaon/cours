<%@ page import="fr.inetum.tp.entities.Stagiaire"%>
<%@ page import="fr.inetum.tp.entities.Adresse"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
// Récupérer l'user dans la session
Stagiaire user = (Stagiaire) request.getSession().getAttribute("user");
if (user == null) {
	// Il n'y a pas d'objet dans la session
	// Cela permet de protéger /converter si pas authentifié
	response.sendRedirect("login");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<title>Page liste</title>
</head>
<body>
	<div class="container">
		<h1>Liste des stagiaires</h1>
		<p>
		<%
					String role = (String) request.getSession().getAttribute("role");
					//System.out.println("listejsp role : " + role);
					if(user != null && role.equals("ADMIN")) {
					%>
			<a href="ajouter" class="btn btn-primary">Ajouter un stagiaire</a>
			<%		} %>
			
			<a href="deconnecter" class="btn btn-secondary float-end">Se déconnecter</a>
			
		</p>
		<table class="table table-hover table-bordered">
			<thead class="table-dark text-center text-uppercase">
				<tr>
					<td>Id</td>
					<td>Prénom</td>
					<td>Date de naissance</td>
					<td>Âge</td>
					<td>Email</td>
					<td>Rôle</td>
					<td>Voie</td>
					<td>Ville</td>
					<td colspan="2">Actions</td>
				</tr>
			</thead>
			<tbody class="text-center">
				<c:forEach var="stagiaire" items="${stagiaires}">
					<tr>
						<td>${ stagiaire.id }</td>
						<td>${ stagiaire.prenom }</td>
						<td>${ stagiaire.ddn }</td>
						<td>${ stagiaire.age } ans</td>
						<td>${ stagiaire.email }</td>
						<td>${ stagiaire.role }</td>
						
						<td>${ stagiaire.adresse.nomVoie }</td>
						<td>${ stagiaire.adresse.ville}</td>
						
					<%
					if(user == null) { %>
			   			<td></td>
						<td></td>
				<% } %>
				<%
					//System.out.println("listejsp role : " + role);
					if(user != null && role.equals("ADMIN")) {
					%>
						<td><a href="supprimer?id=${stagiaire.id}" class="btn btn-danger">Supprimer</a></td>
						<td><a href="modifier?id=${stagiaire.id}" class="btn btn-warning">Modifier</a></td>
			   	<% } else { %>
						<td></td>
						<td></td>
				<% } %>	

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>