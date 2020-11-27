package fr.demos.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.demos.dao.PersonneDao;
import fr.demos.models.Personne;

/**
 * Servlet implementation class AuthServlet
 */
@WebServlet("/auth")
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonneDao personneDao = new PersonneDao();

	/**
	 * Default constructor.
	 */
	public AuthServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/personne/client.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		Personne personne = personneDao.findByNomAndPrenom(nom, prenom);
		HttpSession session = request.getSession();
		session.setAttribute("perso", personne);
		if (personne != null) {
			if (personne.getType().contains("producteur")) {
				System.out.println("hello");
				response.sendRedirect("pizza/add");
			} else {
				response.sendRedirect("pizza/delete");
			}

		} else {
			request.setAttribute("error", "cet utilisateur n'existe pas");
			this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

		}

	}
}