package model;

import java.util.Date;

public class Equipe {

	String nom;
	Date dateCreation;
	Departement departement;
	String responsable;
	int nbrProjets;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	public int getNbrProjets() {
		return nbrProjets;
	}
	public void setNbrProjets(int nbrProjets) {
		this.nbrProjets = nbrProjets;
	}
	
	
	
	
}
