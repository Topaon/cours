package fr.inetum.tp.connexion;

import java.sql.Connection;
import java.sql.SQLException;

	public class MaConnexion {
	
		private static MaConnexion instance;
		private Connection connection;
	
		private MaConnexion() throws ClassNotFoundException, SQLException {
			SimpleDataSource.init("dbParams");
			connection = SimpleDataSource.getConnection();
		}
	
		public static synchronized MaConnexion getInstance() throws ClassNotFoundException, SQLException {
			if (instance == null) {
				instance = new MaConnexion();
			}
			return instance;
		}
	
		public Connection getConnection() {
			return connection;
	}
}