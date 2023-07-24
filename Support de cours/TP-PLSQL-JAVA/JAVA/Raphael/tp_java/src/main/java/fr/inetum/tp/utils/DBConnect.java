package fr.inetum.tp.utils;

import java.sql.Connection;
import java.sql.SQLException;



public class DBConnect {

	private static DBConnect instance;
	private Connection connection;
	

	private DBConnect() throws ClassNotFoundException, SQLException {
		DataSource.init("db");
		connection = DataSource.getConnection();
	}


	public static synchronized DBConnect getInstance() throws ClassNotFoundException, SQLException {
		if (instance == null) {
			instance = new DBConnect();
		}
		return instance;
	}
	
	public Connection getConnection() {
		return connection;
	}
	
}
