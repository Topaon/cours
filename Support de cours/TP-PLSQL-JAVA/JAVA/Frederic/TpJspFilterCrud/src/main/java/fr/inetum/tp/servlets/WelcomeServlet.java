package fr.inetum.tp.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;

import fr.inetum.tp.entities.Stagiaire;
import fr.inetum.tp.services.IStagiaireService;
import fr.inetum.tp.services.StagiaireService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IStagiaireService service;
	
	@Override
	public void init() throws ServletException {
		service = new StagiaireService();
	}
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Stagiaire> stagiaires = new ArrayList<>();
		List<String> erreurs = new ArrayList<>();	
		request.setAttribute("stagiaireRole", request.getAttribute("stagiaireRole"));
		System.out.println("Rôle: " + request.getAttribute("stagiaireRole"));

		try {
			stagiaires = service.allStagiaires();
				if (!stagiaires.isEmpty()) {
					request.setAttribute("stagiaires", stagiaires);
				} 
				else {
					erreurs.add("La liste des stagiaires est vide");
					request.setAttribute("erreurs", erreurs);
				}
		}  catch (ClassNotFoundException | SQLException e) {
			if(e instanceof ClassNotFoundException) {
				erreurs.add("Les drivers de la BDD sont introuvables");
			}
			if(e instanceof CommunicationsException) {
				erreurs.add("Le serveur de BDD semble à l'arrêt");
			}
			request.setAttribute("erreurs", erreurs);
		} 
		
		request.getRequestDispatcher("/WEB-INF/pages/welcome.jsp").forward(request, response); 

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
