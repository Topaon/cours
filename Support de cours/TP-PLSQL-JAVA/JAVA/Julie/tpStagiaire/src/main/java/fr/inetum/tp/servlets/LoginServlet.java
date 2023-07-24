package fr.inetum.tp.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import fr.inetum.tp.entities.Stagiaire;
import fr.inetum.tp.jdbc.utils.MaConnexion;
import fr.inetum.tp.services.IStagiaireService;
import fr.inetum.tp.services.impl.StagiaireService;
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
		try {
			service = new StagiaireService();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message;
		
		// Récupération des champs envoyés par le formulaire
		String email = request.getParameter("email");
		String password = request.getParameter("mdp");
		
		try {
			//  Vérification de la valeur des champs 
			// si vide/s
			if(email.isBlank() || password.trim().isEmpty()) {
				message = "Vous n'avez pas remplis tous les champs !";
				request.setAttribute("message", message);
				//System.out.println("message vide: " + message);
				this.getServletContext();
				doGet(request, response);			
			}
			else {
				//if (email.equalsIgnoreCase("julie@inetum.fr") && password.equals("1234")) {
				//if (email.equalsIgnoreCase("theo@inetum.fr") && password.equals("1234")) {
				Stagiaire user = service.getStagiaire(email, password);
				message= "";
				
				// si message d'erreur et que c'est mauvais email et ou mdp
				if (user == null) {
						message = "Login et/ou mot de passe incorrect(s)";
						request.setAttribute("message", message);
						email = request.getParameter("email");
						password = request.getParameter("password");
						request.setAttribute("email", email);
						request.setAttribute("mdp", password);
						//System.out.println("message user null: "+ message);
						this.getServletContext(); 
						doGet(request, response);
						
				} else { 
					// Le user est reconnu en bdd, il peut accéder à la page liste.jsp
					if (email.equalsIgnoreCase(user.getEmail()) && password.equals(user.getMdp())) {
						try {
							Connection connection = MaConnexion.getInstance().getConnection();
							service = new StagiaireService(connection);
							if (user != null) {
								request.getSession().setAttribute("user", user);
								request.getSession().setAttribute("role", user.getRole());
								//System.out.println("role user: " + user.getRole());
							}
						} catch (ClassNotFoundException | SQLException e) {
							e.printStackTrace();
						}
						response.sendRedirect("liste");
					}				
				} 
			}
			//System.out.println("message doPost : "+ message);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(String.format("Email : %s && Mdp: %s", email, password));
	}

}
