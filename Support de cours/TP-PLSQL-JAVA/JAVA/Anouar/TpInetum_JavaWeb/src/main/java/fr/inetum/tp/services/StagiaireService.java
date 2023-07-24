package fr.inetum.tp.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import fr.inetum.tp.entites.Adresse;
import fr.inetum.tp.entites.Stagiaire;
import fr.inetum.tp.jdbc.outils.AppUtil;
import fr.inetum.tp.jdbc.outils.MaConnexion;

public class StagiaireService implements IStagiaireService{

	
	
	
	  public StagiaireService() {
		  
	  }
	  public StagiaireService(Connection connection,IAdresseService iAdresseService) {
		  
	  }
	  public StagiaireService(Connection connection) {
		  
	  }
	
	
	  
	@Override
	public Set<Stagiaire> allStagiaires() throws ClassNotFoundException, SQLException {
		Set<Stagiaire> stagiaires = new HashSet<>();
		String requete = "SELECT * FROM Stagiaire";
		Connection connection = MaConnexion.getInstance().getConnection();
		PreparedStatement stmt = connection.prepareStatement(requete);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {		
			String prenom = rs.getString("prenom");
			String email = rs.getString("email");
			String mdp = rs.getString("mdp");
			int adresseId = rs.getInt("adresseId");
			LocalDate ddn = rs.getDate("ddn").toLocalDate();
			String role = rs.getString("role");
			int id = rs.getInt("id");
			Stagiaire stagiaire = new Stagiaire(prenom, email, mdp,adresseId,ddn,role,id);
			stagiaires.add(stagiaire);
		}
		
		
		return stagiaires;
	}
	@Override
	public Set<Stagiaire> allStagiaires(Adresse adresse) throws SQLException, ClassNotFoundException {
	/*	String requete = "SELECT FROM Stagiaire(prenom, email, mdp,adresseId,ddn,role,id) VALUES (?, ?, ?, ?,?,?,?) "
				+ "WHERE id = ?";
		
		Connection connection = MaConnexion.getInstance().getConnection();
		PreparedStatement stmt = connection.prepareStatement(requete);*/
		return null;
	}
	
	
	@Override
	public void removeStagiaire(Stagiaire stagiaire) throws ClassNotFoundException, SQLException {	
		String requeteStagiaire = "DELETE FROM Stagiaire WHERE id = ?";
		Connection connectionStagiaire = MaConnexion.getInstance().getConnection();
		PreparedStatement stmtStagiaire = connectionStagiaire.prepareStatement(requeteStagiaire);
		stmtStagiaire.setInt(1, stagiaire.getId());
		stmtStagiaire.executeUpdate();
		
		String requeteAdresse = "DELETE FROM Adresse WHERE id = ?";
		Connection connectionAdresse = MaConnexion.getInstance().getConnection();
		PreparedStatement stmtAdresse = connectionAdresse.prepareStatement(requeteAdresse);
		stmtAdresse.setInt(1, stagiaire.getId());
		stmtAdresse.executeUpdate();
		
	}
	
	
	@Override
	public void addStagiaire(Stagiaire stagiaire, Adresse adresse) throws ClassNotFoundException, SQLException {
		
		String requeteAdresse = "INSERT INTO Adresse(nomVoie, codepostal, ville,id) VALUES (?, ?, ?,?)";
		Connection connectionAdresse = MaConnexion.getInstance().getConnection();
		PreparedStatement stmtAdresse = connectionAdresse.prepareStatement(requeteAdresse);
		
        stmtAdresse.setString(1, adresse.getNomVoie());
        stmtAdresse.setString(2, adresse.getCodePostal());
        stmtAdresse.setString(3, AppUtil.capitalize(adresse.getVille()));
        stmtAdresse.setInt(4, adresse.getId());
		stmtAdresse.executeUpdate();
		
		String requeteStagiaire = "INSERT INTO Stagiaire(prenom, email, mdp,adresseId,ddn,role,id) VALUES (?, ?, ?, ?,?,?,?)";
		Connection connectionStagiaire = MaConnexion.getInstance().getConnection();
		PreparedStatement stmtStagiaire = connectionStagiaire.prepareStatement(requeteStagiaire);
		
		stmtStagiaire.setString(1,  AppUtil.capitalize(stagiaire.getPrenom()));
        stmtStagiaire.setString(2, stagiaire.getEmail().toLowerCase());
        stmtStagiaire.setString(3, AppUtil.hashPassword(stagiaire.getMdp()));
        stmtStagiaire.setInt(4, stagiaire.getAdresseId());  
        stmtStagiaire.setDate(5, Date.valueOf(stagiaire.getDdn()));
        stmtStagiaire.setString(6, stagiaire.getRole());
        stmtStagiaire.setInt(7, stagiaire.getId());
		stmtStagiaire.executeUpdate();
		
		
	}
	
