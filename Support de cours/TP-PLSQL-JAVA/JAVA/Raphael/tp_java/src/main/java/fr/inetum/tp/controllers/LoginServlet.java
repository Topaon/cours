package fr.inetum.tp.controllers;

import java.io.IOException;
import java.sql.SQLException;

import fr.inetum.tp.dao.IStagiaireService;
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
		try {
			service = new StagiaireService();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String email = request.getParameter("email");
//		String mdp = request.getParameter("mdp");
//		
//		try {
//			if(service.getStagiaire(email, mdp) != null ) {
//				
//				Stagiaire stagiaireCo = new Stagiaire();
//				request.getSession().setAttribute("stagiaireCo",stagiaireCo);
//				
//				System.out.println("co");
//				
//				response.sendRedirect("liste");
//				
//			}
//		} catch (ClassNotFoundException | SQLException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("catch");
//				
//				response.sendRedirect("login");
//			
//		}
		
	}

}
