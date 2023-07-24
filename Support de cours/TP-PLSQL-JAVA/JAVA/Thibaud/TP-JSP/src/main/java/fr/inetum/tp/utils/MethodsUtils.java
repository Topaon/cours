package fr.inetum.tp.utils;

import org.mindrot.jbcrypt.BCrypt;

public class MethodsUtils {
	
	// METHODE POUR METTRE EN MAJ PREMIERE LETTRE
	public static String capitalize(String word) {
		if (word == null || word.isEmpty()) {
			return word;
		}
		return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
	}
	
	// METHODE POUR HACHER MDP
	public static String hashPassword(String mdp) {
		return BCrypt.hashpw(mdp, BCrypt.gensalt());
	}
	
	// METHODE POUR VERIFIER MDP
	public static boolean checkPassword(String mdp, String mdpHache) {
		return BCrypt.checkpw(mdp, mdpHache);
	}

}
