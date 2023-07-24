package fr.inetum.tp.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.inetum.tp.entites.Adresse;

public class AdresseService implements IAdresseService {

	@Override
	public ArrayList<Adresse> allAdresse() {
		ArrayList<Adresse> listAdresses = new ArrayList<Adresse>();
		String req ="SELECT * FROM adresse";
		
		Connection con = MaConnexion.getInstance().getConnection();
		try {
			PreparedStatement st = con.prepareStatement(req);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Adresse adresse = new Adresse(
						rs.getInt("id"),
						rs.getString("nomVoie"),
						rs.getString("codePostal"),
						rs.getString("ville"));
				listAdresses.add(adresse);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listAdresses;
	}

	@Override
	public Adresse readAdresse(int id) {
		Adresse adresse = new Adresse();
		String req ="SELECT * FROM adresse WHERE id=?";
		
		Connection con = MaConnexion.getInstance().getConnection();
		try {
			PreparedStatement st = con.prepareStatement(req);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			rs.next();
			adresse.setId(rs.getInt("id"));
			adresse.setNomVoie(rs.getString("nomVoie"));
			adresse.setCodePostal(rs.getString("codePostal"));
			adresse.setVille(rs.getString("ville"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adresse;
	}

	@Override
	public Adresse addAdresse(Adresse adresse) {
		String req = "INSERT INTO adresse VALUES (null,?,?,?)";
		Connection con = MaConnexion.getInstance().getConnection();
		try {
			PreparedStatement st = con.prepareStatement(req);
			st.setString(1, adresse.getNomVoie());
			st.setString(2, adresse.getCodePostal());
			st.setString(3, adresse.getVille());
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adresse;
	}
}
