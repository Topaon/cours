package fr.inetum.tp.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import fr.inetum.tp.connexion.MaConnexion;
import fr.inetum.tp.entites.Adresse;
import fr.inetum.tp.interfaces.IAdresseService;

public class AdresseService implements IAdresseService {

	private Connection connection;
	
	public AdresseService() throws ClassNotFoundException, SQLException {
		connection = MaConnexion.getInstance().getConnection();
	}
	
	// AFFICHE LISTE DE TOUS LES ADRESSES
	@Override
	public Set<Adresse> allAdresses() throws SQLException {
		
		Set<Adresse> adresses = new HashSet<>();
		String requete = "SELECT * FROM Adresse";
		PreparedStatement stmt = connection.prepareStatement(requete);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String nomVoie = rs.getString("nomVoie");
			String codePostal = rs.getString("codePostal");
			String ville = rs.getString("ville");
			
			Adresse adresse = new Adresse(id, nomVoie, codePostal, ville);
			addAdresses(adresse);
		}
		return adresses;
	}

	// AJOUTER ADRESSE A LA BDD
	@Override
	public void addAdresses(Adresse adresse) throws SQLException {
		int id = 0;
		
		String requete = "INSERT INTO Adresse (nomVoie, codePostal, ville) VALUES (?,?,?)";
		PreparedStatement stmt = connection.prepareStatement(requete);
		stmt.setString(1, adresse.getNomVoie());
		stmt.setString(2, adresse.getCodePostal());
		stmt.setString(3, adresse.getVille());
		stmt.executeUpdate();
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			id = rs.getInt(1);
			adresse.setId(id);
		}
		return;
	}

	// LECTURE DE LA LISTE DES STAGIAIRES
	@Override
	public Adresse readAdresses(Integer id) throws SQLException {
		
		Adresse adresse = null;
		
		String requete = "SELECT * FROM adresse WHERE id = ?";
		PreparedStatement stmt = connection.prepareStatement(requete);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			adresse = new Adresse(id, "nomVoie", "codePostal", "ville");
		}
		return adresse;
	}
}
