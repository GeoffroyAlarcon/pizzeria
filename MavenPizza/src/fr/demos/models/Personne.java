package fr.demos.models;

public class Personne {
	private int id;
	private String nom;
	private String prenom;
	private String type;

	public Personne(int id,  String prenom,String nom, String type) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.type = type;
	}

	public Personne( String prenom, String nom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public Personne() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}