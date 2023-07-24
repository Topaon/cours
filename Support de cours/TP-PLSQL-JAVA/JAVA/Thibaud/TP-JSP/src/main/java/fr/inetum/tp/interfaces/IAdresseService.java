package fr.inetum.tp.interfaces;

import java.sql.SQLException;
import java.util.Set;

import fr.inetum.tp.entites.Adresse;

public interface IAdresseService {

	// Liste de tous les adresses
	Set<Adresse> allAdresses() throws ClassNotFoundException,SQLException;
	
	// Ajoute l'adresse passée en paramètre
	void addAdresses(Adresse adresse) throws ClassNotFoundException,SQLException;
	
	// Renvoi l'adresse dont l'ID est placé en paramètre
	Adresse readAdresses(Integer id) throws ClassNotFoundException, SQLException;
	
}
