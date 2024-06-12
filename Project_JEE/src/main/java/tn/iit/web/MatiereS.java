package tn.iit.web;

import java.util.ArrayList;
import java.util.List;

import tn.iit.metier.entites.Classe;
import tn.iit.metier.entites.Matiere;

public class MatiereS {
	private String motCle;
	List<Matiere> matiere = new ArrayList<>();
	
	
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public List<Matiere> getClasse() {
		return matiere;
	}
	public void setMatiere(List<Matiere> matiere) {
		this.matiere = matiere;
	}
	
	

}