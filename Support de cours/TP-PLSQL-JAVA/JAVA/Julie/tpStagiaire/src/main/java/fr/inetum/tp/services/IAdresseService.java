package fr.inetum.tp.services;

import java.sql.SQLException;
import java.util.Set;

import fr.inetum.tp.entities.Adresse;

public interface IAdresseService {

	/**
	 * Liste l'ensemble des adresses en base de données
	 * 
	 * @return la liste des adresses de la table adresse
	 * @throws SQLException Si un problème SQL est détecté
	 */
	Set<Adresse> allAdresses() throws SQLException;

	/**
	 * Donne l'adresse dont l'id est passé en paramètre.
	 * 
	 * @param adresseId l'id de l'adresse
	 * @return l'adresse par l'id
	 * @throws SQLException Si un problème SQL est détecté
	 */
	Adresse readAdresses(Integer adresseId) throws SQLException;

	/**
	 * Ajoute une adresse en base de données
	 * 
	 * @param adresse l'adresse à persister en base de données
	 * @return l'adresse persistée
	 * @throws SQLException Si un problème SQL est détecté
	 */
	Adresse addAdresses(Adresse adresse) throws SQLException;
}
