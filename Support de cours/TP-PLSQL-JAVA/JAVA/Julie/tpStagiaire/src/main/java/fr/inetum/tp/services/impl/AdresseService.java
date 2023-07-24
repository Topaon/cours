package fr.inetum.tp.services.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import fr.inetum.tp.entities.Adresse;
import fr.inetum.tp.jdbc.utils.MaConnexion;
import fr.inetum.tp.services.IAdresseService;

public class AdresseService implements IAdresseService {

	private Connection connection;

	public AdresseService() throws ClassNotFoundException, SQLException {
		this.connection = MaConnexion.getInstance().getConnection();
	}

	public AdresseService(Connection connection) {
		this.connection = connection;
	}

	@Override
	public Set<Adresse> allAdresses() throws SQLException {
		Set<Adresse> adresses = new HashSet<Adresse>();
		String requete = "SELECT * FROM Adresse";
		PreparedStatement stmt = connection.prepareStatement(requete);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			int id = rs.getInt("id");
			String nomVoie = rs.getString("nomVoie");
			String codePostal = rs.getString("codePostal");
			String ville = rs.getString("ville");

			Adresse adresse = new Adresse(id, nomVoie, codePostal, ville);
			adresses.add(adresse);
		}

		return adresses;
	}

	@Override
	public Adresse readAdresses(Integer adresseId) throws SQLException {
		String requete = "SELECT nomVoie, codePostal, ville FROM Adresse WHERE id= ?";
		PreparedStatement stmt = connection.prepareStatement(requete);

		stmt.setInt(1, adresseId);
		Adresse adresse = null;
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			String nomVoie = rs.getString("nomVoie");
			String codePostal = rs.getString("codePostal");
			String ville = rs.getString("ville");
			adresse = new Adresse(adresseId, nomVoie, codePostal, ville);
		}
		return adresse;
	}

	@Override
	public Adresse addAdresses(Adresse adresse) throws SQLException {
		String requete = "INSERT INTO Adresse(nomVoie, codePostal, ville) VALUES (?,?,?)";
		PreparedStatement stmt = connection.prepareStatement(requete);
		stmt.setString(1, adresse.getNomVoie());
		stmt.setString(2, adresse.getCodePostal());
		stmt.setString(3, adresse.getVille());

		stmt.executeUpdate();

		return adresse;
	}

}
