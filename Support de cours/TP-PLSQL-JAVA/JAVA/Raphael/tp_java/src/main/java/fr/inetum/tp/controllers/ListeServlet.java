package fr.inetum.tp.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;

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

@WebServlet("/liste")
public class ListeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IStagiaireService service;
	private IAdresseService serviceAd;
	
       
	@Override
	public void init() throws ServletException {
		try {
			service = new StagiaireService();
			serviceAd = new AdresseService();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// On vérifie si le bouton delete a été appuyé. Si c'est le cas, on supprime. Sinon, on affiche la liste. 
		try {
			if (request.getParameter("id") != null && request.getParameter("action").equalsIgnoreCase("delete")) {
				
			int idStagiaire =	Integer.parseInt(request.getParameter("id"));
			((StagiaireService) service).deleteStagiaire(idStagiaire);
			
			}
			Set<Stagiaire> stagiaires = new HashSet<>();
			stagiaires = service.allStagiaires();
			
			
			Set<Adresse> adresses = new HashSet<>();
			adresses = serviceAd.allAdresses(); 
			
			request.setAttribute("stagiaires", stagiaires);
			request.setAttribute("adresses", adresses);
			
			
		} catch (NumberFormatException | ClassNotFoundException | SQLException e){
			
			List<String> erreurs = new ArrayList<>();
			if(e instanceof ClassNotFoundException) {
				erreurs.add("attention drivers bdd introuvable");
			}
			if (e instanceof CommunicationsException) {
				erreurs.add("le serveur de bdd semble à la ramasse");
			}
			request.setAttribute("erreurs", erreurs);
			
		}
		request.getRequestDispatcher("/WEB-INF/view/liste.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	if (request.getParameter("id") != null && request.getParameter("action").equalsIgnoreCase("update")) {
				
				try {
					
					// stagiaire
					int id = Integer.parseInt(request.getParameter("id"));
					String prenomUpdate = request.getParameter("prenomUpdate");
					String emailUpdate = request.getParameter("emailUpdate");
					String mdpUpdate = request.getParameter("mdpUpdate");
					LocalDate ddnUpdate = LocalDate.parse(request.getParameter("ddnUpdate"));
					String role = request.getParameter("role");

					// adresse
					String nomVoieUpdate = request.getParameter("nomVoieUpdate");
					String codePostalUpdate = request.getParameter("codePostalUpdate");
					String villeUpdate = request.getParameter("villeUpdate");
					Integer idAdresse = 0;
					
					Adresse adresseUpdated = new Adresse(idAdresse, nomVoieUpdate,codePostalUpdate, villeUpdate);
					
					
					Stagiaire stagiaireUpdated = new Stagiaire(id,prenomUpdate,emailUpdate,mdpUpdate, adresseUpdated,ddnUpdate,role);
					
					((StagiaireService) service).updateStagiaire(stagiaireUpdated, adresseUpdated);
							

					
					response.sendRedirect(request.getContextPath()+"/liste");
					
				} catch (NumberFormatException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		else {
				doGet(request,response);
		}
	}

}
