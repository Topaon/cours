package fr.inetum.tp.utils;

import org.mindrot.jbcrypt.BCrypt;

public class AppUtil {
	
	public static String capitalize(String word) {
		if (word == null || word.isEmpty()) {
			return word;
		} else {
			return word = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
		}
	}
	
	public static String hashPassword (String mdp) {
		return BCrypt.hashpw(mdp, BCrypt.gensalt());
	}
	
	
	public static boolean checkPassword (String mdp, String hashedPassword) {
		return BCrypt.checkpw(mdp, hashedPassword);
	}

}
