package fr.inetum.tp.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import fr.inetum.tp.entites.Adresse;
import fr.inetum.tp.jdbc.utils.ConnexionSingleton;

public class AdresseService implements IAdresseService {

	@SuppressWarnings("unchecked")
	@Override
	public Set<Adresse> allAdresse() throws ClassNotFoundException, SQLException {
		Set<Adresse> adresse = new HashSet<Adresse>();
		
		String requete = "SELECT * FROM adresse";
		Connection connection = ConnexionSingleton.getInstance().getConnection();
		PreparedStatement stmt = connection.prepareStatement(requete);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			String nomVoie = rs.getString("nomVoie");
			String codePostal = rs.getString("codePostal");
			String ville = rs.getString("ville");
			int id = rs.getInt("id");
			Adresse adresse1 = new Adresse(nomVoie, codePostal, ville, id);
			((Set<Adresse>) adresse1).add((Adresse) adresse1);
		}
		return adresse;
	}

	@Override
	public Adresse readAdresse(Adresse id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addAdresse(Adresse adresse) throws ClassNotFoundException, SQLException {
		String requete = "INSERT INTO adresse(nomVoie, , codePostal, ville, id) VALUES (?, ?, ?, ?)";
		Connection connection = ConnexionSingleton.getInstance().getConnection();
		PreparedStatement stmt = connection.prepareStatement(requete);
		
		stmt.setString(1, adresse.getNomVoie());
		stmt.setString(2, adresse.getCodePostal());
		stmt.setString(3, adresse.getVille());
		stmt.setInt(4, adresse.getId());
		
		stmt.executeUpdate();
	}

}
