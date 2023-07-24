<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
	<%-- 
	 <c:if test="${empty StagiaireCo }">
   	<c:redirect url="login"/>
    </c:if> --%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" />
<title>Ajout stagiaire</title>
</head>
<body>

<div class="container">
		<h1>Ajout de stagiaire</h1>

		<form method="post">

			<div class="mb-3">
				<label for="prenom" class="form-label">Prénom</label> 
				<div>
					<input type="text" name="prenom" id="prenom" placeholder="Saisir ici votre prenom" />
				</div>
			</div>
			<div class="mb-3">
				<label for="email" class="form-label">Email</label>
				<div>
					<input type="email" name="email" id="email" placeholder="Saisir ici votre email de connexion" />
				</div> 
			</div>
			<div class="mb-3">
				<label for="mdp" class="form-label">Mot de passe</label>
				<div>
					<input type="password" name="mdp" id="mdp" placeholder="Saisir ici votre mot de passe" />
				</div> 
			</div>
			<div class="mb-3">
				<label for="ddn" class="form-label">Date de naissance</label>
				<div>
					<input type="date" name="ddn" id="ddn" />
				</div> 
			</div>
			<div class="mb-3">
				<label for="adresse" class="form-label">Adresse</label>
				<div>
					<input type="text" name="nomVoie" id="nomVoie" placeholder="Nom de la voie" />
				</div> 
				<div>
					<input type="text" name="codePostal" id="codePostal" placeholder="Code Postal" />
				</div> 
				<div>
					<input type="text" name="ville" id="ville" placeholder="Nom de la ville" />
				</div> 
			</div>
			
			<div class="mb-3">
				<label for="role" class="form-label">Rôle</label>
				<div>
					<select name="role" id="role" >
					<option value="other">OTHER</option>
					<option value="admin">ADMIN</option>
					</select>
				</div> 
			</div>
			<input class="btn btn-primary" type="submit" value="Valider">
		</form>
	</div>
</body>
</html>