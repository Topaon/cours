package fr.inetum.tp.dao;

import java.sql.SQLException;
import java.util.Set;

import fr.inetum.tp.entites.Adresse;

public interface IAdresseService {

	Set<Adresse> allAdresses() throws ClassNotFoundException, SQLException;
	Adresse readAdresse(int id) throws ClassNotFoundException, SQLException;
	Adresse addAdresse(Adresse adresse) throws ClassNotFoundException, SQLException;
}
