package fr.inetum.tp.servlets;

import java.io.IOException;
import java.sql.SQLException;

import fr.inetum.tp.entites.Stagiaire;
import fr.inetum.tp.interfaces.IStagiaireService;
import fr.inetum.tp.services.StagiaireService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private IStagiaireService service;
	private static final long serialVersionUID = 1L;

    public void init() {
    	try {
			service = new StagiaireService();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
		System.out.println("Je suis dans la méthode doGet de la servlet LOGIN");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String mdp = request.getParameter("mdp");
		try {
			service = new StagiaireService();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("le stagiaire");
			e.printStackTrace();
		}
		

			Stagiaire  stagiaire = service.getStagiaire(email, mdp);
			
			if(stagiaire != null && stagiaire.getRole().equals("Admin")){
				// LE USER EST RECONNU, IL PEUT ACCEDER A LA PAGE liste.jsp			
				System.out.println("Stagiaire role Admin reconnu");
				response.sendRedirect("liste");
			}else if(stagiaire != null && stagiaire.getRole().equals("Other")){
				System.out.println("stagiare autre role");
				request.getSession().setAttribute("erreur", "Login et/ou mdp incorrect(s)");
				// ICI, LE USER EST REDIRIGER SUR LA PAGE DE LOGIN
				response.sendRedirect("login");
			}
		doGet(request, response);
		
	}
}
