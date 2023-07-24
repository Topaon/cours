package fr.inetum.tp.entites;

import java.sql.Date;

public class Stagiaire {
	private Integer id;
	private String prenom;
	private String email;
	private String mdp;
	private Adresse adresse;
	private Date ddn;
	private String role;
	private int age;
	
	
	// CONSTRUCTEUR
	public Stagiaire() {
		
	}
	public Stagiaire(int id, String prenom, String email, String mdp, Adresse adresse, Date ddn, String role) {
		this.id = id;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
		this.adresse = adresse;
		this.ddn = ddn;
		this.role = role;
	}
	
	
	// GETTERS & SETTERS
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
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
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public Date getDdn() {
		return ddn;
	}
	public void setDdn(Date ddn) {
		this.ddn = ddn;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	// TO STRING
	@Override
	public String toString() {
		return "Stagiaire [id=" + id + ", prenom=" + prenom + ", email=" + email + ", mdp=" + mdp + ", adresse="
				+ adresse + ", ddn=" + ddn + ", role=" + role + "]";
	}
	
	
	
}
