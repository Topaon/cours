package fr.inetum.tp.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import fr.inetum.tp.dao.IAdresseService;
import fr.inetum.tp.dao.IStagiaireService;
import fr.inetum.tp.entites.Adresse;
import fr.inetum.tp.entites.Stagiaire;
import fr.inetum.tp.services.AdresseService;
import fr.inetum.tp.services.StagiaireService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ajout")
public class AjoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IStagiaireService stagiaireService;
	private IAdresseService adresseService;

	    
	    @Override
	    public void init() throws ServletException {
	    try {
			stagiaireService = new StagiaireService();
			adresseService = new AdresseService();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher("/WEB-INF/view/ajout.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// stagiaire
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String mdp = request.getParameter("mdp");
		LocalDate ddn = LocalDate.parse(request.getParameter("ddn"));
		String role = request.getParameter("role");
		
		// adresse
		String nomVoie = request.getParameter("nomVoie");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		
		Adresse adresse = new Adresse(nomVoie, codePostal, ville);
		
		Stagiaire stagiaire = new Stagiaire(prenom, email, mdp, ddn, adresse, role);
		
		try {
			adresseService.addAdresse(adresse);
			System.out.println(adresse.getId());
			
			stagiaireService.addStagiaire(stagiaire, adresse);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("liste");
		
	}

}
