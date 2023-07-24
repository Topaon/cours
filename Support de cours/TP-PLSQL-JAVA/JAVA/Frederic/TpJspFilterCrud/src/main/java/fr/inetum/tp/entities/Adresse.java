package fr.inetum.tp.entities;


public class Adresse {
	private Integer id;
	private String nomVoie;
	private String codePostal;
	private String ville;
	
	
	public Adresse(Integer id, String nomVoie, String codePostal, String ville) {
		this.id = id;
		this.nomVoie = nomVoie;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	
	public Adresse(String nomVoie, String codePostal, String ville) {
		this(0, nomVoie, codePostal, ville);
	};
	
	public Adresse() {
		this(null, null, null, null);
	}


	@Override
	public String toString() {
		return "Adresse [id=" + id + "nomVoie=" + nomVoie + ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}
	
	public Integer getId() {
		return id;
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
	

}
