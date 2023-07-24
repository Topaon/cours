package fr.inetum.tp.servlets;

import java.io.IOException;
import java.sql.SQLException;

import fr.inetum.tp.entites.Stagiaire;
import fr.inetum.tp.services.IStagiaireService;
import fr.inetum.tp.services.StagiaireService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IStagiaireService service;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String mdp = request.getParameter("mdp");
		String action = request.getParameter("action");
		
		service = new StagiaireService();
		try {
			Stagiaire  stagiaire = service.getStagiaire(email, mdp);
			
			if(stagiaire != null && stagiaire.getRole().equals("Admin")  ){
				// LE USER EST RECONNU, IL PEUT ACCEDER A LA PAGE liste.jsp			
				response.sendRedirect("liste");
			}
			else if(stagiaire != null && stagiaire.getRole().equals("Other")  ){
				// LE USER EST RECONNU, IL PEUT ACCEDER A LA PAGE liste.jsp			
				response.sendRedirect("liste1");
			}	
			else if (action != null && action.equals("deconnexion")) {
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("login");
			}
			
			else {
				request.getSession().setAttribute("err", "Login et/ou mdp incorrect(s)");
				
				// ICI, LE USER EST REDIRIGER SUR LA PAGE DE LOGIN
				response.sendRedirect("login");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
