package fr.inetum.tp.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;
import java.util.HashSet;

import fr.inetum.tp.entities.Adresse;
import fr.inetum.tp.entities.Stagiaire;
import fr.inetum.tp.services.IAdresseService;
import fr.inetum.tp.services.IStagiaireService;
import fr.inetum.tp.services.impl.AdresseService;
import fr.inetum.tp.services.impl.StagiaireService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/liste")
public class ListeStagiaireServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IStagiaireService stagiaireService;
	private IAdresseService adresseService;

	@Override
	public void init() throws ServletException {
		try {
			stagiaireService = new StagiaireService();
			adresseService = new AdresseService();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String role = (String) request.getSession().getAttribute("role");
		//System.out.println("doGetListe role : " + role);

		Set<Stagiaire> stagiaires = new HashSet<Stagiaire>();
		Set<Adresse> adresses = new HashSet<Adresse>();
		try {
			stagiaires = stagiaireService.allStagiaire();
			request.setAttribute("stagiaires", stagiaires);
			for (Stagiaire s : stagiaires) {
				Integer adresseId = s.getAdresse().getId();
				String nomVoie = s.getAdresse().getNomVoie();
				String ville = s.getAdresse().getVille();
				String codePostal = s.getAdresse().getVille();
				request.setAttribute("nomVoie", nomVoie);
				request.setAttribute("ville", ville);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("WEB-INF/pages/liste.jsp").forward(request, response);
	}

}
