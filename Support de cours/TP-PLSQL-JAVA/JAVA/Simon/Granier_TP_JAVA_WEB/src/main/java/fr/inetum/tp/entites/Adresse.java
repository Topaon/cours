package fr.inetum.tp.entites;

public class Adresse {
	private int id;
	private String nomVoie;
	private String codePostal;
	private String ville;
	
	
	// CONSTRUCTEURS	
	public Adresse() {

	}
	public Adresse(int id, String nomVoie, String codePostal, String ville) {
		this.id = id;
		this.nomVoie = nomVoie;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	
	
	// GETTERS & SETTERS
	public Integer getId() {
		return id;
	}

	public void setId(int id) {
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
	
	
	// TO STRING
	@Override
	public String toString() {
		return "Adresse [id=" + id + ", nomVoie=" + nomVoie + ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}
}
