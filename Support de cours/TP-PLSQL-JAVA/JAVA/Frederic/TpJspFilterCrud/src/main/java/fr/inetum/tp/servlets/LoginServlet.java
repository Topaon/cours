package fr.inetum.tp.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.inetum.tp.entities.Stagiaire;
import fr.inetum.tp.services.IStagiaireService;
import fr.inetum.tp.services.StagiaireService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IStagiaireService service;

	@Override
	public void init() throws ServletException {
		service = new StagiaireService();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println(String.format("Stagiaire " + "email : %s, password : %s", email, password));
		List<String> erreurs = new ArrayList<>();	

		Stagiaire stagiaire = new Stagiaire();

		try {
			stagiaire = service.getStagiaire(email, password);
				if (stagiaire != null) {
					request.setAttribute("stagiaireRole", stagiaire.getRole());
					request.getSession().setAttribute("stagiaire", stagiaire);
					request.getRequestDispatcher("/welcome").forward(request, response);
				} else {
					erreurs.add("email ou mot de passe incorrect");
					request.setAttribute("erreurs", erreurs);
					request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response); 
					
				}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
