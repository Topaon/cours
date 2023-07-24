package fr.inetum.tp.services.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import fr.inetum.tp.jdbc.utils.MaConnexion;

import fr.inetum.tp.entities.Adresse;
import fr.inetum.tp.entities.Stagiaire;
import fr.inetum.tp.services.IAdresseService;
import fr.inetum.tp.services.IStagiaireService;

public class StagiaireService implements IStagiaireService {
	private IAdresseService adresseService;
	private Connection connection;

	public StagiaireService() throws ClassNotFoundException, SQLException {
		this.adresseService = new AdresseService();
		this.connection = MaConnexion.getInstance().getConnection();
	}

	public StagiaireService(IAdresseService adresseService, Connection connection) {
		this.adresseService = new AdresseService(connection);
	}

	public StagiaireService(Connection connection) {
		this.connection = connection;
	}

	@Override
	public Set<Stagiaire> allStagiaire() throws SQLException {
		Set<Stagiaire> stagiaires = new HashSet<Stagiaire>();
		String requete = "SELECT s.id, prenom, email, mdp, ddn, role, adresseId, a.nomVoie, a.codePostal, a.ville FROM Stagiaire s LEFT JOIN Adresse a ON s.adresseId = a.id";
		PreparedStatement stmt = connection.prepareStatement(requete);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Integer id = rs.getInt("id");
			String prenom = rs.getString("prenom");
			String email = rs.getString("email");
			String mdp = rs.getString("mdp");
			String ddnS = rs.getString("ddn");
			LocalDate ddn;
//			if (ddnS != null) {
//				ddn = LocalDate.parse(ddnS);
//			} else ddn = LocalDate.now();
			ddn = LocalDate.parse(ddnS);
			Integer adresseId = rs.getInt("adresseId");
			String nomVoie = rs.getString("a.nomVoie");
			String ville = rs.getString("a.ville");
			String codePostal = rs.getString("a.codePostal");
			Adresse adresse = new Adresse(adresseId, nomVoie, codePostal, ville);
			
			String role = rs.getString("role");

			Stagiaire stagiaire = new Stagiaire(id, prenom, email, mdp, adresse, ddn, role);
			stagiaires.add(stagiaire);
		}
		return stagiaires;
	}

	@Override
	public Set<Stagiaire> allStagiaire(Adresse adresse) throws SQLException {
		Set<Stagiaire> stagiaires = new HashSet<Stagiaire>();
		String requete = "SELECT s.id, prenom, email, mdp, ddn, role, adresseId, a.nomVoie, a.codePostal, a.ville FROM Stagiaire s LEFT JOIN Adresse a ON s.adresseId = a.id WHERE adresseId = ?";
		PreparedStatement stmt = connection.prepareStatement(requete);
		int idAdresse = adresse.getId();
		stmt.setInt(1, idAdresse);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Integer id = rs.getInt("s.id");
			String prenom = rs.getString("prenom");
			String email = rs.getString("email");
			String mdp = rs.getString("mdp");
			String nomVoie = rs.getString("a.nomVoie");
			String ville = rs.getString("a.ville");
			String codePostal = rs.getString("a.codePostal");
			Adresse adresseIn = new Adresse(idAdresse, nomVoie, codePostal, ville);
			LocalDate ddn = rs.getDate("ddn").toLocalDate();
			String role = rs.getString("role");

			Stagiaire stagiaire = new Stagiaire(id, prenom, email, mdp, adresseIn, ddn, role);
			stagiaires.add(stagiaire);
		}
		return stagiaires;
	}

	@Override
	public Stagiaire getStagiaire(Integer id) throws SQLException {
		String requete = "SELECT prenom, email, mdp, adresseId, ddn, role FROM Stagiaire WHERE id = ?";
		PreparedStatement stmt = connection.prepareStatement(requete);
		Stagiaire stagiaire = null;
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			Integer idS = rs.getInt("id");
			String prenom = rs.getString("prenom");
			String email = rs.getString("email");
			String mdp = rs.getString("mdp");
			LocalDate ddn = rs.getDate("ddn").toLocalDate();
			String role = rs.getString("role");
			String nomVoie = rs.getString("nomVoie");
			String ville = rs.getString("ville");
			Adresse a = new Adresse (nomVoie, ville);

			stagiaire = new Stagiaire(id, prenom, email, mdp, a, ddn, role);

		}
		return stagiaire;
	}

	@Override
	public void addStagiaire(Stagiaire stagiaire, Adresse adresse) throws SQLException {
		String requete = "INSERT INTO Stagiaire(prenom, email, mdp, adresseId, ddn, role) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = connection.prepareStatement(requete);

		adresseService.addAdresses(adresse);
		stmt.setInt(4, adresse.getId());

		stmt.setString(1, stagiaire.getPrenom());
		stmt.setString(2, stagiaire.getEmail());
		stmt.setString(3, stagiaire.getMdp());
		stmt.setDate(5, Date.valueOf(stagiaire.getDdn()));
		stmt.setString(6, stagiaire.getRole());

		stmt.executeUpdate();
	}

	@Override
	public Stagiaire updateStagiaire(Stagiaire stagiaire, Adresse adresse) throws SQLException {
		String requete = "UPDATE table SET prenom=?, email=?, mdp=?, adresseId=?, ddn=?, role=? WHERE id=?";
		PreparedStatement stmt = connection.prepareStatement(requete);

		adresseService.addAdresses(adresse);
		stmt.setInt(4, adresse.getId());
		stmt.setInt(7, stagiaire.getId());

		stmt.setString(1, stagiaire.getPrenom());
		stmt.setString(2, stagiaire.getEmail());
		stmt.setString(3, stagiaire.getMdp());
		stmt.setDate(5, Date.valueOf(stagiaire.getDdn()));
		stmt.setString(6, stagiaire.getRole());

		stmt.executeUpdate();
		if (stmt.executeUpdate() == 0) {
			return null;
		}
		return stagiaire;

	}

	@Override
	public void removeStagiaire(Stagiaire stagiaire) throws SQLException {
		String requete = "DELETE FROM Stagiaire WHERE id = ?";
		PreparedStatement stmt = connection.prepareStatement(requete);
		stmt.setInt(1, stagiaire.getId());
		stmt.executeUpdate();
	}

	@Override
	public Stagiaire getStagiaire(String login, String mdp) throws SQLException {
		String requete = "SELECT s.id, prenom, email, mdp, ddn, role, a.nomVoie, a.ville FROM Stagiaire s RIGHT JOIN Adresse a ON s.adresseId = a.id WHERE email = ? AND mdp = ?";
		PreparedStatement stmt = connection.prepareStatement(requete);
		stmt.setString(1, login);
		stmt.setString(2, mdp);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Integer id = rs.getInt("s.id");
			System.out.println("id Stagiaire : " + id);
			String prenom = rs.getString("prenom");
			System.out.println("pnom Stagiaire : " + prenom);
			String email = rs.getString("email");
			String mdpS = rs.getString("mdp");
			LocalDate ddn = rs.getDate("ddn").toLocalDate();
			String role = rs.getString("role");
			String nomVoie = rs.getString("nomVoie");
			String ville = rs.getString("ville");
			Adresse a = new Adresse (nomVoie, ville);

			Stagiaire stagiaire = new Stagiaire(id, prenom, email, mdpS, a, ddn, role);
			return stagiaire;
		}
		return null;
	}

}
