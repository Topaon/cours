package fr.inetum.tp.utils;

import org.mindrot.jbcrypt.BCrypt;

public class MethodesUtil {

	public static String capitalizeFirstLetter(String word) {
		if (word == null || word.isEmpty()) {
			return word;
		}
		return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
	}
	
	
	public static String hashPassword(String mdp) {
		return BCrypt.hashpw(mdp, BCrypt.gensalt());
	}
	
	public static boolean checkPassword(String mdp, String mdpHache) {
		return BCrypt.checkpw(mdp, mdpHache);
	}
	
}
