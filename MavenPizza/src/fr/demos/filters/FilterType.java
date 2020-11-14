package fr.demos.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.demos.models.Personne;

/**
 * Servlet Filter implementation class FilterType
 */
@WebFilter("/pizza/*")
public class FilterType implements Filter {

	/**
	 * Default constructor.
	 */
	public FilterType() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		Personne connected = (Personne) session.getAttribute("perso");
		String chemin = req.getServletPath();
		String methode = req.getMethod();
		if (connected.getType().contains("consommateur") && (chemin.equals("/pizza/delete")
				|| chemin.equals("/pizza/confirmation") || chemin.equals("/pizza/delete") && methode.equals("POST"))) {
			chain.doFilter(request, response);
		} else if (connected.getType().contains("producteur") && (chemin.equals("/pizza/add")
				|| chemin.equals("/pizza/confirmation") || chemin.equals("/pizza/add") && methode.equals("POST"))) {
			chain.doFilter(request, response);
		}

		else {
			res.sendRedirect(req.getContextPath());
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
