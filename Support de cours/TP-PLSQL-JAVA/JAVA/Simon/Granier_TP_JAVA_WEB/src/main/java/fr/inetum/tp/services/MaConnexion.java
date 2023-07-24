package fr.inetum.tp.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MaConnexion {
	private static MaConnexion instance;
	private Connection con;
	
	String driver;
	String url;
	String user;
	String password;
	
	private MaConnexion() {
		try {
			this.init("JDBC_Ressources");
			System.out.println("Connexion initialisée");
		} catch (ClassNotFoundException e) {
			System.out.println("Echec de la connexion");
		}
	}
	
	/**
	 * Crée une instance de la classe Connexion s'il n'en existe pas déjà une
	 * @return Renvoie null s'il existe déjà une instance, sinon créé une instance et la renvoie
	 */
	static public MaConnexion getInstance() {
		if(instance == null) {
			instance = new MaConnexion();
		}
		return instance;
	}
	
	/**
	 * 
	 * Initialiser les paramètres de connexion à une base de données
	 * 
	 * @param nomFicherProperties Le nom du fichier .properties contenant les informations de connexion à la basse de données
	 * @throws ClassNotFoundException Si la méthode forName ne trouve pas le driver passé en paramètre
	 * 
	 */
	public void init(String nomFicherProperties) throws ClassNotFoundException {
		ResourceBundle res = ResourceBundle.getBundle(nomFicherProperties);
		driver = res.getString("mysql.driver");
		url = res.getString("mysql.url");
		user = res.getString("mysql.user");
		password = res.getString("mysql.password");
		
		Class.forName(driver);
		System.out.println("Driver ok");
	}

	public void init(String driver, String url, String user, String password) throws ClassNotFoundException {
		
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.password = password;
		
		Class.forName(driver);
		System.out.println("Driver ok");
	}
	
	/**
	 * Permet une connexion à la base de donnée une fois les paramètres chargé avec init()
	 * @return la connexion java.sql
	 * @throws SQLException S'il y a un problème de connexion à la BDD
	 */
	public Connection getConnection() {
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
