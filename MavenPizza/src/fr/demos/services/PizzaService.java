package fr.demos.services;

import java.util.ArrayList;

import fr.demos.models.Pizza;

public class PizzaService {
	ArrayList<Pizza> pizzas = new ArrayList<Pizza>();

	public PizzaService() {
		pizzas.add(new Pizza(1, "italienne", "4 fromages"));
		pizzas.add(new Pizza(2, "française", "savoyarde"));
		pizzas.add(new Pizza(3, "Indienne", "indienne"));
	}

	public ArrayList<Pizza> findAll() {
		return this.pizzas;
	}

	public void removePizza(String nom) {
		for (int i = 0; i < pizzas.size(); i++) {
			if (pizzas.get(i).getNom().equals( nom)) {
				pizzas.remove(pizzas.get(i));
			}
		}
	}

	public void add(String nom, String type) {
		pizzas.add(new Pizza(pizzas.size(), type, nom));

	}

}
