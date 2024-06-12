package tn.iit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tn.iit.metier.SingletonConnection;
import tn.iit.metier.entites.Classe;



public class ClasseDaoImpl implements IClasseDao {

	@Override
	public Classe save(Classe c) {
		 Connection conn=SingletonConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("INSERT INTO CLASSE(NOM) VALUES(?)");
			ps.setString(1, c.getNom());
			ps.executeUpdate();
			
			
			PreparedStatement ps2= conn.prepareStatement
					("SELECT MAX(ID) as MAX_ID FROM CLASSE");
			ResultSet rs =ps2.executeQuery();
			
			ps.close();
			ps2.close();
				 
					
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return c;
	}



	@Override
	public Classe getClasse(Long id) {
		    
		   Connection conn=SingletonConnection.getConnection();
		    Classe c = new Classe();
	       try {
			PreparedStatement ps= conn.prepareStatement("select * from CLASSE where ID = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if  (rs.next()) {
				
				c.setId(rs.getLong("ID"));
				c.setNom(rs.getString("NOM"));
				
			}
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			return c;
	}

	



	
	

	@Override
	public Classe updateClasse(Classe c) {
		Connection conn=SingletonConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("UPDATE CLASSE SET NOM=? WHERE ID=?");
			ps.setString(1, c.getNom());
			ps.setLong(2, c.getId());
			ps.executeUpdate();
			ps.close();
					
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public void deleteClasse(Long id) {
		 Connection conn=SingletonConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("DELETE FROM CLASSE WHERE ID = ?");
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}



	
	@Override
	public List<Classe> classeParMC(String mc) {
	      List<Classe> clas= new ArrayList<Classe>();
	       Connection conn=SingletonConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("select * from CLASSE where NOM LIKE ?");
			ps.setString(1, "%"+mc+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Classe c = new Classe();
				c.setId(rs.getLong("ID"));
				c.setNom(rs.getString("NOM"));
				
				
				clas.add(c);								
			}
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

			return clas;
	}

}