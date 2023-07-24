package fr.inetum.tp.servlets;

import java.io.IOException;
import java.sql.Date;

import fr.inetum.tp.entites.Adresse;
import fr.inetum.tp.entites.Stagiaire;
import fr.inetum.tp.services.AdresseService;
import fr.inetum.tp.services.StagiaireService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ajouter")
public class AjouterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id") != null) {
			AdresseService as = new AdresseService();
			Adresse adresse = as.readAdresse(Integer.parseInt(request.getParameter("adresse")));
			Stagiaire stagiaire = new Stagiaire(
					Integer.parseInt(request.getParameter("id")), 
					request.getParameter("prenom"),
					request.getParameter("email"),
					request.getParameter("mdp"),
					adresse,
					Date.valueOf(request.getParameter("ddn")),
					request.getParameter("role"));
			request.setAttribute("stagiaire", stagiaire);
		}
		request.getRequestDispatcher("/WEB-INF/pages/ajouter.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdresseService as = new AdresseService();
		
		int id = 0;
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String mdp = request.getParameter("mdp");
		Adresse adresse = new Adresse(); //as.readAdresse(Integer.parseInt(request.getParameter("adresse")));
		Date ddn = Date.valueOf(request.getParameter("ddn"));
		String role = request.getParameter("role");
		
		Stagiaire stagiaire = new Stagiaire(id, prenom, email, mdp, adresse, ddn, role);
		
		String nomVoie = request.getParameter("nomVoie");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		
		Adresse newAdresse = new Adresse(id, nomVoie, codePostal, ville);
		
		StagiaireService ss = new StagiaireService();
		
		if (request.getParameter("action") != null) {
			stagiaire.setId(Integer.parseInt(request.getParameter("id")));
			ss.updateStagiaire(stagiaire);
		} else {
			ss.addStagiaire(stagiaire, newAdresse);
		}
		response.sendRedirect("liste");
	}
}
