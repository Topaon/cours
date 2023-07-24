package fr.inetum.tp.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;

import fr.inetum.tp.services.IStagiaireService;
import fr.inetum.tp.services.StagiaireService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteStagiaire")
public class DeleteStagiareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IStagiaireService service;
	
	@Override
	public void init() throws ServletException {
		service = new StagiaireService();
	}
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println(id);
		
		try {
			service.removeStagiaire(id);
		} catch (ClassNotFoundException | SQLException e) {
			List<String> erreurs = new ArrayList<>();		
			if(e instanceof ClassNotFoundException) {
				erreurs.add("Attention, les drivers de la BDD sont introuvables");
			}
			if(e instanceof CommunicationsException) {
				erreurs.add("Le serveur de BDD semble à l'arrêt");
			}
			request.setAttribute("erreurs", erreurs);
		}
		response.sendRedirect("welcome");

	}



}
