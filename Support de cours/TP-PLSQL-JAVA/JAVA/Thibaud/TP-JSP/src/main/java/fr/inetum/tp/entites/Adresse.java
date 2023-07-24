package fr.inetum.tp.entites;

public class Adresse {

	// DECLARATION ATTRIBUTS
	private Integer id;
	private String nomVoie;
	private String codePostal;
	private String ville;
	
	// CONSTRUCTEURS
	public Adresse(Integer id, String nomVoie, String codePostal, String ville) {
		this.id = id;
		this.nomVoie = nomVoie;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public Adresse(String nomVoie, String codePostal, String ville) {
		super();
		this.nomVoie = nomVoie;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public Adresse(Integer id) {
		this.id = id;
	}

	public Adresse() {
		super();
	}

	// GETTERS & SETTERS
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
		
}
