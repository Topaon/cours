package fr.inetum.tp.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Classe utilitaire qui permets d'obtenir une connexion à une BDD
 * 
 * @author Julie Desaintléger
 * @version 0.0.1
 *
 */
public class SimpleDataSource {
    static String driver;
    static String url;
    static String user;
    static String password;

    /**
     * Permets d'initialiser les paramètres de connexion à la BDD
     * 
     * @param nomFichier Le nom du fichier de propriétés contenant les paramètres de
     *                   connexion
     * @throws ClassNotFoundException si le driver de la BDD est introuvable
     */
    public static void init(String nomFichier) throws ClassNotFoundException {
	ResourceBundle resource = ResourceBundle.getBundle(nomFichier);

	driver = resource.getString("mysql.driver");
	Class.forName(driver);

	url = resource.getString("mysql.url");
	user = resource.getString("mysql.username");
	password = resource.getString("mysql.password");
    }

    /**
     * Permets d'établir une connexion à la BDD à partir des paramètres de connexion
     * 
     * @return La connexion java.sql à la BDD
     * @throws SQLException si un problème survient lors de l'établissement à la
     *                      connexion
     */
    public static Connection getConnection() throws SQLException {
	return DriverManager.getConnection(url, user, password);
    }

}
