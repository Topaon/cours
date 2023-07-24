package fr.inetum.tp.entites;

public class Adresse {
	
	// Attributs

	private Integer id;
	private String nomVoie;
	private String codePostal;
	private String ville;
	
	// Constructeurs
	
	public Adresse() {
	}

	public Adresse(Integer id) {
		this.id =id;
	}


	public Adresse(Integer id, String nomVoie, String codePostal, String ville) {
		this.id = id;
		this.nomVoie = nomVoie;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	
	public Adresse(String nomVoie, String codePostal, String ville) {
		this.nomVoie = nomVoie;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	
	// Getters et Setters

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNomVoie() {
		return nomVoie;
	}


	public void setNomVoie(String nomVoie) {
		this.nomVoie = nomVoie;
	}


	public String getCodePostal() {
		return codePostal;
	}


	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}

	
	// Methodes additionnelles 

	@Override
	public String toString() {
		return "Adresse [id=" + id + ", nomVoie=" + nomVoie + ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}
	
	
	
	
}
