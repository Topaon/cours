package fr.inetum.tp.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import fr.inetum.tp.entites.Stagiaire;
import fr.inetum.tp.jdbc.utils.ConnexionSingleton;

public class StagiaireService implements IStagiaireService {

	@Override
	public Set<Stagiaire> allStagiaire() throws ClassNotFoundException, SQLException {
		Set<Stagiaire> stagiaire = new HashSet<Stagiaire>();
		
		String requete = "SELECT * FROM stagiaire";
		Connection connection = ConnexionSingleton.getInstance().getConnection();
		PreparedStatement stmt = connection.prepareStatement(requete);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			String prenom = rs.getString("prenom");
			String email = rs.getString("email");
			String mdp = rs.getString("mdp");
			Integer adresseId = rs.getInt("adresseId");
			LocalDate ddn = rs.getDate("ddn").toLocalDate();
			Integer role = rs.getInt("adresseId");	
			int id = rs.getInt("id");
			Stagiaire stagiaire1 = new Stagiaire(prenom, email, mdp, adresseId, ddn, role, id);
			((Set<Stagiaire>) stagiaire).add((Stagiaire) stagiaire1);
		}
		return stagiaire;
	}

	@Override
	public Set<Stagiaire> allStagiaire(Stagiaire adresse) throws ClassNotFoundException, SQLException {
		Set<Stagiaire> stagiaire = new HashSet<Stagiaire>();
		
		String requete = "SELECT prenom FROM adresse WHERE adresse = adresse";
		Connection connection = ConnexionSingleton.getInstance().getConnection();
		PreparedStatement stmt = connection.prepareStatement(requete);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			String prenom = rs.getString("prenom");
			Stagiaire stagiaire1 = new Stagiaire();
			((Set<Stagiaire>) stagiaire).add((Stagiaire) stagiaire1);
		}
		return stagiaire;
	}

	@Override
	public void RemoveStagiaire(Stagiaire stagiaire) throws ClassNotFoundException, SQLException {
		String requete = "DELETE FROM stagiaires WHERE id = ?";
		Connection connection = ConnexionSingleton.getInstance().getConnection();
		PreparedStatement stmt = connection.prepareStatement(requete);
		
		stmt.setInt(1, stagiaire);
		stmt.executeUpdate();
		
	}

	@Override
	public void addStagiaire(Stagiaire stagiaire, Stagiaire adresse) throws ClassNotFoundException, SQLException {
		String requete = "INSERT INTO stagiaires(prenom, email, mdp, ddn) VALUES (?, ?, ?, ?)";
		Connection connection = ConnexionSingleton.getInstance().getConnection();
		PreparedStatement stmt = connection.prepareStatement(requete);
		
		stmt.setString(1, stagiaire.getPrenom());
		stmt.setString(2, stagiaire.getEmail());
		stmt.setString(3, stagiaire.getMdp());
		stmt.setInt(4, stagiaire.getAdresseId());
		stmt.setDate(4, Date.valueOf(stagiaire.getDdn()));
		stmt.setInt(6, stagiaire.getRole());
		stmt.setInt(7, stagiaire.getId());
		
		stmt.executeUpdate();
		
	}

	@Override
	public Stagiaire getStagiaire(Stagiaire prenom, Stagiaire email) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stagiaire getStagiaire(Stagiaire id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
