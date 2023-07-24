package fr.inetum.tp.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import fr.inetum.tp.dao.IAdresseService;
import fr.inetum.tp.entites.Adresse;
import fr.inetum.tp.utils.DBConnect;

public class AdresseService implements IAdresseService {
	
	private Connection connection;
	
	public AdresseService() throws ClassNotFoundException, SQLException {
		connection = DBConnect.getInstance().getConnection();
		
	}
	
	public AdresseService(Connection connection) {
		this.connection = connection;
	}
	
	// Affiche la liste de toutes les adresses

	@Override
	public Set<Adresse> allAdresses()throws ClassNotFoundException,SQLException {
		
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
			adresses.add(adresse);
		}
		return adresses;
	}

	// Find adresse by id
	
	@Override
	public Adresse readAdresse(int id) throws ClassNotFoundException, SQLException {
		Adresse adresse = null;
		
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM adresse WHERE id = ?");
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		
			if(rs.next()) {
				adresse = new Adresse(
						rs.getInt(id),
						rs.getString("nomVoie"),
						rs.getString("codePostal"),
						rs.getString("ville")
						);			
			}
		
		return adresse;
	}
	
	// créer l'adresse dans la bdd

	@Override
	public Adresse addAdresse(Adresse adresse) throws ClassNotFoundException, SQLException {
		int id =0;
		String requete = "INSERT INTO Adresse (nomVoie, codePostal, ville ) VALUES (?,?,?)";
		PreparedStatement stmt = connection.prepareStatement(requete,Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, adresse.getNomVoie());
		stmt.setString(2, adresse.getCodePostal());
		stmt.setString(3, adresse.getVille());
		stmt.executeUpdate();
		ResultSet rs = stmt.getGeneratedKeys();
		if(rs.next()) {
			id = rs.getInt(1);
			
			adresse.setId(id);
		}
		return adresse;
	}
	
	//  get last id
	
	public int lastAdresseId() throws SQLException {
		int lastId = 0;
		
		PreparedStatement stmt = connection.prepareStatement("SELECT last_insert_id() FROM adresse");
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			lastId = rs.getInt(1);
		};
		lastId = Integer.valueOf(rs.getString(1));
		
		System.out.println(lastId);
		
		return lastId;
	}

}
