package fr.inetum.tp.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.inetum.tp.entities.Adresse;
import fr.inetum.tp.utils.MaConnexion;

public class AdresseService implements IAdresseService {

	private Connection connection;

	public AdresseService(Connection connection) {
		this.connection = connection;
	}

	public AdresseService() {
		try {
			this.connection = MaConnexion.getInstance().getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
	}

	public Adresse readAdresse (int adresseId) throws ClassNotFoundException, SQLException {

		String requete = 
				"SELECT a.id, a.nomVoie, a.codePostal, a.ville"
				+ "	FROM Adresse a"
				+ "	JOIN Stagiaire s on s.adresseId = a.id"
				+ "	WHERE s.id = ?";

		PreparedStatement stmt = connection.prepareStatement(requete);
		stmt.setInt(1, adresseId);
		ResultSet rs = stmt.executeQuery();
		
		Adresse adresse = null;
		
		while (rs.next()) {
			int id = rs.getInt("id");
			String nomVoie = rs.getString("nomVoie");
			String codePostal = rs.getString("codePostal");
			String ville = rs.getString("ville");

			adresse = new Adresse(id, nomVoie, codePostal, ville);
		} 
		
		return adresse;					
	}
	
	

	@Override
	public List<Adresse> allAdresses() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addAdresse(Adresse adresse) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

}
