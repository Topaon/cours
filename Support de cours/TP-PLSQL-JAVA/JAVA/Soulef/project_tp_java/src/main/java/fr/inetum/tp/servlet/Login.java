package fr.inetum.tp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import fr.inetum.tp.entites.Stagiaire;
import fr.inetum.tp.services.IStagiaireService;
import fr.inetum.tp.services.StagiaireService;
import fr.inetum.tp.utils.MaConnexion;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IStagiaireService service;
    
    @Override
    public void init() throws ServletException {
    	service = new StagiaireService();
    }
    

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email= req.getParameter("email");
		String mdp= req.getParameter("mdp");
	
		
						if((email != null) && email.equals("soulef@inetum.fr") && mdp.equals("123")) {
														
							try {
								
								   
								
								Set<Stagiaire> stagiaires= new HashSet<>();
								stagiaires = service.AllStagiaireJoin();
								req.setAttribute("stagiaires", stagiaires);
								//System.out.println("stagiaire "+ stagiaires.toString());
								 /*Boucle For Avancée*/
								 /*System.out.println("Boucle for avancée");
								 for(Stagiaire stag : stagiaires)
								 System.out.println(stag);*/
								
								req.getRequestDispatcher("WEB-INF/Pages/listeStagiaire.jsp").forward(req, resp);
								
								
							} catch (ClassNotFoundException | SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							
						}else {
							req.getRequestDispatcher("WEB-INF/Pages/login.jsp").forward(req, resp);
						
						}
							
	}
}