	public void updateStagiaire(Stagiaire stagiaire, Adresse adresse) throws SQLException, ClassNotFoundException {
		
		String requeteAdresse = "UPDATE adresse SET "				
											+ " nomVoie = ?,"
											+ " codePostal = ?,"
											+ " ville = ?"
											+ " WHERE id = ?";
		Connection connectionAdresse = MaConnexion.getInstance().getConnection();
		PreparedStatement stmtAdresse = connectionAdresse.prepareStatement(requeteAdresse);
		
        stmtAdresse.setString(1, adresse.getNomVoie());
        stmtAdresse.setString(2, adresse.getCodePostal());
        stmtAdresse.setString(3, AppUtil.capitalize(adresse.getVille()));
        stmtAdresse.setInt(4, adresse.getId());
		stmtAdresse.executeUpdate();
		
		String requeteStagiaire = "UPDATE Stagiaire SET prenom = ?,"
				+ " email = ?,"
				+ " mdp = ?,"
				+ " adresseId = ?,"
				+ " ddn = ?,"
				+ " role = ?"
				+ " WHERE id = ?";
		Connection connectionStagiaire = MaConnexion.getInstance().getConnection();
		PreparedStatement stmtStagiaire = connectionStagiaire.prepareStatement(requeteStagiaire);
		
		stmtStagiaire.setString(1,  AppUtil.capitalize(stagiaire.getPrenom()));
        stmtStagiaire.setString(2, stagiaire.getEmail().toLowerCase());
        stmtStagiaire.setString(3, AppUtil.hashPassword(stagiaire.getMdp()));
        stmtStagiaire.setInt(4, stagiaire.getAdresseId());  
        stmtStagiaire.setDate(5, Date.valueOf(stagiaire.getDdn()));
        stmtStagiaire.setString(6, stagiaire.getRole());
        stmtStagiaire.setInt(7, stagiaire.getId());
		stmtStagiaire.executeUpdate();
	}
		
	
	@Override
	public Stagiaire getStagiaire(String email, String mdp) throws ClassNotFoundException, SQLException {
		String requete = "SELECT * FROM Stagiaire WHERE email = ? AND mdp = ? ";
		Connection connection = MaConnexion.getInstance().getConnection();
		PreparedStatement stmt = connection.prepareStatement(requete);
		stmt.setString(1, email);
		stmt.setString(2, mdp);
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
		String prenom = rs.getString("prenom");
		int adresseId = rs.getInt("adresseId");
		LocalDate ddn = rs.getDate("ddn").toLocalDate();
		String role = rs.getString("role");
		int id = rs.getInt("id");
		Stagiaire stagiaire = new Stagiaire(prenom, email, mdp,adresseId,ddn,role,id);
		return stagiaire;
	}
		else {
			return null;
		}
	}
	
	
	@Override
	public Stagiaire getStagiaire(Integer id) throws ClassNotFoundException, SQLException {
		String requete = "SELECT * FROM Stagiaire WHERE id = ? ";
		Connection connection = MaConnexion.getInstance().getConnection();
		PreparedStatement stmt = connection.prepareStatement(requete);	
		stmt.setInt(1,id);
		ResultSet rs = stmt.executeQuery();	
		
		if(rs.next()) {
		String prenom = rs.getString("prenom");
		String email = rs.getString("email");
		String mdp = rs.getString("mdp");
		int adresseId = rs.getInt("adresseId");
		LocalDate ddn = rs.getDate("ddn").toLocalDate();
		String role = rs.getString("role");

		Stagiaire stagiaire = new Stagiaire(prenom, email, mdp,adresseId,ddn,role,id);
		return stagiaire;
	}
		else {
			return null;
		}

	}

	


}
