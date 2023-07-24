package fr.inetum.tp.jdbc.utils;

import java.sql.Connection;
import java.sql.SQLException;


public class ConnexionSingleton {
	
	private static ConnexionSingleton instance;
	private Connection connection;

	private ConnexionSingleton() throws ClassNotFoundException, SQLException {
		DataSource.init("dbParams_tp-inetum");
		connection = DataSource.getConnection();
	}

	/**
	 * Permet de recuperer l'instance unique de la classe
	 * 
	 * @return L'unique instance de la classe
	 * @throws ClassNotFoundException Si le driver de la BDD est introuvable
	 * @throws SQLException           Si un probleme de connexion SQL survient
	 */
	public static synchronized ConnexionSingleton getInstance() throws ClassNotFoundException, SQLException {
		if (instance == null) {
			instance = new ConnexionSingleton();
		}
		return instance;
	}

	/**
	 * Permet de recuperer un connexion java.sql
	 * 
	 * @return La connexion java.sql
	 */
	public Connection getConnection() {
		return connection;
	}
}
