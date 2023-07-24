package fr.inetum.tp.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.inetum.tp.entities.Adresse;
import fr.inetum.tp.entities.Stagiaire;
import fr.inetum.tp.utils.AppUtil;
import fr.inetum.tp.utils.MaConnexion;

public class StagiaireService implements IStagiaireService {
	
	private Connection connection;
	
	public StagiaireService(Connection connection) {
		this.connection = connection;
	}
	
	public StagiaireService() {
		try {
			this.connection = MaConnexion.getInstance().getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
	}
	
	@Override
	public List<Stagiaire> allStagiaires() throws ClassNotFoundException, SQLException {
		List<Stagiaire> stagiaires = new ArrayList<>();

		String requete = 
				"SELECT "
				+ "s.id, "
				+ "s.prenom, "
				+ "s.email, "
				+ "s.mdp, "
				+ "s.ddn, "
				+ "s.role, "
				+ "s.adresseId, "
				+ "a.nomVoie, "
				+ "a.codePostal, "
				+ "a.ville "
				+ "FROM Adresse a "
				+ "JOIN Stagiaire s "
				+ "ON s.adresseId = a.id;";
		PreparedStatement stmt = connection.prepareStatement(requete);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			int id = rs.getInt("id");
			String prenom = rs.getString("prenom");
			String email = rs.getString("email");
			String mdp = rs.getString("mdp");
			LocalDate ddn = rs.getDate("ddn").toLocalDate();
			String role = rs.getString("role");
			int adresseId = rs.getInt("adresseId");
			String nomVoie = rs.getString("nomVoie");
			String codePostal = rs.getString("codePostal");
			String ville = rs.getString("ville");
			Adresse adresse = new Adresse(adresseId, nomVoie, codePostal, ville);
			Stagiaire stagiaire = new Stagiaire(id, prenom, email, mdp, adresse, ddn, role);
			stagiaires.add(stagiaire);

		}
		System.out.println(Arrays.toString(stagiaires.toArray()));
		return stagiaires;
	}

	@Override
	public List<Stagiaire> allStagiaires(Adresse adresse) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeStagiaire(String id) throws ClassNotFoundException, SQLException {

			String requete = "DELETE FROM Stagiaire WHERE id = ?";
			PreparedStatement stmt = connection.prepareStatement(requete);
			stmt.setString(1, id);
			stmt.executeUpdate();
		
	}
	

	@Override
	public void addStagiaire(Stagiaire stagiaire, Adresse adresse) throws ClassNotFoundException, SQLException {
		int adresseId = 0;
		
		String requeteAdresse = "INSERT INTO Adresse(nomVoie, codePostal, ville) VALUES (?,?,?)";
		PreparedStatement stmtAddr = connection.prepareStatement(requeteAdresse);
		stmtAddr.setString(1, AppUtil.capitalize(adresse.getNomVoie()));
		stmtAddr.setString(2, AppUtil.capitalize(adresse.getCodePostal()));
		stmtAddr.setString(3, AppUtil.capitalize(adresse.getVille()));
		stmtAddr.executeUpdate();
		System.out.println(stmtAddr);
		

		String requeteAdresseId = "SELECT id FROM Adresse WHERE nomVoie =? AND codePostal =? AND ville =?";
		PreparedStatement stmtAddrId = connection.prepareStatement(requeteAdresseId);
		stmtAddrId.setString(1, AppUtil.capitalize(adresse.getNomVoie()));
		stmtAddrId.setString(2, AppUtil.capitalize(adresse.getCodePostal()));
		stmtAddrId.setString(3, AppUtil.capitalize(adresse.getVille()));
		System.out.println(stmtAddrId);
		ResultSet rs = stmtAddrId.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");
			adresseId = id;
		} 

		
		String requeteStagiaire = "INSERT INTO Stagiaire(prenom, email, mdp, adresseId, ddn, role) VALUES (?,?,?,?,?,?)";
		PreparedStatement stmtSta = connection.prepareStatement(requeteStagiaire);
		stmtSta.setString(1, AppUtil.capitalize(stagiaire.getPrenom()));
		stmtSta.setString(2, stagiaire.getEmail().toLowerCase());
		stmtSta.setString(3, AppUtil.hashPassword(stagiaire.getMdp()));
		stmtSta.setInt(4, adresseId);
		stmtSta.setDate(5, Date.valueOf(stagiaire.getDdn()));
		stmtSta.setString(6, stagiaire.getRole().toLowerCase());
		stmtSta.executeUpdate();
		
		System.out.println(requeteStagiaire);


	}
	

	@Override	
	public Stagiaire getStagiaire(String login, String mdp) throws ClassNotFoundException, SQLException {
		String requete = "SELECT * FROM Stagiaire WHERE email = ?";
		PreparedStatement stmt = connection.prepareStatement(requete);
		stmt.setString(1, login);
		ResultSet rs = stmt.executeQuery();
		
		Stagiaire stagiaire = null;
		
		while (rs.next()) {
			String hashedPassword = rs.getString("mdp");
			if (AppUtil.checkPassword (mdp, hashedPassword)) {
				int id = rs.getInt("id");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String password = rs.getString("mdp");
				LocalDate ddn = rs.getDate("ddn").toLocalDate();
				String role = rs.getString("role");
				Adresse adresse = new Adresse();
				stagiaire = new Stagiaire(id, prenom, email, password, adresse, ddn, role);
			}
		} 
		
		return stagiaire;
				
	}


	@Override
	public void getStagiaire(Integer id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}
	
	

}
