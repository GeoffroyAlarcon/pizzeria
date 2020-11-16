package fr.demos.services;

import java.util.ArrayList;

import fr.demos.models.Personne;

public class PersonneService {
	private ArrayList<Personne> personnes = new ArrayList<Personne>();

	public PersonneService() {
		personnes.add(new Personne(1, "john", "wick", "producteur"));
		personnes.add(new Personne(2, "Joe", "dalton", "consommateur"));
		personnes.add(new Personne(2, "mitro", "glou", "consommateur"));
}
	
	public Personne findByNomAndPrenom(String nom, String prenom) {
		for (int i = 0; i < personnes.size(); i++) {
			if (personnes.get(i).getNom().equals(nom) && personnes.get(i).getPrenom().equals(prenom)) {
			return personnes.get(i);
			} ;
		}
		return null;
	}
}
