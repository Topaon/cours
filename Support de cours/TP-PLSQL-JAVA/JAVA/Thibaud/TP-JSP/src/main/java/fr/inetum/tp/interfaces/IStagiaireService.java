package fr.inetum.tp.interfaces;

import java.sql.SQLException;
import java.util.Set;

import fr.inetum.tp.entites.Adresse;
import fr.inetum.tp.entites.Stagiaire;

public interface IStagiaireService {

	// Liste de tous les stagiaires
	Set<Stagiaire> allStagiaires() throws SQLException, ClassNotFoundException;
	
	// Liste des stagiaires avec adresse en paramètre
	Set<Stagiaire> allStagiaires(Adresse adresse) throws SQLException, ClassNotFoundException;
	
	// Ajoute stagiaire en BDD
	void addStagiaire(Stagiaire stagiaire) throws ClassNotFoundException, SQLException;
	
	// Supprime stagiaire
	void removeStagiaire(Stagiaire stagiaire) throws ClassNotFoundException, SQLException;
	
	// Supprime stagiaire avec ID en paramètre
	void removeStagiaire(int ID) throws SQLException;
	
	// Recherche stagiaire en fonction des logins renseignés
	Stagiaire getStagiaire(String email, String mdp);
	
	// Recherche stagiaire en fonction de l'ID renseigné
	Stagiaire getStagiaire(int ID) throws SQLException;
	
	
}
