package tn.iit.metier.entites;

import java.io.Serializable;

public class Personne implements Serializable{
	private Long id;
	private String nom;
	private String prenom;
	private String login;
	private String mdp;
	private String type;
	
	
	public Personne() {
		super();
	}
	public Personne(String nom,String prenom,String login,String mdp,String type) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.mdp = mdp;
		this.type = type;
		
		
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", mdp=" + mdp
				+ ", type=" + type + "]";
	}
	
	
	
	
	
}
