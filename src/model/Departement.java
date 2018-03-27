package model;

import java.util.Date;

public class Departement {
	String nom;
	Date dateCreation;
	String adresse;
	String telephone;
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Date getDatecreation() {
		return dateCreation;
	}
	public void setDatecreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
}
