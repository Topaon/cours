package fr.inetum.tp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class SimpleDataSource {
	
	static String driver;
	static String url;
	static String user;
	static String password;
	
	
	public static void init (String nomFichier) throws ClassNotFoundException  {
		
		ResourceBundle props = ResourceBundle.getBundle(nomFichier);
		
		driver = props.getString("mysql.driver");
		Class.forName(driver);
		
		url = props.getString("mysql.url");
		user = props.getString("mysql.user");
		password = props.getString("mysql.password");

	}
	
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
	
}
