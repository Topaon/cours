package fr.inetum.tp.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import fr.inetum.tp.entities.Adresse;
import fr.inetum.tp.entities.Stagiaire;
import fr.inetum.tp.services.IStagiaireService;
import fr.inetum.tp.services.StagiaireService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addStagiaire")
public class AddStagiaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IStagiaireService service;
	
	@Override
	public void init() throws ServletException {
		service = new StagiaireService();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/pages/addStagiaire.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String mdp = request.getParameter("password");
		LocalDate ddn = LocalDate.parse(request.getParameter("ddn"));
		String role = request.getParameter("newRole");

		String nomVoie = request.getParameter("nomVoie");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		
		Adresse adresse = new Adresse (nomVoie, codePostal, ville);
		Stagiaire stagiaire = new Stagiaire (prenom, email, mdp, adresse, ddn, role);
		
		try {
			service.addStagiaire(stagiaire, adresse);
			System.out.println(stagiaire.toString());
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("welcome");
	}

}
