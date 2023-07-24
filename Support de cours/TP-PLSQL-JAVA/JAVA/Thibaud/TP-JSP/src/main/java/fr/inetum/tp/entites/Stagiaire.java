package fr.inetum.tp.entites;

import java.time.LocalDate;

public class Stagiaire {
	
	// DECLARATION DES ATTRIBUTS
	private Integer id;
	private String prenom;
	private String email;
	private String mdp;
	private Adresse adresseID;
	private LocalDate ddn;
	private String role;
	
	// CONSTRUCTEURS
	public Stagiaire(Integer id, String prenom, String email, String mdp, Adresse adresseID, LocalDate ddn,
			String role) {
		this.id = id;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
		this.adresseID = adresseID;
		this.ddn = ddn;
		this.role = role;
	}
	
	public Stagiaire(String prenom, String email, String mdp, Adresse adresseID, LocalDate ddn, String role) {
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
		this.adresseID = adresseID;
		this.ddn = ddn;
		this.role = role;
	}	

	public Stagiaire() {
	}

	//GETTERS & SETTERS
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Adresse getAdresseID() {
		return adresseID;
	}

	public void setAdresseID(Adresse adresseID) {
		this.adresseID = adresseID;
	}

	public LocalDate getDdn() {
		return ddn;
	}

	public void setDdn(LocalDate ddn) {
		this.ddn = ddn;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
