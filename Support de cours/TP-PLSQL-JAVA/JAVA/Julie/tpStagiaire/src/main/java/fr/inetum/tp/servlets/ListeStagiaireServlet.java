package fr.inetum.tp.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;
import java.util.HashSet;

import fr.inetum.tp.entities.Stagiaire;
import fr.inetum.tp.services.IStagiaireService;
import fr.inetum.tp.services.impl.StagiaireService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/liste")
public class ListeStagiaireServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IStagiaireService service;

	@Override
	public void init() throws ServletException {
		try {
			service = new StagiaireService();
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
		try {
			stagiaires = service.allStagiaire();
			request.setAttribute("stagiaires", stagiaires);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("WEB-INF/pages/liste.jsp").forward(request, response);
	}

}
