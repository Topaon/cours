package fr.inetum.tp.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import fr.inetum.tp.dao.IAdresseService;
import fr.inetum.tp.dao.IStagiaireService;
import fr.inetum.tp.entites.Adresse;
import fr.inetum.tp.entites.Stagiaire;
import fr.inetum.tp.utils.DBConnect;
import fr.inetum.tp.utils.MethodesUtil;

public class StagiaireService implements IStagiaireService {
	
	private Connection connection;
	
	public StagiaireService() throws ClassNotFoundException, SQLException {
		connection = DBConnect.getInstance().getConnection();
	};
	
	public StagiaireService(Connection connection, IAdresseService iAd) {
		
	};
	
	public StagiaireService(Connection connection) {
		this.connection = connection;
		
	};
	
	// Liste de tous les stagiaires

	@Override
	public Set<Stagiaire> allStagiaires() throws ClassNotFoundException,SQLException {
		
		Set<Stagiaire> stagiaires = new HashSet<>();
		
		String requete = "SELECT * FROM Stagiaire";
		PreparedStatement stmt = connection.prepareStatement(requete);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String prenom = rs.getString("prenom");
			String email = rs.getString("email");
			String mdp = rs.getString("mdp");
			Adresse adresseId = new Adresse(rs.getInt("adresseId"));
			LocalDate ddn = rs.getDate("ddn").toLocalDate();
			String role = rs.getString("role");
			Stagiaire stagiaire = new Stagiaire(id, prenom, email,mdp,adresseId, ddn, role);
			stagiaires.add(stagiaire);
		}
		return stagiaires;
	}

	// liste de tous les stagiaires partageant l'adresse renseignée en paramètre
	
	@Override
	public Set<Stagiaire> allStagiaires(Adresse adresse) throws ClassNotFoundException,SQLException {
		
		Set<Stagiaire> stagiaires = new HashSet<>();
		
		String requete = "SELECT * FROM Stagiaire WHERE adresseId = ?";
		PreparedStatement stmt = connection.prepareStatement(requete);
		stmt.setInt(1, adresse.getId());
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String prenom = rs.getString("prenom");
			String email = rs.getString("email");
			String mdp = rs.getString("mdp");
			Adresse adresseId = new Adresse(rs.getInt("adresseId"));
			LocalDate ddn = rs.getDate("ddn").toLocalDate();
			String role = rs.getString("role");
			Stagiaire stagiaire = new Stagiaire(id, prenom, email,mdp,adresseId, ddn, role);
			stagiaires.add(stagiaire);
		}
		return stagiaires;
	}

	// Supprimer un stagiaire de la bdd
	
	@Override
	public void removeStagiaire(Stagiaire stagiaire) throws ClassNotFoundException,SQLException {
		String requete = "DELETE FROM stagiaire WHERE id=?";
			PreparedStatement stmt = connection.prepareStatement(requete);
			stmt.setInt(1, stagiaire.getId());
			stmt.executeUpdate();
	}
	
	
	// Delete by id 
	public void deleteStagiaire(int id) throws ClassNotFoundException,SQLException {
		String requete = "DELETE FROM stagiaire WHERE id=?";
		PreparedStatement stmt = connection.prepareStatement(requete);
		stmt.setInt(1, id);
		stmt.executeUpdate();
	}
	
	// Ajouter un stagiaire en bdd

	@Override
	public void addStagiaire(Stagiaire stagiaire, Adresse adresse) throws ClassNotFoundException, SQLException  {
		
		String requete = "INSERT INTO Stagiaire (prenom, email, mdp, adresseId, ddn, role ) VALUES (?,?,?,?,?,?)";
		
		PreparedStatement stmt = connection.prepareStatement(requete);
		
		stmt.setString(1, MethodesUtil.capitalizeFirstLetter(stagiaire.getPrenom()));
		stmt.setString(2, stagiaire.getEmail().toLowerCase());
		stmt.setString(3, MethodesUtil.hashPassword(stagiaire.getMdp()));
		stmt.setInt(4, stagiaire.getAdresseId().getId());
		stmt.setDate(5, Date.valueOf(stagiaire.getDdn()));
		stmt.setString(6, stagiaire.getRole());
		stmt.executeUpdate();
		
	}
	
	// retourne le stagiaire correspondant au même login / mdp 

	@Override
	public Stagiaire getStagiaire(String email, String mdp) throws ClassNotFoundException, SQLException {	
		Stagiaire stagiaire = null;
	
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM stagiaire WHERE email = ? AND mdp = ?");
		stmt.setString(1, email);
		stmt.setString(2, mdp);
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {	
			stagiaire = new Stagiaire(
					rs.getInt("id"),
					rs.getString("prenom"),
					rs.getString("email"),
					MethodesUtil.hashPassword(rs.getString("mdp")),
					new Adresse(rs.getInt("adresseId")),
					rs.getDate("ddn").toLocalDate(),
					rs.getString("role")
					);			
		}
		
		return stagiaire;
	}
	
	// find by id 

	@Override
	public Stagiaire getStagiaire(int id) throws ClassNotFoundException, SQLException {
		Stagiaire stagiaire = null;
		
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM stagiaire WHERE id = ?");
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		
			if(rs.next()) {	
				stagiaire = new Stagiaire(
						rs.getInt(id),
						rs.getString("prenom"),
						rs.getString("email"),
						MethodesUtil.hashPassword(rs.getString("mdp")),
						new Adresse(rs.getInt("adresseId")),
						rs.getDate("ddn").toLocalDate(),
						rs.getString("role")
						);			
			}
		
		return stagiaire;
	}
	
	// met à jour le stagiaire dans la base
	
	public Stagiaire updateStagiaire(Stagiaire stagiaire, Adresse adresse) throws SQLException {
		
		
		String requete = "UPDATE stagiaire SET prenom=?, email=?, mdp=?, ddn=?, role=? WHERE id=?";
		
			
			PreparedStatement stmt = connection.prepareStatement(requete);
			stmt.setString(1, stagiaire.getPrenom());
			stmt.setString(2, stagiaire.getEmail().toLowerCase());
			stmt.setString(3, MethodesUtil.hashPassword(stagiaire.getMdp()));
			stmt.setDate(4,Date.valueOf(stagiaire.getDdn()));
			stmt.setString(5, stagiaire.getRole());
			stmt.setInt(6, stagiaire.getId());
			
			stmt.executeUpdate();
			
			return stagiaire;

	}
}
