<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="fr">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="assets/bs/css/bootstrap.css" />
<link rel="stylesheet" href="assets/css/app.css">
<title>Login Page</title>
</head>

<body>
	<div class="content">
		<div class="header">JSP - FILTER - CRUD</div>
		<div class="monForm shadow mt-5">
			<div class="titre bg-primary">LOGIN FORM</div>
			<form method="post">
				<div class="mb-3">
					<label for="login" class="form-label">Email</label> <input
						name="email" type="email" class="form-control" id="login"
						placeholder="Saisir votre login au format @email">
				</div>
				<div class="mb-3">
					<label for="mdp" class="form-label">Mot de passe</label> <input
						name="password" type="password" class="form-control" id="mdp"
						placeholder="Saisir votre mot de passe">
				</div>
				<div>
					<input type="submit" value="Valider" class="btn btn-primary" /> <input
						type="reset" value="Reset" class="btn btn-secondary float-end" />
				</div>

			</form>

			<c:if test="${not empty erreurs }">
				<div class="alert alert-danger" role="alert">
					<c:forEach var="erreur" items="${erreurs}">
					${erreur }
				</c:forEach>
				</div>
			</c:if>

		</div>
	</div>
</body>
</html>