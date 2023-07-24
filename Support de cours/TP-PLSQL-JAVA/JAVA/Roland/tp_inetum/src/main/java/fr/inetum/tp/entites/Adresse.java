package fr.inetum.tp.entites;

public class Adresse {
	
	private String nomVoie;
	private String codePostal;
	private String ville;
	private int id;
	
	public Adresse(String nomVoie, String codePostal, String ville, int id) {
		this.nomVoie = nomVoie;
		this.codePostal = codePostal;
		this.ville = ville;
		this.id = id;
	}

	public Adresse(String nomVoie, String codePostal, String ville) {
		this(nomVoie, codePostal, ville, 0);
	}
	
	public Adresse() {
		this(null, null, null);
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
