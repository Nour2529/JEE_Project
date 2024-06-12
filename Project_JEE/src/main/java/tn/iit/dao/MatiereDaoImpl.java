package tn.iit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tn.iit.metier.SingletonConnection;
import tn.iit.metier.entites.Classe;
import tn.iit.metier.entites.Matiere;



public class MatiereDaoImpl implements IMatiereDao {

	@Override
	public Matiere save(Matiere m) {
		 Connection conn=SingletonConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("INSERT INTO MATIERE (NOM,ID_ENS, ID_CLASS) VALUES(?,?,?)");
			ps.setString(1, m.getNom());
			ps.setInt(2, m.getId_ens());
			ps.setInt(3, m.getId_class());
			ps.executeUpdate();
			
			
			PreparedStatement ps2= conn.prepareStatement
					("SELECT MAX(ID) as MAX_ID FROM MATIERE");
			ResultSet rs =ps2.executeQuery();
			
			ps.close();
			ps2.close();
				 
					
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return m;
	}



	@Override
	public Matiere getMatiere(Long id) {
		    
		   Connection conn=SingletonConnection.getConnection();
		   Matiere m = new Matiere();
	       try {
			PreparedStatement ps= conn.prepareStatement("select * from MATIERE where ID = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if  (rs.next()) {
				
				m.setId(rs.getLong("ID"));
				m.setNom(rs.getString("NOM"));
				m.setId_ens(rs.getInt("ID_ENS"));
				m.setId_ens(rs.getInt("ID_CLASS"));
				
			}
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			return m;
	}

	



	
	

	@Override
	public Matiere updateMatiere(Matiere m) {
		Connection conn=SingletonConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("UPDATE MATIERE SET NOM=? WHERE ID=?");
			ps.setString(1, m.getNom());
			ps.setLong(2, m.getId());
			ps.executeUpdate();
			ps.close();
					
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public void deleteMatiere(Long id) {
		 Connection conn=SingletonConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("DELETE FROM MATIERE WHERE ID = ?");
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}



	
	@Override
	public List<Matiere> matiereParMC(String mc) {
	      List<Matiere> mat= new ArrayList<Matiere>();
	       Connection conn=SingletonConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("select * from MATIERE where NOM LIKE ?");
			ps.setString(1, "%"+mc+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Matiere m = new Matiere();
				m.setId(rs.getLong("ID"));
				m.setNom(rs.getString("NOM"));
				
				
				mat.add(m);								
			}
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

			return mat;
	}

}