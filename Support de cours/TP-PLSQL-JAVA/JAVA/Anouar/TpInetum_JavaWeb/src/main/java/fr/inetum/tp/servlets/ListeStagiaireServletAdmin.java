package fr.inetum.tp.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Set;

import fr.inetum.tp.entites.Adresse;
import fr.inetum.tp.entites.Stagiaire;
import fr.inetum.tp.services.AdresseService;
import fr.inetum.tp.services.IAdresseService;
import fr.inetum.tp.services.IStagiaireService;
import fr.inetum.tp.services.StagiaireService;



@WebServlet("/liste")
public class ListeStagiaireServletAdmin extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private StagiaireService service;
	private IAdresseService service1;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Set<Stagiaire> listeStagiaires;
		service = new StagiaireService();		
		Set<Adresse> listeAdresses;
		service1 = new AdresseService();
		
		String id = request.getParameter("id");
		String action = request.getParameter("action");
		
		try {
			if (action != null && action.equals("supprimer") && Integer.parseInt(id) != 0) {
				service.removeStagiaire(service.getStagiaire(Integer.parseInt(id)));
				
			}	
			if ( action != null && action.equals("modifier") && Integer.parseInt(id) != 0) {
				request.getRequestDispatcher("/WEB-INF/jsp/ajouter.jsp").forward(request, response);
			}
			
			listeStagiaires = service.allStagiaires();
	        request.setAttribute("listeStagiaires", listeStagiaires);
	        
	        listeAdresses = service1.allAdresse();
	        request.setAttribute("listeAdresses", listeAdresses);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}



		request.getRequestDispatcher("/WEB-INF/jsp/listeAdmin.jsp").forward(request, response);
}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String prenom = req.getParameter("prenom");
		String email = req.getParameter("email");
		String mdp = req.getParameter("mdp");
		String adresseId = req.getParameter("adresseId");
		LocalDate ddn = LocalDate.parse(req.getParameter("ddn"));
		String role = req.getParameter("role");
		String id = req.getParameter("id");
		String nomVoie = req.getParameter("nomVoie");
		String codePostal = req.getParameter("codePostal");
		String ville = req.getParameter("ville");
		Stagiaire stagiaire = new Stagiaire(prenom, email, mdp,Integer.parseInt(adresseId),ddn,role,Integer.parseInt(id));
		Adresse adresse = new Adresse(nomVoie,codePostal,ville,Integer.parseInt(id));
		System.out.println(stagiaire.toString());
		System.out.println(adresse.toString());
		try {		
			service.updateStagiaire(stagiaire, adresse);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		resp.sendRedirect("liste");
	}
	
}
