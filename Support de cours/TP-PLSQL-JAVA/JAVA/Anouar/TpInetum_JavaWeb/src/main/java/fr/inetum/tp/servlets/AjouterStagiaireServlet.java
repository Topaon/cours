package fr.inetum.tp.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import fr.inetum.tp.entites.Adresse;
import fr.inetum.tp.entites.Stagiaire;
import fr.inetum.tp.services.IStagiaireService;
import fr.inetum.tp.services.StagiaireService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ajouter")
public class AjouterStagiaireServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IStagiaireService service;

	@Override
	public void init() throws ServletException {
		service = new StagiaireService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/ajouter.jsp").forward(req, resp);
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

		try {
			service.addStagiaire(stagiaire, adresse);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		resp.sendRedirect("liste");
	}
}
