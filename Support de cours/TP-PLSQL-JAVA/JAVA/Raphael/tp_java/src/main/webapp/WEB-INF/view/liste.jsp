<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%--    <!--  jstl  -->
    <c:if test="${empty stagiaireCo }">
   	<c:redirect url="login"/>
    </c:if> --%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" />
<script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
	
<title>Page liste</title>
</head>
<body>

		<div class="container">

		<h1 class="text-center">Liste des stagiaires</h1>
		
	<%-- 	 	<c:if test="${ not empty erreurs}">
				<div class="alert alert-danger" role="alert">
					<c:forEach var="erreur" items="${erreurs }">
					${erreur }
					</c:forEach>
				</div>
			</c:if>
		 
		  <c:if test="${empty stagiaires && empty erreurs}">
				<div class="alert alert-danger" role="alert">
					Il n'y a aucun stagiaire dans la base de données
				</div>
		 </c:if>  --%>
		<p>
			<a href="ajout" class="btn btn-primary">Ajouter un stagiaire</a>
			<a href="deconnexion" class="btn btn-secondary float-end">Déconnexion</a>
		</p>
		<table class="table table-hover table-bordered">
			<thead class="table-dark text-center text-uppercase">
				<tr>
					<td>Id</td>
					<td>Prénom</td>
					<td>Date de naissance</td>
					<td>Email</td>
					<td>Role</td>
					<td>Voie</td>
					<td>Ville</td>
					<td colspan="2">Actions</td>
				</tr>
			</thead>
			<tbody class="text-center">
				<c:forEach var="stagiaire" items="${stagiaires }">
					<tr>
						<td>${ stagiaire.id}</td>
						<td>${ stagiaire.prenom}</td>
						<td>${ stagiaire.ddn}</td>
						<td>${ stagiaire.email}</td>
						<td>${ stagiaire.role }</td>
						<td> <c:out value="${stagiaire.adresseId}" /></td>
						<td>${stagiaire.adresseId.ville }</td>
					
					<c:if test="${role ==admin }">
						<td><form><a href="" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#UpdateModal${stagiaire.id}" >Modifier</a></form></td>
						<td><a href="" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#DeleteModal${stagiaire.id}" >Supprimer</a></td>
					</c:if>
					</tr>
					


	<!-- Update modal -->
					<div class="modal fade"id="UpdateModal${stagiaire.id }" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Update stagiaire</h5>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">
									<form method="post" action="liste?id=${stagiaire.id }&action=update">
										<div class="mb-3"> <label for="prenomUpdate" class="form-label">Prénom</label>
											<div><input type="text" name="prenomUpdate" id="prenomUpdate" placeholder="Saisir ici votre prenom" /></div>
										</div>
										<div class="mb-3">
											<label for="emailUpdate" class="form-label">Email</label>
											<div><input type="email" name="emailUpdate" id="emailUpdate" placeholder="Saisir ici votre email de connexion" /></div> 
										</div>
										<div class="mb-3">
											<label for="mdpUpdate" class="form-label">Mot de passe</label>
											<div><input type="password" name="mdpUpdate" id="mdpUpdate" placeholder="Saisir ici votre mot de passe" /></div> 
										</div>
										<div class="mb-3">
											<label for="ddnUpdate" class="form-label">Date de naissance</label>
											<div><input type="date" name="ddnUpdate" id="ddnUpdate" /></div> 
										</div>
										<!-- <div class="mb-3">
											<label for="adresse" class="form-label">Adresse</label>
											<div><input type="text" name="nomVoieUpdate" id="nomVoieUpdate" placeholder="Nom de la voie" /></div> 
											<div><input type="text" name="codePostalUpdate" id="codePostalUpdate" placeholder="Code Postal" /></div> 
											<div><input type="text" name="villeUpdate" id="villeUpdate" placeholder="Nom de la ville" /></div> 
										</div> -->
										<div class="mb-3">
											<label for="role" class="form-label">Rôle</label>
											<div>
												<select name="role" id="role" >
												<option value="other">OTHER</option>
												<option value="admin">ADMIN</option>
												</select>
											</div> 
										</div>															
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Retour</button>
											<button type="submit" class="btn btn-warning">Modifier</button>
										</div>		
									</form>	
								</div>
							</div>
						</div>
					</div>


			<!-- Delete modal -->
					<div class="modal fade"id="DeleteModal${stagiaire.id }" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Suppression stagiaire</h5>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">Êtes-vous sûr de vouloir supprimer le stagiaire ${stagiaire.prenom} ?</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Retour</button>
									<a href="liste?id=${stagiaire.id }&action=delete"><button type="button" class="btn btn-danger">Supprimer</button>
									</a>
								</div>
							</div>
						</div>
					</div>



				</c:forEach>
			</tbody>
		</table>
	</div>
	
	

</body>
</html>