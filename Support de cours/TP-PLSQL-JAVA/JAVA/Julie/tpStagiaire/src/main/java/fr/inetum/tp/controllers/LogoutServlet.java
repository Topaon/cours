package fr.inetum.tp.controllers;

import java.io.IOException;
import java.sql.SQLException;

import fr.inetum.tp.entities.Stagiaire;
import fr.inetum.tp.services.IStagiaireService;
import fr.inetum.tp.services.impl.StagiaireService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/deconnecter")
public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	IStagiaireService service;
	
	@Override
	public void init() throws ServletException {
		try {
			service = new StagiaireService();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void destroy() {
		service = null;
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		response.sendRedirect("login");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = (String) request.getSession().getAttribute("email");
		String password = (String) request.getSession().getAttribute("mdp");
		Stagiaire user = (Stagiaire) request.getSession().getAttribute("user");
		HttpSession session = request.getSession();
		try {
			user = service.getStagiaire(email, password);
			if (user != null) {
				user.setEmail(null);
				request.getSession().setAttribute("email", null);
				user.setMdp(null);
				request.getSession().setAttribute("mdp", null);
				user = null;
				request.getSession().setAttribute("user", null);
				session = request.getSession(true);
				response.sendRedirect("index.jsp");
				//request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
				

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
}
