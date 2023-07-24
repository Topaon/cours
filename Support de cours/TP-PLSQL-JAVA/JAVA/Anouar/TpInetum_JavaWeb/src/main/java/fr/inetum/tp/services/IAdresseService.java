package fr.inetum.tp.services;

import java.sql.SQLException;
import java.util.Set;

import fr.inetum.tp.entites.Adresse;

public interface IAdresseService {

	
	Set<Adresse> allAdresse() throws ClassNotFoundException, SQLException;
	Adresse readAdresse(int adresseId);
	Adresse addAdresse(Adresse adresse);
}
