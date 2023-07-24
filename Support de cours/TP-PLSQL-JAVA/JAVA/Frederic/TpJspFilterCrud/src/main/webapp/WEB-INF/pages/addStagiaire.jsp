<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

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
			<div class="titre bg-primary">AJOUTER STAGIAIRE</div>
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
					<input type="email" name="email" id="email" placeholder="Saisir ici votre email" />
				</div> 
			</div>
			<div class="mb-3">
				<label for="mdp" class="form-label">Mot de passe</label>
				<div>
					<input type="password" name="password" id="mdp" placeholder="Saisir ici votre mot de passe" />
				</div> 
			</div>
			<div class="mb-3">
				<label for="ddn" class="form-label">Date de naissance</label>
				<div>
					<input type="date" name="ddn" id="ddn" />
				</div> 
			<div class="mb-3">
				<label for="nomVoie" class="form-label">Nom de voie</label> 
				<div>
					<input type="text" name="nomVoie" id="nomVoie" placeholder="Saisir ici votre nom de voie" />
				</div>
			</div><div class="mb-3">
				<label for="codePostal" class="form-label">Code postal</label> 
				<div>
					<input type="text" name="codePostal" id="codePostal" placeholder="Saisir ici votre code postal" />
				</div>
			</div>
			<div class="mb-3">
				<label for="ville" class="form-label">Ville</label> 
				<div>
					<input type="text" name="ville" id="ville" placeholder="Saisir ici votre ville" />
				</div>
			</div>
			<div class="mb-3">
				<label for="role" class="form-label">Rôle</label> 
				<div>
					<input type="text" name="newRole" id="role" placeholder="Saisir ici votre rôle" />
				</div>
			</div>

				<div>
					<input type="submit" value="Valider" class="btn btn-primary" /> <input
						type="reset" value="Reset" class="btn btn-secondary float-end" />
				</div>

			</form>


		</div>
	</div>
</body>