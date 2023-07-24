package fr.inetum.tp.services;

import java.sql.SQLException;
import java.util.Set;

import fr.inetum.tp.entities.Adresse;
import fr.inetum.tp.entities.Stagiaire;

public interface IStagiaireService {

	/**
	 * Liste de l'ensemble des stagiaires en base de données
	 * 
	 * @return la liste des stagiaires de la table stagiaire
	 * @throws SQLException Si un problème SQL est détecté
	 */
	Set<Stagiaire> allStagiaire() throws SQLException;

	/**
	 * Liste des stagiaires résidant à une adresse
	 * 
	 * @param adresse par l'adresse de recherche 
	 * @return la liste des stagiaires résidant à l'adresse passée en argument
	 * @throws SQLException Si un problème SQL est détecté
	 */
	Set<Stagiaire> allStagiaire(Adresse adresse) throws SQLException;

	/**
	 * Recherche d'un stagiaire par son identifiant
	 * 
	 * @param id l'identifiant du stagiaire à rechercher
	 * @return le stagiaire recherché par son identifiant, null si non trouvé
	 * @throws SQLException Si un problème SQL est détecté
	 */
	Stagiaire getStagiaire(Integer id) throws SQLException;

	/**
	 * Ajoute le stagiaire passé en paramètre en base de données
	 * 
	 * @param stagiaire le stagiaire à persister
	 * @param adresse   l'adresse du stagiaire à persister
	 * @throws SQLException Si un problème SQL est détecté
	 */
	void addStagiaire(Stagiaire stagiaire, Adresse adresse) throws SQLException;

	/**
	 * Modifie le stagiaire passé en paramètre en base de données
	 * 
	 * @param stagiaire le stagiaire à modifier
	 * @param adresse   l'adresse du stagiaire à modifier
	 * @return le stagiaire avec ses informations modifiées
	 * @throws SQLException Si un problème SQL est détecté
	 */
	Stagiaire updateStagiaire(Stagiaire stagiaire, Adresse adresse) throws SQLException;

	/**
	 * Supprime le stagiaire passé en paramètre en base de données
	 * 
	 * @param stagiaire le stagiaire à supprimer
	 * @throws SQLException Si un problème SQL est détecté
	 */
	void removeStagiaire(Stagiaire stagiaire) throws SQLException;

	/**
	 * Permets d'avoir le stagiaire de la base de données
	 * 
	 * @param login le login du stagiaire
	 * @param mdp   le mot de passe du stagiaire
	 * @return le stagiaire de la table stagiaire
	 * @throws SQLException Si un problème SQL est détecté
	 */
	Stagiaire getStagiaire(String login, String mdp) throws SQLException;

}
