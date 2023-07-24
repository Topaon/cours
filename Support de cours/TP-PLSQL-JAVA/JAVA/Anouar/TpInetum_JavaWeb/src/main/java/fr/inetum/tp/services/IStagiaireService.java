package fr.inetum.tp.services;

import java.sql.SQLException;
import java.util.Set;

import fr.inetum.tp.entites.Adresse;
import fr.inetum.tp.entites.Stagiaire;

public interface IStagiaireService {

	Set<Stagiaire> allStagiaires() throws ClassNotFoundException, SQLException ;
	
	Set<Stagiaire>  allStagiaires( Adresse adresse) throws SQLException, ClassNotFoundException;
	void removeStagiaire(Stagiaire stagiaire) throws ClassNotFoundException, SQLException;
	void addStagiaire(Stagiaire stagiaire, Adresse adresse) throws ClassNotFoundException, SQLException;
	Stagiaire  getStagiaire(String email,String mdp) throws ClassNotFoundException, SQLException;
	Stagiaire  getStagiaire(Integer id) throws ClassNotFoundException, SQLException;
}
