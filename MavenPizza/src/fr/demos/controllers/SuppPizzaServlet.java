package fr.demos.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.demos.services.PizzaService;

/**
 * Servlet implementation class SuppPiizServlet
 */
@WebServlet("/pizza/supp")
public class SuppPizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PizzaService  pizzaService = new PizzaService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuppPizzaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("pizzas", pizzaService.findAll());
		this.getServletContext().getRequestDispatcher("/WEB-INF/personne/client.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom = request.getParameter("nom");
		pizzaService.remove(nom);
	
	}

}
