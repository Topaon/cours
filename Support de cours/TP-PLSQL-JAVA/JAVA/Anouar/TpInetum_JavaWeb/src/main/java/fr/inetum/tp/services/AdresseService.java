package fr.inetum.tp.services;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import fr.inetum.tp.entites.Adresse;
import fr.inetum.tp.jdbc.outils.MaConnexion;

public class AdresseService implements IAdresseService {
	
	public AdresseService() {
	
	}
	
	public AdresseService(Connection connection) {

	}

	@Override
	public Set<Adresse> allAdresse() throws ClassNotFoundException, SQLException {
		Set<Adresse> adresses = new HashSet<>();
		String requete = "SELECT * FROM Adresse";
		Connection connection = MaConnexion.getInstance().getConnection();
		PreparedStatement stmt = connection.prepareStatement(requete);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {		
			String nomVoie = rs.getString("nomVoie");
			String codePostal = rs.getString("codePostal");
			String ville = rs.getString("ville");
			int id = rs.getInt("id");
			Adresse adresse = new Adresse( nomVoie,  codePostal,  ville,  id);
			adresses.add(adresse);
		}
		
		return adresses;
	}

	@Override
	public Adresse readAdresse(int adresseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Adresse addAdresse(Adresse adresse) {
		// TODO Auto-generated method stub
		return null;
	}
	



}
