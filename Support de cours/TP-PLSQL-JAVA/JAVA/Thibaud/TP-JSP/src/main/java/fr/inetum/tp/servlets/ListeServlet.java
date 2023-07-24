package fr.inetum.tp.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;

import fr.inetum.tp.entites.Adresse;
import fr.inetum.tp.entites.Stagiaire;
import fr.inetum.tp.interfaces.IAdresseService;
import fr.inetum.tp.interfaces.IStagiaireService;
import fr.inetum.tp.services.AdresseService;
import fr.inetum.tp.services.StagiaireService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/liste")
public class ListeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private IStagiaireService service;
	private IAdresseService serviceAD;
	
    public void init() {
    	try {
			service = new StagiaireService();
			serviceAD = new AdresseService();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			if (request.getParameter("id") != null && request.getParameter("action").equalsIgnoreCase("delete")) {
				
			int StagiaireID =	Integer.parseInt(request.getParameter("id"));
			((StagiaireService) service).removeStagiaire(StagiaireID);
			
			}
			Set<Stagiaire> stagiaires = new HashSet<>();
			stagiaires = service.allStagiaires();
			
			
			Set<Adresse> adresses = new HashSet<>();
			adresses = serviceAD.allAdresses(); 
			
			request.setAttribute("stagiaires", stagiaires);
			request.setAttribute("adresses", adresses);
			
			
		} catch (NumberFormatException | ClassNotFoundException | SQLException e){
			
			List<String> erreurs = new ArrayList<>();
			if(e instanceof ClassNotFoundException) {
				erreurs.add("Drivers BDD introuvables");
			}
			if (e instanceof CommunicationsException) {
				erreurs.add("Le serveur ne répond pas");
			}
			request.setAttribute("erreurs", erreurs);
			
		}
		request.getRequestDispatcher("/WEB-INF/pages/liste.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
