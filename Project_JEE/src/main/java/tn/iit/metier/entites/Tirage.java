package tn.iit.metier.entites;

import java.io.Serializable;
import java.sql.Date;

public class Tirage implements Serializable{
	private Long id;
	private String nom_fichier;
	private String date_env;
	private String date_tret;
	private String etat;
	private String nom_ens;
	
	
	public Tirage(String nom_fichier, String date_env, String date_tret, String etat, String nom_ens) {
		super();
		this.nom_fichier = nom_fichier;
		this.date_env = date_env;
		this.date_tret = date_tret;
		this.etat = etat;
		this.nom_ens = nom_ens;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNom_fichier() {
		return nom_fichier;
	}


	public void setNom_fichier(String nom_fichier) {
		this.nom_fichier = nom_fichier;
	}


	public String getDate_env() {
		return date_env;
	}


	public void setDate_env(String date_env) {
		this.date_env = date_env;
	}


	public String getDate_tret() {
		return date_tret;
	}


	public void setDate_tret(String date_tret) {
		this.date_tret = date_tret;
	}


	public String getEtat() {
		return etat;
	}


	public void setEtat(String etat) {
		this.etat = etat;
	}


	public String getNom_ens() {
		return nom_ens;
	}


	public void setNom_ens(String nom_ens) {
		this.nom_ens = nom_ens;
	}


	@Override
	public String toString() {
		return "Tirage [id=" + id + ", nom_fichier=" + nom_fichier + ", date_env=" + date_env + ", date_tret="
				+ date_tret + ", etat=" + etat + ", nom_ens=" + nom_ens + "]";
	}




}
