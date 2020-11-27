package fr.demos.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.demos.dao.PizzaDao;
import fr.demos.models.Pizza;

/**
 */
@WebServlet("/pizza/delete")
public class SuppPizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PizzaDao pizzaDao = new PizzaDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SuppPizzaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("affichePizza", pizzaDao.findAll());
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
		Pizza pizza = new Pizza(nom);
		pizzaDao.remove(pizza);;
		HttpSession session = request.getSession();
		session.setAttribute("pizzas", pizzaDao);
		response.sendRedirect("confirmation");
	}

}
