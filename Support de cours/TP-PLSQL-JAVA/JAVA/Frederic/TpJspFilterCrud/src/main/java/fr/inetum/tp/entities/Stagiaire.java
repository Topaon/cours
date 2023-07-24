package fr.inetum.tp.entities;

import java.time.LocalDate;

public class Stagiaire {
	
	private Integer id;
	private String prenom;
	private String email;
	private String mdp;
	private Adresse adresse;
	private LocalDate ddn;
	private String role;
	private Integer age;
	
	
	public Stagiaire(Integer id, String prenom, String email, String mdp, Adresse adresse, LocalDate ddn,
			String role) {
		this.id = id;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
		this.adresse = adresse;
		this.ddn = ddn;
		this.role = role;
	};
	
	public Stagiaire(String prenom, String email, String mdp, Adresse adresse, LocalDate ddn,
			String role) {
		this(0, prenom, email, mdp, adresse, ddn, role);
	};
	
	public Stagiaire() {
		this(null, null, null, null, null, null);
	}


	@Override
	public String toString() {
		return "Stagiaire test [id=" + id + ", prenom=" + prenom + ", email=" + email + ", mdp=" + mdp + ", adresseId="
				+ adresse + ", ddn=" + ddn + ", role=" + role + "]";
	}

	public Integer getId() {
		return id;
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

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
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
	
	public Integer getAge() {
		age = ddn.until(LocalDate.now()).getYears();
		return age;
	}	
	
}
