package fr.inetum.tp.services;

import java.sql.SQLException;
import java.util.List;

import fr.inetum.tp.entities.Adresse;

public interface IAdresseService {
	
	List<Adresse> allAdresses() throws ClassNotFoundException, SQLException;
	// retourne la liste des adresses de la table Adresse.
	
	public Adresse readAdresse (int adresseId) throws ClassNotFoundException, SQLException;
	// retourne l’adresse don l’id est passée en paramètres

	public void addAdresse (Adresse adresse) throws ClassNotFoundException, SQLException;
	// Persiste l’adresse passé en paramètre en base de données
	
}
