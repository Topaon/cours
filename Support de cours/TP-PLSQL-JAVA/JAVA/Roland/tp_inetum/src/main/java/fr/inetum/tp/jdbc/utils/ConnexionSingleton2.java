package fr.inetum.tp.jdbc.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnexionSingleton2 {
	private static ConnexionSingleton2 instance;
	private Connection connection;

	private ConnexionSingleton2() throws ClassNotFoundException, SQLException {
		DataSource.init("dbParams_tp-inetum2");
		connection = DataSource.getConnection();
	}

	public static synchronized ConnexionSingleton2 getInstance() throws ClassNotFoundException, SQLException {
		if (instance == null) {
			instance = new ConnexionSingleton2();
		}
		return instance;
	}
	
	public Connection getConnection() {
		return connection;
	}
}
