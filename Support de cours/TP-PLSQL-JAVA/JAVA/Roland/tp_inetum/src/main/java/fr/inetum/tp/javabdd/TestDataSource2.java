package fr.inetum.tp.javabdd;

import java.sql.Connection;
import java.sql.SQLException;

import fr.inetum.tp.jdbc.utils.DataSource;

public class TestDataSource2 {
	public static void main(String[] args) {
		try {
			DataSource.init("dbParams_tp-inetum2");
			System.out.println("DRIVER OK");
			
			try(Connection connection = DataSource.getConnection()){
				System.out.println("CONNEXION OK");				
			} catch (SQLException e) {
				System.out.println("CONNEXION NOK");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("DRIVER NOK");
		}
	}
}
