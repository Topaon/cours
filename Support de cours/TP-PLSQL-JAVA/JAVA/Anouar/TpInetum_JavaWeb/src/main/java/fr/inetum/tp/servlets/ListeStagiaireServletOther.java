package fr.inetum.tp.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

import fr.inetum.tp.entites.Adresse;
import fr.inetum.tp.entites.Stagiaire;
import fr.inetum.tp.services.AdresseService;
import fr.inetum.tp.services.IAdresseService;
import fr.inetum.tp.services.IStagiaireService;
import fr.inetum.tp.services.StagiaireService;



@WebServlet("/liste1")
public class ListeStagiaireServletOther extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IStagiaireService service;
	private IAdresseService service1;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Set<Stagiaire> listeStagiaires;
		service = new StagiaireService();
		
		Set<Adresse> listeAdresses;
		service1 = new AdresseService();
		try {
			listeStagiaires = service.allStagiaires();
	        request.setAttribute("listeStagiaires", listeStagiaires);
	        
	        listeAdresses = service1.allAdresse();
	        request.setAttribute("listeAdresses", listeAdresses);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}



		request.getRequestDispatcher("/WEB-INF/jsp/listeOther.jsp").forward(request, response);
	
}
}
