package fr.inetum.tp.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import fr.inetum.tp.connexion.MaConnexion;
import fr.inetum.tp.entites.Adresse;
import fr.inetum.tp.entites.Stagiaire;
import fr.inetum.tp.interfaces.IStagiaireService;
import fr.inetum.tp.utils.MethodsUtils;

public class StagiaireService implements IStagiaireService {

	private Connection connection;
	
	public StagiaireService() throws ClassNotFoundException, SQLException {
		connection = MaConnexion.getInstance().getConnection();
	}
	
	// LISTE DE TOUS LES STAGIAIRES
	@Override
	public Set<Stagiaire> allStagiaires() throws ClassNotFoundException, SQLException {

		Set<Stagiaire> stagiaires = new HashSet<Stagiaire>();
		String requete = "SELECT * FROM Stagiaire";
		PreparedStatement stmt = connection.prepareStatement(requete);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String prenom = rs.getString("prenom");
			String email = rs.getString("email");
			String mdp = rs.getString("mdp");
			Adresse adresseID = new Adresse(rs.getInt("adresseID"));
			LocalDate ddn = rs.getDate("ddn").toLocalDate();
			String role = rs.getString("role");
			Stagiaire stagiaire = new Stagiaire(id, prenom, email, mdp, adresseID, ddn, role);		
			stagiaires.add(stagiaire);
		}
		return stagiaires;
	}

	// LISTE STAGIAIRES AVEC ADRESSE EN PARAMETRE
	@Override
	public Set<Stagiaire> allStagiaires(Adresse adresse) throws ClassNotFoundException,SQLException {
		
		Set<Stagiaire> stagiaires = new HashSet<Stagiaire>();
		String requete = "SELECT * FROM Stagiaire WHERE adresseID = ?";
		PreparedStatement stmt = connection.prepareStatement(requete);
		stmt.setInt(1, adresse.getId());
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String prenom = rs.getString("prenom");
			String email = rs.getString("email");
			String mdp = rs.getString("mdp");
			Adresse adresseID = new Adresse(rs.getInt("adresseID"));
			LocalDate ddn = rs.getDate("ddn").toLocalDate();
			String role = rs.getString("role");
			Stagiaire stagiaire = new Stagiaire(id, prenom, email, mdp, adresseID, ddn, role);
			stagiaires.add(stagiaire);
		}		
		return stagiaires;
	}

	// AJOUTER UN STAGIAIRE EN BDD
	@Override
	public void addStagiaire(Stagiaire stagiaire) throws ClassNotFoundException, SQLException {
		
		String requete = "INSERT INTO Stagiaire(prenom, email, mdp, adresseID, ddn, role) VALUES (?,?,?,?,?,?)";
		PreparedStatement stmt = connection.prepareStatement(requete);
		
		stmt.setString(1, MethodsUtils.capitalize(stagiaire.getPrenom()));
		stmt.setString(2, stagiaire.getEmail().toLowerCase());
		stmt.setString(3, MethodsUtils.hashPassword(stagiaire.getMdp()));
		stmt.setInt(4, stagiaire.getAdresseID().getId());
		stmt.setDate(5, Date.valueOf(stagiaire.getDdn()));
		stmt.setString(5, stagiaire.getRole());
		stmt.executeUpdate();
	}

	// SUPPRIMER LE STAGIAIRE DE LA BDD
	@Override
	public void removeStagiaire(Stagiaire stagiaire) throws ClassNotFoundException, SQLException {
		
		String requete = "DELETE FROM Stagiaire WHERE id=?";
		PreparedStatement stmt = connection.prepareStatement(requete);
		
		stmt.setInt(1, stagiaire.getId());
		stmt.executeUpdate();
	}

	// SUPPRIME STAGIAIRE PAR ID
	@Override
	public void removeStagiaire(int ID) throws SQLException {
		
		String requete = "DELETE FROM stagiaire WHERE id = ?";
		PreparedStatement stmt = connection.prepareStatement(requete);
		stmt.setInt(1, ID);
		stmt.executeUpdate();
	}
	
	// RECHERCHE STAGIAIRE EN FONCTION DU LOGIN & MDP
	@Override
	public Stagiaire getStagiaire(String email, String mdp) {
		
		String requete = "SELECT * FROM Stagiaire WHERE email = ? AND mdp = ?";
		PreparedStatement stmt = connection.prepareStatement(requete);
		
		stmt.setString(1, email);
		stmt.setString(2, mdp);
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
					int id = rs.getInt("id");
					String prenom = rs.getString("prenom");
					String email = rs.getString("email");
					String mdp = MethodsUtils.hashPassword(rs.getString("mdp"));
					int adresseID = rs.getInt("adresseID");
					LocalDate ddn = rs.getDate("ddn").toLocalDate();
					String role = rs.getString("role");
					
					Stagiaire stagiaire = new Stagiaire();
					return stagiaire;
		}
		else {
			return null;
		}
	}

	// RECHERCHE STAGIAIRE EN FONCTION DE L'ID
	@Override
	public Stagiaire getStagiaire(int ID) throws SQLException {
		
		Stagiaire stagiaire = null;
		
		String requete = "SELECT * FROM Stagiaire WHERE id = ?";
		PreparedStatement stmt = connection.prepareStatement(requete);
		stmt.setInt(1, ID);
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			stagiaire = new Stagiaire(
					rs.getInt(ID),
					rs.getString("prenom"),
					rs.getString("email"),
					MethodsUtils.hashPassword(rs.getString("mdp")),
					new Adresse(rs.getInt("adresseID")),
					rs.getDate("ddn").toLocalDate(),
					rs.getString("role")
					);
		}
		return stagiaire;
	}
}
