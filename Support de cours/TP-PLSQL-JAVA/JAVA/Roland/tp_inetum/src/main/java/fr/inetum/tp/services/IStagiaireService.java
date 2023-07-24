package fr.inetum.tp.services;

import java.sql.SQLException;
import java.util.Set;

import fr.inetum.tp.entites.Stagiaire;

public interface IStagiaireService {

	Set<Stagiaire> allStagiaire() throws ClassNotFoundException, SQLException;
	Set<Stagiaire> allStagiaire(Stagiaire adresse) throws ClassNotFoundException, SQLException;	
	void RemoveStagiaire(Stagiaire stagiaire) throws ClassNotFoundException, SQLException;
	void addStagiaire(Stagiaire stagiaire, Stagiaire adresse) throws ClassNotFoundException, SQLException;
	Stagiaire getStagiaire(Stagiaire prenom, Stagiaire email) throws ClassNotFoundException, SQLException;
	Stagiaire getStagiaire(Stagiaire id) throws ClassNotFoundException, SQLException;
}
