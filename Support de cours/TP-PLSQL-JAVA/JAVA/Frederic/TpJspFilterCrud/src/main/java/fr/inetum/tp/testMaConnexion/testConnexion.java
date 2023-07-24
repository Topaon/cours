package fr.inetum.tp.testMaConnexion;

import java.sql.Connection;
import java.sql.SQLException;

import fr.inetum.tp.utils.MaConnexion;


public class testConnexion {
	
	public static void main(String[] args) {
		try (Connection connection = MaConnexion.getInstance().getConnection()) {
			System.out.println("TEST Ma Connexion OK");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("TEST Ma Connexion KO");
		} 
	}

}
