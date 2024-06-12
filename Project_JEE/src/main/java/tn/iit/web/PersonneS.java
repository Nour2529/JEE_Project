package tn.iit.web;

import java.util.ArrayList;
import java.util.List;

import tn.iit.metier.entites.Classe;
import tn.iit.metier.entites.Matiere;
import tn.iit.metier.entites.Personne;

public class PersonneS {
	private String motCle;
	List<Personne> personne = new ArrayList<>();
	
	
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public List<Personne> getPersonne() {
		return personne;
	}
	public void setPersonne(List<Personne> personne) {
		this.personne = personne;
	}
	
	

}