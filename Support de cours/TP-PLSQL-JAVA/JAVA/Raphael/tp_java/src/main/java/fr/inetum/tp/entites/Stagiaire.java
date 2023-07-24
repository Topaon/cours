package fr.inetum.tp.entites;

import java.time.LocalDate;

public class Stagiaire {
	
	// Attributs
	
	private Integer id;
	private String prenom;
	private String email;
	private String mdp;
	private Adresse adresseId;
	private LocalDate ddn;
	private String role;
	
	
	// Constructeurs
	
	public Stagiaire(Integer id, String prenom, String email, String mdp, Adresse adresseId, LocalDate ddn,
			String role) {
		this.id = id;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
		this.adresseId = adresseId;
		this.ddn = ddn;
		this.role = role;
	}

	public Stagiaire(String prenom, String email, String mdp, LocalDate ddn, Adresse adresseId, String role) {
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
		this.adresseId = adresseId;
		this.ddn = ddn;
		this.role = role;
	}

	public Stagiaire() {
		
	}

	// Getters et Setters



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


	public Adresse getAdresseId() {
		return adresseId;
	}


	public void setAdresseId(Adresse adresseId) {
		this.adresseId = adresseId;
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

	// Methodes additionnelles 
	
	@Override
	public String toString() {
		return "Stagiaire [id=" + id + ", prenom=" + prenom + ", email=" + email + ", mdp=" + mdp + ", adresseId="
				+ adresseId + ", ddn=" + ddn + ", role=" + role + "]";
	}
	
	
	
	
	
	
	
	

}
