package fr.inetum.tp.filters;

import java.io.IOException;

import fr.inetum.tp.entities.Stagiaire;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/welcome")
public class RoleFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Je suis dans le filtre MyFilter");
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		Stagiaire stagiaire =  (Stagiaire) httpRequest.getSession().getAttribute("stagiaire");
		String role = request.getParameter("role");

		if (stagiaire == null && role != "admin") {
			httpResponse.sendRedirect("login");
		}

		else {
			request.setAttribute("stagiaireRole", stagiaire.getRole());
			chain.doFilter(request,response);	
		}
	}
}