package tn.iit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tn.iit.metier.SingletonConnection;
import tn.iit.metier.entites.Classe;
import tn.iit.metier.entites.Personne;



public class PersonneDaoImpl implements IPersonneDao {

	@Override
	public Personne save(Personne p) {
		 Connection conn=SingletonConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("INSERT INTO PERSONNE(NOM,PRENOM,LOGIN,MDP,TYPE) VALUES(?,?,?,?,?)");
			ps.setString(1, p.getNom());
			ps.setString(2, p.getPrenom());
			ps.setString(3, p.getLogin());
			ps.setString(4, p.getMdp());
			ps.setString(5, p.getType());
			ps.executeUpdate();
			
			
			PreparedStatement ps2= conn.prepareStatement
					("SELECT MAX(ID) as MAX_ID FROM PERSONNE");
			ResultSet rs =ps2.executeQuery();
			
			ps.close();
			ps2.close();
				 
					
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return p;
	}



	@Override
	public Personne getPersonne(Long id) {
		    
		   Connection conn=SingletonConnection.getConnection();
		   Personne p = new Personne();
	       try {
			PreparedStatement ps= conn.prepareStatement("select * from PERSONNE where ID = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if  (rs.next()) {
				
				p.setId(rs.getLong("ID"));
				p.setNom(rs.getString("NOM"));
				p.setPrenom(rs.getString("PRENOM"));
				p.setLogin(rs.getString("LOGIN"));
				p.setMdp(rs.getString("MDP"));
				p.setType(rs.getString("TYPE"));
				
			}
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			return p;
	}

	



	
	

	@Override
	public Personne updatePersonne(Personne p) {
		Connection conn=SingletonConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("UPDATE PERSONNE SET NOM=? WHERE ID=?");
			ps.setString(1, p.getNom());
			ps.setLong(2, p.getId());
			ps.executeUpdate();
			ps.close();
					
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public void deletePersonne(Long id) {
		 Connection conn=SingletonConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("DELETE FROM PERSONNE WHERE ID = ?");
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}



	
	@Override
	public List<Personne> personneParMC(String mc) {
	      List<Personne> clas= new ArrayList<Personne>();
	       Connection conn=SingletonConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("select * from PERSONNE where NOM LIKE ?");
			ps.setString(1, "%"+mc+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Personne p = new Personne();
				p.setId(rs.getLong("ID"));
				p.setNom(rs.getString("NOM"));
				p.setPrenom(rs.getString("PRENOM"));
				p.setLogin(rs.getString("LOGIN"));
				p.setMdp(rs.getString("MDP"));
				p.setType(rs.getString("TYPE"));
				
				clas.add(p);								
			}
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

			return clas;
	}

}