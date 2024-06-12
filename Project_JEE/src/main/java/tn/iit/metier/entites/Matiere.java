package tn.iit.metier.entites;

import java.io.Serializable;

public class Matiere implements Serializable{
	private Long id;
	private String nom;
	private int id_ens;
	private int id_class;
	
	public Matiere() {
		super();
	}
	public Matiere(String nom,int id_ens,int id_class) {
		super();
		this.nom = nom;
		this.id_ens = id_ens;
		this.id_class = id_class;
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getId_ens() {
		return id_ens;
	}
	public void setId_ens(int id_ens) {
		this.id_ens = id_ens;
	}
	public int getId_class() {
		return id_class;
	}
	public void setId_class(int id_class) {
		this.id_class = id_class;
	}
	@Override
	public String toString() {
		return "Matiere [id=" + id + ", nom=" + nom + ", id_ens=" + id_ens + ", id_class=" + id_class + "]";
	}

	


	
	
	
}
