<%@ page import="fr.inetum.tp.entities.Stagiaire"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="fr">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="assets/bs/css/bootstrap.css" />
<link rel="stylesheet" href="assets/css/app.css">
<title>Login</title>
</head>
<body>
	<div class="content">
		<div class="header">JPA - JSP - filter - CRUD</div>
		<div class="monForm shadow mt-5">
			<div class="titre bg-primary">login form</div>
			<form method="post">
				<div class="mb-3">
					<label for="email"><span class="help-required"></span></label> <input
						type="email" class="form-control required" 
						id="email" placeholder="Saisir votre login au format @email"
						name="email"
						<% String message = (String) request.getAttribute("message");
						 Stagiaire user = (Stagiaire) request.getSession().getAttribute("user");
						if (user == null) { %>
					    
					    value="${ email}" />
					    
					<% } else {%>
							 />
					<% } %>
				</div>
				<div class="mb-3">
					<label for="mdp"><span class="help-required"></span></label> <input
						type="password" class="form-control" id="mdp"
						placeholder="Saisir votre mot de passe" name="mdp" />
				</div>
				<div>
					<%
					//String message = (String) request.getAttribute("message");
					if (message != null) {
							//System.out.println(message);
					%>
						<div class="error">
							<%=request.getAttribute("message")%>
						</div>
				 <% } %>
				</div>
				<div>
					<input type="submit" value="Valider" class="btn btn-primary" /> <input
						type="reset" value="Reset" class="btn btn-secondary float-end" />
				</div>
			</form>
		</div>
	</div>
</body>
</html>
