package fr.inetum.tp.jdbc.utils;

import java.sql.Connection;
import java.sql.SQLException;

// Classe pour tester la connexion
public class TestMaConnexion {

    public static void main(String[] args) {
	try (Connection connection = MaConnexion.getInstance().getConnection()) {
	    System.out.println("Test MaConnexion OK");
	} catch (ClassNotFoundException | SQLException e) {
	    System.out.println("Test MaConnexion NON-OK : " + e.getMessage());
	}
    }

}
