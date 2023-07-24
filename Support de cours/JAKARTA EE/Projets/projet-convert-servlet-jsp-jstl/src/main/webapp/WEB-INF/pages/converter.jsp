<%@page import="fr.inetum.formation.convert.models.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${empty user}">
	<c:redirect url="login" />
</c:if>

<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="assets/bs/css/bootstrap.css" />
<link rel="stylesheet" href="assets/css/app.css">
<title>Converter Page</title>
</head>
<body>
	<div class="content">
		<div class="header">projet converter</div>
		<div class="monForm shadow mt-5">
			<div class="titre bg-primary">converter form</div>
			<form method="post">
				<div class="mb-3">
					<label for="login" class="form-label">Température</label> <input
						type="text" class="form-control" id="celsius" name="celsius"
						placeholder="Saisir la température en dégré °C">
				</div>
				<div>
					<input type="submit" value="Valider" class="btn btn-primary" /> <input
						type="reset" value="Reset" class="btn btn-secondary float-end" />
				</div>
			</form>
		</div>
		
		<c:if test="${resultat != null }">
			<div class="resultat alert alert-success">${ resultat }</div>
		</c:if>
				
		<c:if test="${ erreur != null }">
			<div class="error alert alert-danger">${ erreur }</div>
		</c:if>
	</div>
</body>
</html>