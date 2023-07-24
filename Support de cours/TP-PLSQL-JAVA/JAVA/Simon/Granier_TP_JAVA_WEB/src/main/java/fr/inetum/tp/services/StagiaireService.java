package fr.inetum.tp.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.inetum.tp.entites.Adresse;
import fr.inetum.tp.entites.Stagiaire;

public class StagiaireService implements IStagiaireService {

	@Override
	public ArrayList<Stagiaire> allStagiaire() {
		ArrayList<Stagiaire> listStagiaires = new ArrayList<Stagiaire>();
		String rq ="SELECT * FROM stagiaire";
		
		AdresseService as = new AdresseService();
		Connection con = MaConnexion.getInstance().getConnection();
		try {
			PreparedStatement st = con.prepareStatement(rq);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Stagiaire sta;
				sta = new Stagiaire(
					rs.getInt("id"),
					rs.getString("prenom"),
					rs.getString("email"),
					rs.getString("mdp"),
					as.readAdresse(rs.getInt("adresseId")),
					Date.valueOf((rs.getString("ddn"))),
					rs.getString("role"));
				listStagiaires.add(sta);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listStagiaires;
	}
	
	public ArrayList<Stagiaire> allStagiaire(Adresse adresse) {
		ArrayList<Stagiaire> listStagiaires = new ArrayList<Stagiaire>();
		String req ="SELECT * FROM stagiaire WHERE adresseId=?";
		
		AdresseService as = new AdresseService();
		Connection con = MaConnexion.getInstance().getConnection();
		try {
			PreparedStatement st = con.prepareStatement(req);
			st.setInt(1, adresse.getId());
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Stagiaire sta;
				sta = new Stagiaire(
					rs.getInt("id"),
					rs.getString("prenom"),
					rs.getString("email"),
					rs.getString("mdp"),
					as.readAdresse(rs.getInt("adresseId")),
					Date.valueOf((rs.getString("ddn"))),
					rs.getString("role"));
				listStagiaires.add(sta);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listStagiaires;
	}

	@Override
	public void removeStagiaire(Stagiaire s) {
		String req = "DELETE FROM stagiaire WHERE id = ?";
		try {
			Connection con = MaConnexion.getInstance().getConnection();
			PreparedStatement stmt = con.prepareStatement(req);
			stmt.setInt(1, s.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addStagiaire(Stagiaire stagiaire, Adresse adresse) {
		String req1 = "INSERT INTO stagiaire VALUES (null, ?, ?, ?, ?, ?, ?)";
		String req2 = "INSERT INTO adresse VALUES (null, ?, ?, ?)";
		
		try {
			Connection con = MaConnexion.getInstance().getConnection();
			PreparedStatement stmt1 = con.prepareStatement(req1);
			PreparedStatement stmt2 = con.prepareStatement(req2);
			
			stmt2.setString(1, adresse.getNomVoie());
			stmt2.setString(2, adresse.getCodePostal());
			stmt2.setString(3, adresse.getVille());
			
			stmt2.executeUpdate();
			
			String req3 = "SELECT MAX(id) FROM adresse";
			java.sql.Statement stmt3 = con.createStatement();
			ResultSet rs = stmt3.executeQuery(req3);
			rs.next();
			
			stmt1.setString(1, stagiaire.getPrenom());
			stmt1.setString(2, stagiaire.getEmail());
			stmt1.setString(3, stagiaire.getMdp());
			stmt1.setString(4, stagiaire.getAdresse().getId().toString());
			stmt1.setString(5, stagiaire.getDdn().toString());
			stmt1.setString(6, stagiaire.getRole());
			
			stmt1.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Stagiaire getStagiaire(int id) {
		Stagiaire stagiaire = new Stagiaire();
		String req ="SELECT * FROM stagiaire WHERE id=?";
		
		AdresseService as = new AdresseService();
		Connection con = MaConnexion.getInstance().getConnection();
		try {
			PreparedStatement st = con.prepareStatement(req);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			rs.next();
			stagiaire.setId(rs.getInt("id"));
			stagiaire.setPrenom(rs.getString("prenom"));
			stagiaire.setEmail(rs.getString("email"));
			stagiaire.setMdp(rs.getString("mdp"));
			stagiaire.setAdresse(as.readAdresse(rs.getInt("adresseId")));
			stagiaire.setDdn(Date.valueOf((rs.getString("ddn"))));
			stagiaire.setRole(rs.getString("role"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stagiaire;
	}
	
	public Stagiaire getStagiaire(String email, String mdp) {
		Stagiaire stagiaire = new Stagiaire();
		String req ="SELECT * FROM stagiaire WHERE email=? AND mdp=?";
		
		AdresseService as = new AdresseService();
		Connection con = MaConnexion.getInstance().getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement(req);
			stmt.setString(1, email);
			stmt.setString(2, mdp);
			System.out.println(req);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			stagiaire.setId(rs.getInt("id"));
			stagiaire.setPrenom(rs.getString("prenom"));
			stagiaire.setEmail(rs.getString("email"));
			stagiaire.setMdp(rs.getString("mdp"));
			stagiaire.setAdresse(as.readAdresse(rs.getInt("adresseId")));
			stagiaire.setDdn(Date.valueOf((rs.getString("ddn"))));
			stagiaire.setRole(rs.getString("role"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stagiaire;
	}
	
	public void updateStagiaire(Stagiaire stagiaire) {
		System.out.println(stagiaire.toString());
		String req = "UPDATE stagiaire SET prenom=?, email=?, mdp=?, adresseId=?, ddn=?, role=? WHERE id=?";
		Connection con = MaConnexion.getInstance().getConnection();
		
		try {
			PreparedStatement stmt = con.prepareStatement(req);
			
			stmt.setString(1, stagiaire.getPrenom());
			stmt.setString(2, stagiaire.getEmail());
			stmt.setString(3, stagiaire.getMdp());
			stmt.setString(4, stagiaire.getAdresse().getId().toString());
			stmt.setString(5, stagiaire.getDdn().toString());
			stmt.setString(6, stagiaire.getRole());
			
			stmt.setString(7, stagiaire.getId().toString());
			System.out.println(stagiaire.getId().toString());
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
