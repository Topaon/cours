package fr.inetum.tp.services;

import java.sql.SQLException;
import java.util.List;

import fr.inetum.tp.entities.Adresse;
import fr.inetum.tp.entities.Stagiaire;

public interface IStagiaireService {
	
	
	List<Stagiaire> allStagiaires() throws ClassNotFoundException, SQLException;
	// retourne la liste des stagiaires de la table stagiaire.

	List<Stagiaire> allStagiaires(Adresse adresse) throws ClassNotFoundException, SQLException;
	// retourne la liste des stagiaires résidant à l’adresse passée en argument.
	
	public void removeStagiaire (String id) throws ClassNotFoundException, SQLException;
	// Permet de supprimer de la table stagiaire, le stagiaire passé en paramètre.
	
	public void addStagiaire(Stagiaire stagiaire, Adresse adresse) throws ClassNotFoundException, SQLException;
	// Persiste le stagiaire passé en paramètre en base de données.

	public Stagiaire getStagiaire(String login, String mdp) throws ClassNotFoundException, SQLException;
	// Permet de retourner le stagiaire de la table stagiaire, dont les login et mot de passe sont passées en argument de la méthode.
	
	public void getStagiaire(Integer id) throws ClassNotFoundException, SQLException;
	//Recherche un stagiaire à partir de son identifiant passé en paramètre.

	
}
