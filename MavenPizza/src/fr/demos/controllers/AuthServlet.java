package fr.demos.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.demos.models.Personne;
import fr.demos.services.PersonneService;

/**
 * Servlet implementation class AuthServlet
 */
@WebServlet("/auth")
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonneService personneService = new PersonneService();

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
		HttpSession session = request.getSession();

		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		Personne personne = new Personne(prenom, nom);

		if (personneService.findByNomAndPrenom(nom, prenom)) {
		

			if (personne.getNom().contains("wick")) {
				personne.setType("producteur");
				session.setAttribute("perso", personne);
				response.sendRedirect("pizza/add");
			} else {
				personne.setType("consommateur");
				session.setAttribute("perso", personne);
				response.sendRedirect("pizza/delete");

			}

		} else {
			request.setAttribute("error", "cet utilisateur n'existe pas");
			this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

		}

	}
}