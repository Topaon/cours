<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="assets/bs/css/bootstrap.css" />
<link rel="stylesheet" href="assets/css/css/app.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Liste des Stagiaires</title>
</head>

<div class="container">
<div class="header"  style=" color= white ; background-color: #303f9f;">Liste des stagiaires</div>
	<br>
	<br>		
	<table class="table shadow table-hover table-bordered" style="color:  white;">
			<thead class="text-center text-uppercase"  style=" background-color: #303f9f; color:white;">
					
			<tr>
				
				<td>Prénom</td>
				<td>Email</td>
				<td>Mot de passe</td>
				<td>date de naissance</td>
				<td>role</td>
				<td>Id</td>
				<td>Nom voie</td>
				<td>ville</td>
				<td colspan="2">Actions</td>
				
			</tr>
		</thead>
	
	<thead class="text-center text-uppercase" style=" background-color: #303f9f; color:white;">
			<tbody>
			<c:forEach var="stagiaire" items="${stagiaires}">
			<tr style= "color: #303f9f;">
					
					<td>${stagiaire.prenom}</td>
					<td>${stagiaire.email}</td>
					<td>${stagiaire.mdp}</td>
					<td>${stagiaire.ddn}</td>
					<td>${stagiaire.role}</td>
					<td>${stagiaire.id}</td>
					<td>${stagiaire.nomVoie}</td>
					<td>${stagiaire.ville}</td>
					<td><a href="liste?action=supprimer&&id=${stagiaire.id }"  class="btn btn-danger">Supprimer</a></td>
					<td><a href="liste?action=modifier&&id=${stagiaire.id }" class="btn btn-warning">Modifier</a></td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	
</body>
</html>