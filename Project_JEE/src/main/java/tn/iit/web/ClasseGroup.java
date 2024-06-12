package tn.iit.web;

import java.util.ArrayList;
import java.util.List;

import tn.iit.metier.entites.Classe;

public class ClasseGroup {
	private String motCle;
	List<Classe> classe = new ArrayList<>();
	
	
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public List<Classe> getClasse() {
		return classe;
	}
	public void setClasse(List<Classe> classe) {
		this.classe = classe;
	}
	
	

}