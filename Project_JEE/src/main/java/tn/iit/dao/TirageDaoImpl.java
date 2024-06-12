package tn.iit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tn.iit.metier.SingletonConnection;
import tn.iit.metier.entites.Classe;
import tn.iit.metier.entites.Tirage;



public class TirageDaoImpl implements ITirageDao {

	@Override
	public Tirage save(Tirage t) {
		 Connection conn=SingletonConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("INSERT INTO DEMANDE_TIR(NOM_FICHIER,DATE_ENV, DATE_TRET,ETAT,NOM_ENS) VALUES(?,?,?,?,?)");
			ps.setString(1, t.getNom_fichier());
			ps.setString(2, t.getDate_env());
			ps.setString(3, t.getDate_tret());
			ps.setString(4, t.getEtat());
			ps.setString(5, t.getNom_ens());
			ps.executeUpdate();
			
			
			PreparedStatement ps2= conn.prepareStatement
					("SELECT MAX(ID) as MAX_ID FROM DEMANDE_TIR");
			ResultSet rs =ps2.executeQuery();
			
			ps.close();
			ps2.close();
				 
					
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return t;
	}



	@Override
	public Tirage getTirage(Long id) {
		    
		   Connection conn=SingletonConnection.getConnection();
		   Tirage t = new Tirage(null, null, null, null, null);
	       try {
			PreparedStatement ps= conn.prepareStatement("select * from DEMANDE_TIR where ID = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if  (rs.next()) {
				
				t.setId(rs.getLong("ID"));
				t.setNom_fichier(rs.getString("NOM_FICHIER"));
				t.setDate_env(rs.getString("DATE_ENV"));
				t.setDate_tret(rs.getString("DATE_TRET"));
				t.setEtat(rs.getString("ETAT"));
				t.setNom_ens(rs.getString("NOM_ENS"));
				
			}
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			return t;
	}

	



	
	

	@Override
	public Tirage updateTirage(Tirage t) {
		Connection conn=SingletonConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("UPDATE DEMANDE_TIR SET NOM_FICHIER=? WHERE ID=?");
			ps.setString(1, t.getNom_fichier());
			ps.setLong(2, t.getId());
			ps.executeUpdate();
			ps.close();
					
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public void deleteTirage(Long id) {
		 Connection conn=SingletonConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("DELETE FROM DEMANDE_TIR WHERE ID = ?");
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}



	
	@Override
	public List<Tirage> tirageParMC(String mc) {
	      List<Tirage> clas= new ArrayList<Tirage>();
	       Connection conn=SingletonConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("select * from DEMANDE_TIR where NOM_FICHIER LIKE ?");
			ps.setString(1, "%"+mc+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Tirage c = new Tirage(mc, mc, mc, mc, mc);
				c.setId(rs.getLong("ID"));
				c.setNom_fichier(rs.getString("NOM_FICHIER"));
				c.setDate_env(rs.getString("DATE_ENV"));
				c.setDate_tret(rs.getString("DATE_TRET"));
				c.setEtat(rs.getString("ETAT"));
				c.setNom_ens(rs.getString("NOM_ENS"));
				
				clas.add(c);								
			}
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

			return clas;
	}

}