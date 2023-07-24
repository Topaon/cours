package fr.inetum.tp.entites;

import java.time.LocalDate;

public class Stagiaire {
	
	private String prenom;
	private String email;
	private String mdp;
	private Integer adresseId;
	private LocalDate ddn;
	private Integer role;	
	private int id;
	
	public Stagiaire(String prenom, String email, String mdp, Integer adresseId, LocalDate ddn, Integer role, int id) {
		super();
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
		this.adresseId = adresseId;
		this.ddn = ddn;
		this.role = role;
		this.id = id;
	}
	
	public Stagiaire(String prenom, String email, String mdp, Integer adresseId, LocalDate ddn, Integer role) {
		this(prenom, email, mdp, adresseId, ddn, role, 0);
	}
	
	public Stagiaire() {
		this(null, null, null, null, null, null);
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
	
	public int getAdresseId() {
		return adresseId;
	}
	
	public void setAdresseId(int adresseId) {
		this.adresseId = adresseId;
	}
	
	public LocalDate getDdn() {
		return ddn;
	}
	
	public void setDdn(LocalDate ddn) {
		this.ddn = ddn;
	}
	
	public Integer getRole() {
		return role;
	}
	
	public void setRole(Integer role) {
		this.role = role;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

}
