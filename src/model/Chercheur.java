package model;

public class Chercheur {

	String matricule;
	String prenom;
	String nom;
	String position;
	Equipe equipe;
	Integer salaire;
	
	
	
	public String getMatricule() {
		return matricule;
	}



	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPosition() {
		return position;
	}



	public void setPosition(String position) {
		this.position = position;
	}



	public Equipe getEquipe() {
		return equipe;
	}



	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}



	public Integer getSalaire() {
		return salaire;
	}



	public void setSalaire(Integer salaire) {
		this.salaire = salaire;
	}



	public String toString() {
		return this.matricule;
	}
	
}
