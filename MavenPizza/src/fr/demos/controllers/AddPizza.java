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
 * Servlet implementation class AddPizza
 */
@WebServlet("/pizza/add")
public class AddPizza extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PizzaDao pizzaDao = new PizzaDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPizza() {
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
		this.getServletContext().getRequestDispatcher("/WEB-INF/personne/producteur.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String type = request.getParameter("type");
	Pizza pizza = new Pizza(type, nom);
		pizzaDao.save(pizza);
		HttpSession session = request.getSession();
		session.setAttribute("pizzas", pizzaDao);
		response.sendRedirect("confirmation");
	}

}
