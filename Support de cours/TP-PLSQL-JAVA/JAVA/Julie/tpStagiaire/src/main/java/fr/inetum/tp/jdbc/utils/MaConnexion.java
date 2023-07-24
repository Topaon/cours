package fr.inetum.tp.jdbc.utils;

import java.sql.Connection;
import java.sql.SQLException;

//La classe est finale, car un singleton n'est pas censé avoir d'héritier.
/**
 * Classe utilitaire singleton pour établir une connexion unique à une BDD
 * 
 * @author Julie Desaintléger
 * @version 0.0.1
 *
 */
public final class MaConnexion {

	private static MaConnexion instance;

	private Connection connection;

	/**
	 * Constructeur de l'objet.
	 * 
	 * @throws ClassNotFoundException si le driver de la BDD est introuvable
	 * @throws SQLException           si un problème survient lors de
	 *                                l'établissement à la connexion
	 */
	private MaConnexion() throws ClassNotFoundException, SQLException {
		// La présence d'un constructeur privé supprime le constructeur public par
		// défaut. De plus, seul le singleton peut s'instancier lui-même.
		super();
		SimpleDataSource.init("bddParams");
		connection = SimpleDataSource.getConnection();
	}

	/**
	 * Méthode permettant de renvoyer une instance unique de la classe MaConnexion
	 * 
	 * @return Retourne l'unique instance de la classe
	 * @throws SQLException           si un problème de connexion survient
	 * @throws ClassNotFoundException si le driver de la BDD est introuvable
	 */
	public final static MaConnexion getInstance() throws ClassNotFoundException, SQLException {
		// Le "Double-Checked Singleton"/"Singleton doublement vérifié" permet
		// d'éviter un appel coûteux à synchronized,
		// une fois que l'instanciation est faite.
		if (MaConnexion.instance == null) {
			// Le mot-clé synchronized sur ce bloc empêche toute instanciation
			// multiple même par différents "threads".
			// Il est TRES important.
			synchronized (MaConnexion.class) {
				if (MaConnexion.instance == null) {
					MaConnexion.instance = new MaConnexion();
				}
			}
		}
		return MaConnexion.instance;
	}

	public Connection getConnection() {
		return connection;
	}

}