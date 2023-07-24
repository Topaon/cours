package fr.inetum.tp.entites;

public class Adresse extends Stagiaire {
	
	private String nomVoie;
	private String codePostal;
	private String ville;
	private Integer id;
	
	
	
	
	@Override
	public String toString() {
		return "Adresse [nomVoie=" + nomVoie + ", codePostal=" + codePostal + ", ville=" + ville + ", id=" + id + "]";
	}
	public Adresse(String nomVoie, String codePostal, String ville, Integer id) {
		super();
		this.nomVoie = nomVoie;
		this.codePostal = codePostal;
		this.ville = ville;
		this.id = id;
	}
	public Adresse() {

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
	
	


	
