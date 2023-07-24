package fr.inetum.tp.filters;


	import java.io.IOException;

	import jakarta.servlet.Filter;
	import jakarta.servlet.FilterChain;
	import jakarta.servlet.ServletException;
	import jakarta.servlet.ServletRequest;
	import jakarta.servlet.ServletResponse;
	import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

	@WebFilter("/login?email=soulef%40inetum.fr&mdp=123&submit=")
	public class MonFiltre implements Filter{

		@Override
		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
				throws IOException, ServletException {
			System.out.println("Je suis de le filtre MonFiltre");
			
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse res = (HttpServletResponse) response;
				
			
			HttpSession session = req.getSession();
			
		
			String testRole = (String) session.getAttribute("stagiaire.role");
			System.out.println(" TEST "+ testRole);
			if(testRole == "admin") {
				// TOUT EST OK POUR LAISSER PASSER LA REQUETE
				
				System.out.println(" OK COOL");
				chain.doFilter(request, response);
			}		
		}
	}
