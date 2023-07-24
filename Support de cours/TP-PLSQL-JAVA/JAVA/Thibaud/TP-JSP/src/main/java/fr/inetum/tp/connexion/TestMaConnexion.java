package fr.inetum.tp.connexion;

import java.sql.Connection;
import java.sql.SQLException;

public class TestMaConnexion {

	public static void main(String[] args) {
		try (Connection connection = MaConnexion.getInstance().getConnection()){
			System.out.println("Test MaConnexion OK");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Test MaConnexion NOK : " + e.getMessage());
		}
	}
}
